package com.reciproci.loyalty.earnrule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reciproci.loyalty.earnrule.entity.Language;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Long>{

}
