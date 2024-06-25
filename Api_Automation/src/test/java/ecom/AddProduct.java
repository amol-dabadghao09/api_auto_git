package ecom;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddProduct extends BaseData {
	String path = System.getProperty("user.dir");
		
	@Test
	public void addProductToApp() {
		
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		Response productresp =
		
		given().header("Authorization", token)
		.param("productName", "Casual Jeans")
		.param("productAddedBy", userid)
		.param("productCategory", "fashion")
		.param("productSubCategory", "Trouser")
		.param("productPrice", "1500")
		.param("productDescription", "Levis")
		.param("productFor", "Men")
		.multiPart("productImage", new File("src\\test\\resources\\testImages\\Levisjeans.png"))
		.log().all()
		.when().post("api/ecom/product/add-product")
		.then().log().all().extract().response();
		
		JsonPath js = productresp.jsonPath();
		
		productid = js.getString("productId");
		
	}

}
