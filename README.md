# Customer Reward Program Spring boot application

This application allows us to access the REST end point resources over CustomerRewardsController which provides 3 resources as mentioned below:

1) /customer/transaction/all to get all transaction details of the application for all the customers
2) /customer/transaction/rewards to calculate the rewards for a given customer data
3) /customer/transaction/rewardsReport to get all the customer related info by month and by customer basis all reward points

This code allows us to provide security over Basic Authentication using WebSecurityConfig

We can create an docker image over docker-compose.yml file that can be deployed to any kube pod

The code uses spring-jpa for ORM mapping over MYSQL database which saves the customer "transactiondetails"

We can further verify the test cases using spring-test module provided MockMvcResultMatchers class

Run the application using below command
mvn spring-boot:run

RUn the application over profiles using -Dspring.profiles.active=<tst>/<prd>