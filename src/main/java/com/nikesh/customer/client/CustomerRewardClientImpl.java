package com.nikesh.customer.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nikesh.customer.client.util.CustomerDataRequest;
import com.nikesh.customer.model.TransactionDetails;
import com.nikesh.customer.repository.CustomerRewardsRepository;

public class CustomerRewardClientImpl implements CustomerRewardClient{
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerRewardClientImpl.class);
	
	@Autowired
	CustomerRewardsRepository customerRewardsRepository;

	@Override
	public TransactionDetails getRewardsByCustomerData(CustomerDataRequest customerTransactionData) {
		LOG.info("getting reward points for the customer::"+customerTransactionData.getCustomerId());
		double customerDataAmount = customerTransactionData.getAmount();
		int aboveFiftyPoints=0, aboveHundreadPoints = 0, totalPoints = 0;
		aboveFiftyPoints = (int) (customerDataAmount - 50);
		if(customerDataAmount> 100){
			aboveFiftyPoints = (int) (customerDataAmount - 50);
			aboveHundreadPoints = (int) ((customerDataAmount-100)*2);
		}
				
		totalPoints = aboveHundreadPoints+aboveFiftyPoints;		
		TransactionDetails customerTransaction = new TransactionDetails();
		customerTransaction.setAmount(customerDataAmount);
		customerTransaction.setCustomerid(customerTransactionData.getCustomerId());
		customerTransaction.setUpdateddate(customerTransactionData.getTransactionDate());
		TransactionDetails transactionDetails = customerRewardsRepository.save(customerTransaction);
		return transactionDetails;
	}
	
	@Override
	public List<TransactionDetails> getAllTransactionDetails() {
		LOG.info("getting all the transation details.....");
		return customerRewardsRepository.findAll();
	}

	@Override
	public List<Object[]> getTotalRewardPointsByCustomer() {
		LOG.info("calling method getTotalRewardPointsByCustomer....");
		return customerRewardsRepository.getTotalRewardPointsByCustomer();
	}

	@Override
	public List<Object[]> getRewardsByMonth() {
		LOG.info("calling method getRewardsByMonth....");
		return customerRewardsRepository.getRewardsByMonth();
	}

}
