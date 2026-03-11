package com.reciproci.loyalty.earnrule.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "earn_rule_transaction_point_def")
public class EarnRuleTransactionPointDefs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String markupType;
    private Long tierId;
    private Integer noOfRewards;
    
	@ManyToOne
	@JoinColumn(name = "earn_rule_id")
	private EarnRule earnRule;
	
	
	public EarnRule getEarnRule() {
		return earnRule;
	}
	public void setEarnRule(EarnRule earnRule) {
		this.earnRule = earnRule;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarkupType() {
		return markupType;
	}
	public void setMarkupType(String markupType) {
		this.markupType = markupType;
	}
	public Long getTierId() {
		return tierId;
	}
	public void setTierId(Long tierId) {
		this.tierId = tierId;
	}
	public Integer getNoOfRewards() {
		return noOfRewards;
	}
	public void setNoOfRewards(Integer noOfRewards) {
		this.noOfRewards = noOfRewards;
	}
     
}





