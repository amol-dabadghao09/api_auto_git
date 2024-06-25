package basic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Post_CreateUser {
	
	@Test
	public void createUserOfApp() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
		Response response = 		
		given().header("Content-Type", "application/json")
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"amdJohn0099\",\r\n"
				+ "  \"firstName\": \"amdJ\",\r\n"
				+ "  \"lastName\": \"johnS\",\r\n"
				+ "  \"email\": \"johnamd@abc.com\",\r\n"
				+ "  \"password\": \"amol@1234\",\r\n"
				+ "  \"phone\": \"1234567890\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		.when()
		.post("/user")
		.then().extract().response();
		
		String strResp = response.asPrettyString();
		System.out.println(strResp);
		
		
	}

}
