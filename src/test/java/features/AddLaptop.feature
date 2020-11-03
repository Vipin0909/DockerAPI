Feature: Add Laptop data into database


Scenario: Verify that user can add laptop details into database
	Given add laptop Payload
	When user called AddLaptopAPI with Post http request
	Then API call got success
	

