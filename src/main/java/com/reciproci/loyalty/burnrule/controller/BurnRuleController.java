package com.reciproci.loyalty.burnrule.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciproci.loyalty.burnrule.model.CreateBurnRuleBean;
import com.reciproci.loyalty.burnrule.model.ViewBean;
import com.reciproci.loyalty.burnrule.model.ViewProgramBean;
import com.reciproci.loyalty.burnrule.service.BurnRuleService;
import com.reciproci.loyalty.program.model.CommonUtil;

@RestController
@RequestMapping("api/rpa/burn/rule")
public class BurnRuleController {
	
	@Autowired
	private BurnRuleService burnRuleService;
	
	@PostMapping("/v1/save")
	public ResponseEntity<Object> create(@RequestBody CreateBurnRuleBean createBean){
		burnRuleService.saveBurnRule(createBean);
		return new ResponseEntity<Object>(CommonUtil.getSuccessMessage(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/update")
	public ResponseEntity<Object> update(@RequestBody CreateBurnRuleBean createBean){
		burnRuleService.update(createBean);
		return new ResponseEntity<Object>(CommonUtil.getSuccessMessage(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/view")
	public ResponseEntity<ViewBean> view(@RequestBody Map<String, Long> requestBody) {
	    ViewBean viewBean = burnRuleService.viewBurnRule(requestBody);
	    return new ResponseEntity<>(viewBean, HttpStatus.OK);
	}
	
	@PostMapping("/v1/program/view")
	public ResponseEntity<ViewProgramBean> viewProgram(@RequestBody Map<String, Object> requestBody) {
	    ViewProgramBean details = burnRuleService.getProgramDetails(requestBody);
	    return new ResponseEntity<>(details, HttpStatus.OK);
	}
}
