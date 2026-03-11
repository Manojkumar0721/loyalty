package com.reciproci.loyalty.tier.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reciproci.loyalty.tier.entity.TierRegion;

@Repository
public interface TierRegionRepository extends JpaRepository<TierRegion, Long>{

	boolean existsByCountryId(Long countryId);

	Optional<TierRegion> findByCountryId(Long countryId);
	
	@Query("SELECT DISTINCT tr FROM TierRegion tr LEFT JOIN FETCH tr.tierList")
    List<TierRegion> findAllWithTiers();

}
