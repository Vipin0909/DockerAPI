package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import dataDriven.ExcelDataDriven;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.TestLaptopDummy;
import section11.AddLaptopbyMAP;
import section11.Location;

public class StepDefination {

	AddLaptopbyMAP a = new AddLaptopbyMAP();
	HashMap<String, Object> map1 = new HashMap<String, Object>();
	ExcelDataDriven d = new ExcelDataDriven();
	
	String requestPostData;
	public static String id;

	@Given("add laptop Payload")
	public void add_laptop_payload() throws IOException {
		
		ArrayList data = d.getData("Rest", "RestAssured");
		
				// laptiop makers
				map1.put("name", data.get(1));
				map1.put("language", data.get(2));

				// laptop location
				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("city", data.get(3));
				map2.put("state", data.get(4));
				map1.put("location", map2);
				
				// add laptop
				ArrayList<HashMap<String,Object>> laptop = new ArrayList<HashMap<String,Object>>();
				
				HashMap<String,Object> list1 = new HashMap<String,Object>();
				list1.put("laptopname", data.get(5));
				list1.put("price", data.get(6));
				laptop.add(list1);
				
				HashMap<String,Object> list2 = new HashMap<String,Object>();
				list2.put("laptopname", data.get(7));
				list2.put("price", data.get(8));
				laptop.add(list2);
				
				HashMap<String,Object> list3 = new HashMap<String,Object>();
				list3.put("laptopname", data.get(9));
				list3.put("price", data.get(10));
				laptop.add(list3);
				
						
				HashMap<String,Object> list5 = new HashMap<String,Object>();
				list5.put("laptopname", "MAZA");
				list5.put("price", "99000");
				laptop.add(list5);
						
				map1.put("laptop", laptop);
					
		
		RestAssured.baseURI = "http://localhost:3000";

	}

	@When("user called AddLaptopAPI with Post http request")
	public void user_called_with_post_http_request() {
		// POST data - Serialization
		String requestPostData = given().log().all().header("Content-Type", "application/json").body(map1).when()
				.post("/posts/seri").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("---------------POST Request-------------" + requestPostData);

	}

	@Then("API call got success")
	public void api_call_got_success_and_return_a_success_code_as() {

		
		/*
		 * // Covert to JSON JsonPath js = new JsonPath(requestPostData); id =
		 * js.getString("_id");
		 * System.out.println("This id will be used to get the data from this request: "
		 * + id);
		 */
		/*
		 * // GET data - DeSerialization AddPlace responseGetData= TestLaptopDummy
		 * responseGetData = given().log().all().pathParam("id",
		 * id).expect().defaultParser(Parser.JSON).
		 * when().get("posts/getsiridata/{id}").then().log().all().assertThat().
		 * statusCode(200).extract().response().as(TestLaptopDummy.class);
		 */

	}

}
