Feature: Add Laptop data into database


Scenario: Verify that user is added into database
	Given a POST request to database
	When username & password hit the url
	Then API call should give a success 200
	

