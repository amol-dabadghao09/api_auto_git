package ecom;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginPage extends BaseData {
	
	@Test
	public void loginToApp() {
		RestAssured.baseURI = "https://www.rahulshettyacademy.com/";
		
		Response resp = 
		given().header("Content-Type", "application/json").body(JsonBody.getLoginBody()).log().all()
		.when().post("api/ecom/auth/login").then().log().all().extract().response();
		
	//	String 	loginResp = resp.asPrettyString();
	//	System.out.println(loginResp);
		
		JsonPath jp = resp.jsonPath();
		token = jp.getString("token");
		System.out.println(token);
		
		userid = jp.getString("userId");
		
		
	}

}
