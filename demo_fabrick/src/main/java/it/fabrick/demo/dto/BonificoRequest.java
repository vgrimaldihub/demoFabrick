package it.fabrick.demo.dto;

import java.math.BigDecimal;

public class BonificoRequest {
	
	private Creditor creditor;
	private Adress adress;
	private String executionDate;
	private String uri;
	private String description;
	private BigDecimal amount;
	private String currency;
	private Boolean isUrgent;
	private Boolean isInstant;
	private String feeType;
	private String feeAccountId;
	private TaxRelief taxRelief;
	
	public Creditor getCreditor() {
		return creditor;
	}
	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public String getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Boolean getIsUrgent() {
		return isUrgent;
	}
	public void setIsUrgent(Boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public Boolean getIsInstant() {
		return isInstant;
	}
	public void setIsInstant(Boolean isInstant) {
		this.isInstant = isInstant;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeAccountId() {
		return feeAccountId;
	}
	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}
	public TaxRelief getTaxRelief() {
		return taxRelief;
	}
	public void setTaxRelief(TaxRelief taxRelief) {
		this.taxRelief = taxRelief;
	}

}
