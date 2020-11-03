package pojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestLaptopDummy {

	public static void main(String[] args) throws IOException {

		RestAssured.baseURI = "http://localhost:3000";
		
		AddLaptopbyMAP a = new AddLaptopbyMAP();
		
		// add name and language
		a.setLanguage("MARATHI");
		a.setName("VIPIN");
		
		// add location
		Location l = new Location();
		l.setCity("PUNE");
		l.setState("MAHARASHTRA");
		a.setLocation(l);
				
		// add laptopn
		ArrayList<HashMap<String,Object>> laptop = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String,Object> list1 = new HashMap<String,Object>();
		list1.put("laptopname", "Mac");
		list1.put("price", "90000");
		laptop.add(list1);
		
		HashMap<String,Object> list2 = new HashMap<String,Object>();
		list2.put("laptopname", "Envy");
		list2.put("price", "99000");
		laptop.add(list2);
		
		HashMap<String,Object> list3 = new HashMap<String,Object>();
		list3.put("laptopname", "Amron");
		list3.put("price", "99000");
		laptop.add(list3);
		
		HashMap<String,Object> list4 = new HashMap<String,Object>();
		list4.put("laptopname", "ASSS");
		list4.put("price", "99000");
		laptop.add(list4);
		
		HashMap<String,Object> list5 = new HashMap<String,Object>();
		list5.put("laptopname", "MAZA");
		list5.put("price", "99000");
		laptop.add(list5);
				
		a.setLaptop(laptop);
		
		// POST data - Serialization
		String requestPostData = given().log().all().header("Content-Type", "application/json").body(a).when()
				.post("/posts/seri").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("---------------POST Request-------------" + requestPostData);

		// Covert to JSON
		JsonPath js = new JsonPath(requestPostData);
		String id = js.getString("_id");
		System.out.println("This id will be used to get the data from this request: " + id);

		
		  // GET data - DeSerialization AddPlace responseGetData=
		TestLaptopDummy responseGetData = given().log().all().pathParam("id", id).expect().defaultParser(Parser.JSON).
		 when().get("posts/getsiridata/{id}").then().log().all().assertThat().
		 statusCode(200).extract().response().as(TestLaptopDummy.class);
		String name = a.getName();
		System.out.println("---------------GET Response-------------" + a.getLaptop());
		
	/*	// Write data to excel
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Login");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		//Row row = sheet.getRow(0);
		//Cell cell =row.getCell(0);
		cell.setCellValue(name);
		
		
		try {
		FileOutputStream out = new FileOutputStream("C:\\Java Study\\Book.xlsx");
				
		workbook.write(out);
		}catch(Exception e){
			
		}
	*/	 
	}
}
