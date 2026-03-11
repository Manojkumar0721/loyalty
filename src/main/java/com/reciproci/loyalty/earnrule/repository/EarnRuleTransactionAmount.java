package com.reciproci.loyalty.earnrule.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.reciproci.loyalty.earnrule.entity.EarnRuleTransactionAmountDefs;


@Repository
public interface EarnRuleTransactionAmount extends JpaRepository<EarnRuleTransactionAmountDefs, Long>{


	List<EarnRuleTransactionAmountDefs> findByEarnRuleId(Long id);


}





