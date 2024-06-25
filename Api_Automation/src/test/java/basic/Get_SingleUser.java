package basic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Get_SingleUser {
	
	@Test
	public void getSingleUserDetail() {
		RestAssured.baseURI = "https://reqres.in/";
		
		Response response = given().when().get("/api/users/2").then().extract().response();
		String stringresp = response.asPrettyString();
		System.out.println(stringresp);
		
	}

}
