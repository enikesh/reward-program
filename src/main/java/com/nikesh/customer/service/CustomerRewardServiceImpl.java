package com.nikesh.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikesh.customer.client.CustomerRewardClient;
import com.nikesh.customer.client.util.CustomerDataRequest;
import com.nikesh.customer.model.TransactionDetails;

@Service
public class CustomerRewardServiceImpl implements CustomerRewardService {

	@Autowired
	CustomerRewardClient customerRewardClient;

	public List<TransactionDetails> getAllTransactionDetails() {
		List<TransactionDetails> customerRewards = customerRewardClient.getAllTransactionDetails();
		return customerRewards;
	}

	@Override
	public TransactionDetails getRewardsByCustomerData(CustomerDataRequest customerTransactionData) {
		return customerRewardClient.getRewardsByCustomerData(customerTransactionData);
	}

	@Override
	public List<Object[]> getTotalRewardPointsByCustomer() {
		return customerRewardClient.getTotalRewardPointsByCustomer();
	}

	@Override
	public List<Object[]> getRewardsByMonth() {
		return customerRewardClient.getRewardsByMonth();
	}

}