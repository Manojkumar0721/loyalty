package com.reciproci.loyalty.earnrule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reciproci.loyalty.earnrule.entity.Country;
@Repository
public interface CountryRepo extends JpaRepository<Country, Long>{

	Country findByCountryName(String countryName);

}



