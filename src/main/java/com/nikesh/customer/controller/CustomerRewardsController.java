package com.nikesh.customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nikesh.customer.client.util.CustomerDataRequest;
import com.nikesh.customer.model.TransactionDetails;
import com.nikesh.customer.service.CustomerRewardService;

@RestController
@RequestMapping("/customer/transaction")
@CrossOrigin
public class CustomerRewardsController {

	@Autowired
	CustomerRewardService customerRewardService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerRewardsController.class);

	/*
	 * This method can be used to get the calculated reward point by customer data i.e. by customer ID
	 * @param CustomerDataRequest
	 * 
	 * @return TransactionDetails
	 */
	@RequestMapping(value = "/rewards", method = RequestMethod.POST)
	public ResponseEntity<TransactionDetails> rewardsByCustomer(CustomerDataRequest customerData) {
		TransactionDetails customerTransacionDetails =  customerRewardService.getRewardsByCustomerData(customerData);
		if(null!= customerTransacionDetails){
			new ResponseEntity<TransactionDetails>(customerTransacionDetails, HttpStatus.OK); 
		}
		return new ResponseEntity<TransactionDetails>(HttpStatus.NOT_FOUND);
		
	}
	
	/*
	 * This method can be used to get all the transaction details so that we can display the data on UI if required
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<TransactionDetails> getAllTransactionDetails() {
		LOG.debug("getting all the transactional data.....");
		return customerRewardService.getAllTransactionDetails();
	}
	
	/*
	 * returns the report data(data by month and by customer) for all customers 
	 */
	@RequestMapping(value = "/rewardsReport", method = RequestMethod.GET)
	public ResponseEntity<Map> completeRewardsData() {
		LOG.debug("getting all the reward information data.....");
		List<Object[]> customerRewardsReport = customerRewardService.getRewardsByMonth();
		List<Object[]> totalRewardsPoints = customerRewardService.getTotalRewardPointsByCustomer();
		Map<String, Object> reportData = new HashMap<String, Object>();
		reportData.put("customerRewardsReport", customerRewardsReport);
		reportData.put("totalRewardsPoints", totalRewardsPoints);
		return new ResponseEntity<Map>(reportData, HttpStatus.OK); 
	}

}
