package com.nikesh.customer.client;

import java.util.List;

import com.nikesh.customer.client.util.CustomerDataRequest;
import com.nikesh.customer.model.TransactionDetails;

public interface CustomerRewardClient {

	List<TransactionDetails> getAllTransactionDetails();

	TransactionDetails getRewardsByCustomerData(CustomerDataRequest customerTransactionData);

	List<Object[]> getTotalRewardPointsByCustomer();

	List<Object[]> getRewardsByMonth();

}
