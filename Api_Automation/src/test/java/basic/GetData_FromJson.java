package basic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetData_FromJson {
	
	@Test
	public void getAllUsers() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		Response response = given().when().get("api/users?page=2").then().extract().response();
		
		String resp = response.asPrettyString();
		System.out.println(resp);
		
		JsonPath jp = response.jsonPath();
		
		int totalValue = jp.getInt("total");
		System.out.println(totalValue);
		
		String textString = jp.getString("support.text");
		System.out.println(textString);
		
		System.out.println("0th index email = " +jp.getString("data[0].email"));
		
		int size = jp.getInt("data.size()");
		System.out.println("Number of elements in data = " +size);
		
		for(int i=0; i<size; i++)
		{
			String emailAdd = jp.getString("data["+i+"].email");
			
			if(emailAdd.equals("lindsay.ferguson@reqres.in"))
			{
				System.out.println(jp.getString("data["+i+"].last_name"));
			}
		}
		
	}

}
