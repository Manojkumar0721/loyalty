package com.reciproci.loyalty.earnrule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reciproci.loyalty.earnrule.entity.Store;
@Repository
public interface StoreRepo extends JpaRepository<Store, Long>{
}



