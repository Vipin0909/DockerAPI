Feature: Add Bank data into database

@createuser
Scenario: Verify that user can add Bank details into database
	Given Bank Details 
	When POST request is subbmitted 
	Then API call got success 200
	

