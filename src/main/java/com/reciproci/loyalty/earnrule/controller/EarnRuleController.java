package com.reciproci.loyalty.earnrule.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.reciproci.loyalty.earnrule.model.CreateEarnBean;
import com.reciproci.loyalty.earnrule.model.EarnViewBean;
import com.reciproci.loyalty.earnrule.model.EarnViewRequestBean;
import com.reciproci.loyalty.earnrule.model.GetDetailsBean;
import com.reciproci.loyalty.earnrule.service.EarnRuleService;
import com.reciproci.loyalty.program.model.CommonUtil;


@RestController
@RequestMapping("api/rpa/loyalty/earnrule")
public class EarnRuleController {
	@Autowired
	private EarnRuleService earnRuleService;
	
	@PostMapping("/v1/create")
	public ResponseEntity<Object> create(@RequestBody CreateEarnBean createBean){
		earnRuleService.create(createBean);
		return new ResponseEntity<Object>(CommonUtil.getSuccessMessage(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/view")
	public EarnViewBean view(@RequestBody EarnViewRequestBean createBean) {
		return earnRuleService.view(createBean);
	}
	
	@GetMapping("v1/get/list")
	public List<GetDetailsBean> viewEarnRuleOnProgramId(@RequestParam("programId") Long programId) {
		return earnRuleService.viewEarnRuleOnProgramId(programId);
	}
	
	@PostMapping("/v1/update")
	public ResponseEntity<Object> upate(@RequestBody CreateEarnBean createBean) {
		earnRuleService.update(createBean);
		return new ResponseEntity<Object>(CommonUtil.getSuccessMessage(),HttpStatus.OK);
	}
}





