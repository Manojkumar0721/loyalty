package com.reciproci.loyalty.tier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reciproci.loyalty.tier.entity.TierConfig;

@Repository
public interface TierRepository extends JpaRepository<TierConfig, Long>{
	


}
