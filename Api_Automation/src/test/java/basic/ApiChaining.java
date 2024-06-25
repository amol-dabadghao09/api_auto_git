package basic;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiChaining {
	
	String messageValue ;
	
	@Test(priority = 1)
	public void createUserForApp() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
		Response response =
		given().header("Content-Type", "application/json").body(JsonBody.getBody())
		.log().all()
		.when().post("/user").then().log().all().extract().response();
		
	//	String resp = response.asPrettyString();
		
		JsonPath jp = response.jsonPath();
		messageValue = jp.getString("message");
	}
	
	@Test(priority = 2)
	public void GetUserDetail() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
		Response response1 = 
		given().log().all().when().get("user/CarterssJohn99").then().log().all().extract().response();
		
		JsonPath js = response1.jsonPath();
		String idValue = js.getString("id");
		
		Assert.assertEquals(messageValue, idValue);
		
	}

}
