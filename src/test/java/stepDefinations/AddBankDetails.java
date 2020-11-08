package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import pojo.bank.HDFCBank;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;

public class AddBankDetails {

	HDFCBank hdfc = new HDFCBank();
	HashMap<String, Object> bankmap = new HashMap<String, Object>();
	static String Response;

	@Given("Bank Details")
	public void bank_details() {

		RestAssured.baseURI = "http://localhost:8080";

		HashMap<String,Object> map0 = new HashMap<String,Object>();
		map0.put("bankname", "HDFC");
		bankmap.put("bank", map0);

		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("branchname", "Dahanukar");
		map1.put("state", "MH");
		bankmap.put("branch", map1);

		ArrayList<HashMap<String, Object>> useraccount = new ArrayList<HashMap<String, Object>>();

		HashMap<String,Object> map2 = new HashMap<String,Object>();
		map2.put("accountname", "Boby");
		map2.put("upid", "Boby@HDFC.com");
		map2.put("amount", 767676);
		useraccount.add(map2);

		HashMap<String,Object> map3 = new HashMap<String,Object>();
		map3.put("accountname", "Roma");
		map3.put("upid", "Roma@HDFC.com");
		map3.put("amount", 98988);
		useraccount.add(map3);

		HashMap<String,Object> map4 = new HashMap<String,Object>();
		map4.put("accountname", "Lisa");
		map4.put("upid", "Lisa@HDFC.com");
		map4.put("amount", 123);
		useraccount.add(map4);
		bankmap.put("useraccount", useraccount);
		

	}

	@When("POST request is subbmitted")
	public void post_request_is_subbmitted() {

		String Response = given().log().all().header("content-type", "application/json").body(bankmap).when()
				.post("/post/bankusers").then().log().all().assertThat().statusCode(200).toString();
	}

	@Then("API call got success {int}")
	public void api_call_got_success(Integer int1) {

		
	}

}
