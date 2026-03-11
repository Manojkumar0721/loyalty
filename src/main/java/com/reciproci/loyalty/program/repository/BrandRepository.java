package com.reciproci.loyalty.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reciproci.loyalty.brand.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

}
