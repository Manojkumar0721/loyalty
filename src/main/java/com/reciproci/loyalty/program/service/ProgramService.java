package com.reciproci.loyalty.program.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.reciproci.loyalty.brand.entity.Brand;
import com.reciproci.loyalty.program.entity.Program;
import com.reciproci.loyalty.program.model.CreateProgramBean;
import com.reciproci.loyalty.program.model.SearchResponse;
import com.reciproci.loyalty.program.model.ViewBean;
import com.reciproci.loyalty.program.repository.BrandRepository;
import com.reciproci.loyalty.program.repository.ProgramRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProgramService {
	
	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private BrandRepository brandRepository;

	public void createbean(CreateProgramBean bean) {
		Program program = new Program();
		program.setStatus(bean.getStatus());
		program.setProgramType(bean.getProgramType());
		program.setProgramName(bean.getProgramName());
		program.setProgramDiscription(bean.getProgramDiscription());
		program.setProgramImgpath(bean.getProgramImgpath());
		program.setRewardType(bean.getRewardType());
		program.setStartDate(bean.getStartDate());
		program.setEndDate(bean.getEndDate());
		program.setStartTime(bean.getStartTime());
		program.setEndTime(bean.getEndTime());
		program.setPointExpiryIn(bean.getPointExpiryIn());
		program.setExpiryDays(bean.getExpiryDays());
		program.setExpireDate(bean.getExpireDate());
		program.setSkuFilePath(bean.getSkuFilePath());
		program.setPrepetual(bean.isPrepetual());
		program.setCreatedTime(LocalDateTime.now());
		program.setModifiedTime(LocalDateTime.now());
		
		Optional<Brand> byId = brandRepository.findById(bean.getBrandId());
		Brand brand = byId.get();
		brand.setProgram(program);
		program.setBrand(brand);
		
		programRepository.save(program);
		
	}
	
	public ViewBean view(Program program) {
		Optional<Program> byId = programRepository.findById(program.getId());
		Program pro = byId.get();
		ViewBean bean = new ViewBean();
		bean.setProgramId(pro.getId());
		bean.setStatus(pro.getStatus());
		bean.setProgramType(pro.getProgramType());
		bean.setProgramName(pro.getProgramName());
		bean.setProgramDescription(pro.getProgramDiscription());
		bean.setProgramImgPath(pro.getProgramImgpath());
		bean.setRewardType(pro.getRewardType());
		bean.setStartDate(pro.getStartDate());
		bean.setEndDate(pro.getEndDate());
		bean.setStartTime(pro.getStartTime());
		bean.setEndTime(pro.getEndTime());
		bean.setPointExpiryIn(pro.getPointExpiryIn());
		bean.setExpireDate(pro.getExpireDate());
		bean.setExpiryDays(pro.getExpiryDays());
		bean.setSkuFilePath(pro.getSkuFilePath());
		bean.setPerpetual(pro.isPrepetual());
		bean.setCreatedTime(pro.getCreatedTime());
		bean.setModifiedTime(pro.getModifiedTime());
		bean.setBrand(pro.getBrand());
		return bean;
	}

	@Transactional
	public void update(ViewBean pro) {
	    // 1. Use ifPresent or orElseThrow to handle missing data gracefully
	    programRepository.findById(pro.getProgramId()).ifPresentOrElse(existing -> {
	       
	        // 2. Map fields from Bean to Entity
	        existing.setStatus(pro.getStatus());
	        existing.setProgramType(pro.getProgramType());
	        existing.setProgramName(pro.getProgramName());
	        existing.setProgramDiscription(pro.getProgramDescription());
	        existing.setProgramImgpath(pro.getProgramImgPath());
	        existing.setRewardType(pro.getRewardType());
	        existing.setStartDate(pro.getStartDate());
	        existing.setEndDate(pro.getEndDate());
	        existing.setStartTime(pro.getStartTime());
	        existing.setEndTime(pro.getEndTime());
	        existing.setPointExpiryIn(pro.getPointExpiryIn());
	        existing.setExpireDate(pro.getExpireDate());
	        existing.setExpiryDays(pro.getExpiryDays());
	        existing.setSkuFilePath(pro.getSkuFilePath());
	        existing.setPrepetual(pro.isPerpetual());
	        Optional<Brand> byId = brandRepository.findById(pro.getBrand().getId());
	        existing.setBrand(byId.get());
	        byId.get().setProgram(existing);
	        existing.setModifiedTime(LocalDateTime.now());
	        // 4. Save is optional if @Transactional is used, but good for clarity
	        programRepository.save(existing);
	       
	    }, () -> {
	        // Handle the "Not Found" case
	        throw new EntityNotFoundException("Program not found with ID: " + pro.getProgramId());
	    });
	}
	
	public SearchResponse search(SearchResponse response) {
		
		Sort.Direction direction = Sort.Direction.ASC;
		String sortColumn = "id";
		
		if(response.getOrder() != null) {
			if("DEC".equalsIgnoreCase(response.getOrder().getDir())) {
				direction = Sort.Direction.DESC;
			}
			
			if(response.getOrder().getColumn() != null && !response.getOrder().getColumn().isEmpty()) {
				sortColumn = response.getOrder().getColumn();
			}
		}
		
		Pageable pageable = PageRequest.of(response.getPage(), response.getPageSize(), Sort.by(direction, sortColumn));
		
		Page<Program> all = programRepository.findAll(pageable);
		List<SearchResponse.SearchItem> arrayList = new ArrayList<>();
		
		for(Program program : all) {
			SearchResponse.SearchItem searchItem = response.new SearchItem();
			searchItem.setProgramId(program.getId());
			searchItem.setBrandId(program.getBrand().getId());
			searchItem.setBrandName(program.getBrand().getBrandName());
			searchItem.setProgramName(program.getProgramName());
			searchItem.setReward(program.getRewardType());
			searchItem.setEndDate(program.getEndDate());
			searchItem.setModifiedTime(program.getModifiedTime());
			searchItem.setStatus(program.getStatus());
			arrayList.add(searchItem);
		}
		response.setTotalCoant(arrayList.size());
		response.setSearchItems(arrayList);
		return response;
	}





}
