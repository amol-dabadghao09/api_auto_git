package basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class GetValue_FromReadyJson {

	@Test
	public void practiceJson() {
		String body = "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}";
		
		JsonPath jp = new JsonPath(body);
		
		int amount = jp.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		
		int numberOfCources = jp.getInt("courses.size()");
		System.out.println(numberOfCources);
		
		System.out.println(jp.getString("courses[0].title"));
		
		for(int i=0; i<3; i++)
		{
System.out.println(jp.getString("courses["+i+"].title") + " -> " + jp.getInt("courses["+i+"].price"));
		}
		
		System.out.println(jp.getInt("courses[2].copies"));
		
		int totalValue = jp.getInt("courses[0].price") + jp.getInt("courses[1].price") + jp.getInt("courses[2].price");
		int purchaseVal = jp.getInt("dashboard.purchaseAmount");
		
	//	Assert.assertEquals(totalValue, purchaseVal);
		
		
		
	}
	
}
