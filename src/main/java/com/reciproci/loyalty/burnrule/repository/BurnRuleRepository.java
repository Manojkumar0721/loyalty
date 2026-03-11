package com.reciproci.loyalty.burnrule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reciproci.loyalty.burnrule.entity.BurnRule;

@Repository
public interface BurnRuleRepository extends JpaRepository<BurnRule, Long>{

	boolean existsByProgramId(Long programId);

}
