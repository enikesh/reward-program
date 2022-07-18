package com.nikesh.customer.client.util;

import java.util.Date;

public class CustomerDataRequest {
	
	private String customerId;
	private Date TransactionDate;
	private Double amount;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CustomerRewardRequest [customerId=" + customerId + ", TransactionDate=" + TransactionDate + ", amount="
				+ amount + "]";
	}
	
}
