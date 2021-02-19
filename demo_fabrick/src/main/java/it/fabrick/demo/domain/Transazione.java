package it.fabrick.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Transazione")
public class Transazione {
	
	@Id
	@Column(name="TRANSACTION_ID",nullable=false)
	private String transactionId;
	@Column(name="OPERATION_ID",nullable=false)
	private String operationId;
	@Column(name="ACCOUNTING_DATE",nullable=false)
	private String accountingDate;
	@Column(name="VALUE_DATE",nullable=true)
	private String valueDate;
	@Column(name="AMOUNT",nullable=true)
	private BigDecimal amount;
	@Column(name="CURRENCY",nullable=true)
	private String currency;
	@Column(name="DESCRIPTION",nullable=true)
	private String description;
	
	public Transazione() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}