package UserAPI;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewUserRegister {
	
	@Test
	public void createNewUser() {
		
		RestAssured.baseURI = "http://192.168.1.5:4200/user";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("firstName","Shamal");
        requestParams.put( "lastName","Bhambere");
		requestParams.put("email","shamal.bhambere05@gmail.com");
		requestParams.put("phone","(848) 260-8022");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("shamal.bhambere05@gmail.com"), true);	
		
		String contentType = response.header("Content-Type");
		System.out.println("content type is "+contentType);
		Assert.assertEquals(contentType.contains("application/json"), true);
	}
	

	
	 
}
