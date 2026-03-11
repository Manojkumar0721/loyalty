package com.reciproci.loyalty.earnrule.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.reciproci.loyalty.earnrule.entity.EarnRuleTransactionPointDefs;


@Repository
public interface EarnRuleTransactionPoint extends JpaRepository<EarnRuleTransactionPointDefs, Long>{


	List<EarnRuleTransactionPointDefs> findByEarnRuleId(Long id);


	List<EarnRuleTransactionPointDefs> findByTierId(Long tierId);


}





