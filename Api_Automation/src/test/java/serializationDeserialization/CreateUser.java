package serializationDeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import basic.JsonBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pojo.RequestBody;


public class CreateUser {
	
	@Test
	public void createUser() {
		RequestBody requestbody = new RequestBody();
		
		requestbody.setId(0);
		requestbody.setUsername("jonathonSt99");
		requestbody.setFirstName("johnath");
		requestbody.setLastName("tyroter");
		requestbody.setEmail("johnAtrott@abc.com");
		requestbody.setPassword("johnanaT@123");
		requestbody.setPhone("9988776655");
		requestbody.setUserStatus(0);
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
		pojo.ResponseBody resBody =
		given().header("Content-Type", "application/json").body(requestbody).log().all()
		.when().post("/user").then().log().all().extract().response().as(pojo.ResponseBody.class);
		
		int code = resBody.getCode();
		System.out.println(code);
		
		String msg = resBody.getMessage();
		System.out.println(msg);
		
	}
	
}
