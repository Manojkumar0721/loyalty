package com.reciproci.loyalty.earnrule.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reciproci.loyalty.earnrule.entity.EarnRule;

@Repository
public interface EarnRuleRepo extends JpaRepository<EarnRule, Long>{
	
	List<EarnRule> findByProgramId(Long progamId);



}




