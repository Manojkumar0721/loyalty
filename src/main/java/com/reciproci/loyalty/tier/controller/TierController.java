package com.reciproci.loyalty.tier.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciproci.loyalty.tier.model.TierLookupBean;
import com.reciproci.loyalty.tier.model.TierRegionBean;
import com.reciproci.loyalty.tier.model.TierRequestWrapperBean;
import com.reciproci.loyalty.tier.service.TierService;

@RestController
@RequestMapping("api/rpa/tier")
public class TierController {

	@Autowired
	private TierService tierService;

    @PostMapping("/v1/save")
    public ResponseEntity<Map<String, String>> saveTierQualification(@RequestBody TierRequestWrapperBean request) {
        // The Service layer handles the "Exactly 5 Tiers" logic and throws our custom exception if it fails
        tierService.saveTierQualification(request);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Tier qualifications saved successfully for " + 
                     request.getTierRegionList().size() + " regions.");
        response.put("status", "SUCCESS");
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/v1/update")
    public ResponseEntity<Map<String, String>> updateTierQualification(@RequestBody TierRequestWrapperBean request) {
        tierService.updateTierQualification(request);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Tier qualifications updated successfully.");
        response.put("status", "SUCCESS");
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/v1/view")
    public ResponseEntity<Map<String, Object>> getAllTiers() {
        List<TierRegionBean> list = tierService.getAllTierQualifications();
        
        Map<String, Object> response = new HashMap<>();
        response.put("tierRegionList", list);
        response.put("totalRegions", list.size());
        response.put("timestamp", LocalDateTime.now().toString());
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/v1/list")
    public ResponseEntity<List<TierLookupBean>> getTierList() {
        List<TierLookupBean> list = tierService.getTierLookupList();
        return ResponseEntity.ok(list);
    }
}
