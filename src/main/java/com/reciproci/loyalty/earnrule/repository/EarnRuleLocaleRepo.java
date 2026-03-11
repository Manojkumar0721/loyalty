package com.reciproci.loyalty.earnrule.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.reciproci.loyalty.earnrule.entity.EarnRuleLocales;


@Repository
public interface EarnRuleLocaleRepo extends JpaRepository<EarnRuleLocales, Long>{


	List<EarnRuleLocales> findByEarnRuleId(Long id);


}





