package basic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchData_By_JSONClasspath {
	
	@Test
	public void getValue() {
		RestAssured.baseURI = "https://reqres.in/";
		
		Response response = given().when().get("/api/users?page=2").then().extract().response();
		
		String resp = response.asPrettyString();
		 
		JsonPath jp = new JsonPath(resp); 
		
		System.out.println(jp.getInt("total"));
		
		
	}

}
