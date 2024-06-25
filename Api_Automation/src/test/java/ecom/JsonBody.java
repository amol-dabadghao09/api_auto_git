package ecom;

public class JsonBody {
	
	public static String getLoginBody() {
		
		String s = "{\r\n"
				+ "  \"userEmail\": \"amol.dabadghao@gmail.com\",\r\n"
				+ "  \"userPassword\": \"Amol0099\"\r\n"
				+ "}";
		return s ;
		
	}
	
	public static String getOrderBody(String prdid) {
		
		String s = "{\"orders\": [\r\n"
				+ "        {\r\n"
				+ "            \"country\": \"India\",\r\n"
				+ "            \"productOrderedId\": \""+prdid+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		
		return s;
	}
	

}
