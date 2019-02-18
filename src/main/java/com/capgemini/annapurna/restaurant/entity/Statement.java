package com.capgemini.annapurna.restaurant.entity;

import java.time.LocalDateTime;


public class Statement {

	private EWallet eWallet;
	private Integer statementId;
	private String transactionType;
	private Double amount;
	private LocalDateTime dateTime;
	private Integer orderId;
	private String transactionRemarks;

	public Statement() {
		super();
	}

	public Statement(EWallet eWallet, Integer statementId, String transactionType, Double amount, EWallet wallet,
			LocalDateTime dateTime, Integer orderId, String transactionRemarks) {
		super();
		this.eWallet = eWallet;
		this.statementId = statementId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.orderId = orderId;
		this.transactionRemarks = transactionRemarks;
	}

	public EWallet geteWallet() {
		return eWallet;
	}

	public void seteWallet(EWallet eWallet) {
		this.eWallet = eWallet;
	}

	public Integer getStatementId() {
		return statementId;
	}

	public void setStatementId(Integer statementId) {
		this.statementId = statementId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	@Override
	public String toString() {
		return "Statement [eWallet=" + eWallet + ", statementId=" + statementId + ", transactionType=" + transactionType
				+ ", amount=" + amount + ", dateTime=" + dateTime + ", orderId=" + orderId + ", transactionRemarks="
				+ transactionRemarks + "]";
	}

}
