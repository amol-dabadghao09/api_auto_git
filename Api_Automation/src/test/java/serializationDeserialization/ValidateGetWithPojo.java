package serializationDeserialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.UserData;

import static io.restassured.RestAssured.*;


public class ValidateGetWithPojo {
	
	@Test
	public void getUsers() {
		RestAssured.baseURI = "https://reqres.in/";
		
		UserData userdata = 
		given().when().get("/api/users?page=2").then().extract().response().as(UserData.class);
		
		int totalpages = userdata.getTotal_pages();
		System.out.println(totalpages);
		
		
		
	}

}
