Feature: Add Laptop data into database

@laptop
Scenario: Verify that Laptop data is added into database
	Given laptop details to insert records into database
	When POST request is submitted
	Then API call should give a success 
	

