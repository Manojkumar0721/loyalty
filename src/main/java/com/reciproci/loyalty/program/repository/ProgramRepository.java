package com.reciproci.loyalty.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reciproci.loyalty.program.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long>{

}
