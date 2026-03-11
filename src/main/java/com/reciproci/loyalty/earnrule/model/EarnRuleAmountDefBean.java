package com.reciproci.loyalty.earnrule.model;
import java.util.List;
public class EarnRuleAmountDefBean {
	private Long tierId;
	private String tierName;
	private List<TransactionAmountDefs> transactionAmountDefs;
	public Long getTierId() {
		return tierId;
	}
	public void setTierId(Long tierId) {
		this.tierId = tierId;
	}
	public String getTierName() {
		return tierName;
	}
	public void setTierName(String tierName) {
		this.tierName = tierName;
	}
	public List<TransactionAmountDefs> getTransactionAmountDefs() {
		return transactionAmountDefs;
	}
	public void setTransactionAmountDefs(List<TransactionAmountDefs> transactionAmountDefs) {
		this.transactionAmountDefs = transactionAmountDefs;
	}
	
}



