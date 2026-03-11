package com.reciproci.loyalty.earnrule.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "earn_rule_locales")
public class EarnRuleLocales {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long languageId;
    private String ruleName;
	private String termsAndCondition;
	private String buttonLabel;
	
	@ManyToOne
	@JoinColumn(name = "earn_rule_id")
	private EarnRule earnRule;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getLanguageId() {
		return languageId;
	}


	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}


	public String getRuleName() {
		return ruleName;
	}


	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}


	public String getTermsAndCondition() {
		return termsAndCondition;
	}


	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}


	public String getButtonLabel() {
		return buttonLabel;
	}


	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}


	public EarnRule getEarnRule() {
		return earnRule;
	}


	public void setEarnRule(EarnRule earnRule) {
		this.earnRule = earnRule;
	}
	
	
}





