package com.nikesh.customer.service;

import java.util.List;

import com.nikesh.customer.client.util.CustomerDataRequest;
import com.nikesh.customer.model.TransactionDetails;

public interface CustomerRewardService {
	List<TransactionDetails> getAllTransactionDetails();
	TransactionDetails getRewardsByCustomerData(CustomerDataRequest customerTransactionData);
	List<Object[]> getTotalRewardPointsByCustomer();
	List<Object[]> getRewardsByMonth();
}