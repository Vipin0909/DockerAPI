package section11.INTERVIEW;

// REST Assured example for Interview -- before interview look at this program

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestPlaceOne {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:3000";

		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "Hydrabad");
		map1.put("language", "Urdu");

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("city", "Parbhani");
		map2.put("state", "MH");
		map1.put("location", map2);

		// add laptop
		ArrayList<HashMap<String, Object>> laptop = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> list1 = new HashMap<String, Object>();
		list1.put("laptopname", "Mac");
		list1.put("price", "90000");
		laptop.add(list1);

		HashMap<String, Object> list2 = new HashMap<String, Object>();
		list2.put("laptopname", "Envy");
		list2.put("price", "99000");
		laptop.add(list2);

		HashMap<String, Object> list3 = new HashMap<String, Object>();
		list3.put("laptopname", "Amron");
		list3.put("price", "99000");
		laptop.add(list3);

		HashMap<String, Object> list4 = new HashMap<String, Object>();
		list4.put("laptopname", "ASSS");
		list4.put("price", "99000");
		laptop.add(list4);

		HashMap<String, Object> list5 = new HashMap<String, Object>();
		list5.put("laptopname", "MAZA");
		list5.put("price", "99000");
		laptop.add(list5);

		map1.put("laptop", laptop);
		
		HashMap<String,Object> header = new HashMap<String,Object>();
		header.put("Content-Type", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Content-Type", "application/json");
		// POST data - Serialization
		String requestPostData = given().log().all().headers(header).header("Content-Type", "application/json").body(map1).when()
				.post("/posts/seri").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("---------------POST Request-------------" + requestPostData);

		// Covert to JSON
		JsonPath js = new JsonPath(requestPostData);
		String id = js.getString("_id");
		System.out.println("This id will be used to get the data from this request: " + id);

		// GET data - DeSerialization AddPlace responseGetData=
		TestPlaceOne responseGetData = given().log().all().pathParam("id", id).expect().defaultParser(Parser.JSON)
				.when().get("posts/{id}").then().log().all().assertThat().statusCode(200).extract()
				.response().as(TestPlaceOne.class);
		// System.out.println("---------------GET Response-------------"
		// responseGetData.getName());

	}
}
