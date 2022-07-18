package com.nikesh.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nikesh.customer.model.TransactionDetails;

public interface CustomerRewardsRepository extends JpaRepository<TransactionDetails, Long> {

	@Query("select sum(rewardpoints) from transactiondetails group by customerid")
	List<Object[]> getTotalRewardPointsByCustomer();
	
	@Query("select customerid,monthname(updateddate),sum(rewardpoints) from transactiondetails group by monthname(updateddate),customerid")
	List<Object[]> getRewardsByMonth();

}
