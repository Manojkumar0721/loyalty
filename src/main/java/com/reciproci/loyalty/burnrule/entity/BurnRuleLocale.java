package com.reciproci.loyalty.burnrule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "burn_rule_locales")
public class BurnRuleLocale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ruleName;
	private String description;
	private String termsAndConditions;
	
	@ManyToOne
	@JoinColumn(name = "burn_rule_id")
	private BurnRule burnRule;

	public Long getId() {
		return id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public String getDescription() {
		return description;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public BurnRule getBurnRule() {
		return burnRule;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public void setBurnRule(BurnRule burnRule) {
		this.burnRule = burnRule;
	}
	
	

}
