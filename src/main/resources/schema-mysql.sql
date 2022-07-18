
CREATE TABLE IF NOT EXISTS transactiondetails (
  id int NOT NULL AUTO_INCREMENT,
  customerid int NOT NULL,
  rewardpoints int NOT NULL,
  amount DOUBLE NOT NULL,
  updateddate VARCHAR(200) NOT NULL,
  PRIMARY KEY('id')
);

