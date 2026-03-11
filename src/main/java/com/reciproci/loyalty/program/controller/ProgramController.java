package com.reciproci.loyalty.program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciproci.loyalty.program.entity.Program;
import com.reciproci.loyalty.program.model.CommonUtil;
import com.reciproci.loyalty.program.model.CreateProgramBean;
import com.reciproci.loyalty.program.model.SearchResponse;
import com.reciproci.loyalty.program.model.ViewBean;
import com.reciproci.loyalty.program.service.ProgramService;

@RestController
@RequestMapping("/api/rpa/loyalty/program")
public class ProgramController {
	
	@Autowired
	private ProgramService programService;
	
	@PostMapping("/v1/save")
	public ResponseEntity<Object> createProgram(@RequestBody CreateProgramBean bean){
		programService.createbean(bean);
		return new ResponseEntity<Object>(CommonUtil.getSuccessMessage(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/view")
	public ViewBean view(@RequestBody Program program){
		return programService.view(program);
	}
	
	@PostMapping("/v1/update")
	public ResponseEntity<Object> update(@RequestBody ViewBean pro){
		programService.update(pro);
		return new ResponseEntity<Object>(CommonUtil.getSuccessMessage(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/search")
	public SearchResponse search(@RequestBody SearchResponse response) {
		return programService.search(response);
	}

}
