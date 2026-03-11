package com.reciproci.loyalty.brand.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.reciproci.loyalty.program.entity.Program;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BRAND")
public class Brand {
	//comment from manoj branch

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String brandName;
	
	@OneToOne
	@JoinColumn(name = "program_id")
	@JsonBackReference
	private Program program;

	public Long getId() {
		return id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

}
