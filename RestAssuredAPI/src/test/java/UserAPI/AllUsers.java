package UserAPI;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllUsers {

	@Test
	public void getAllUserResponseBody() {

		// Specify Base URI
		RestAssured.baseURI = "http://192.168.1.5:4200";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response response = httpRequest.request(Method.GET, "/user");

		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);

		Assert.assertEquals(responseBody.contains("Metkar"), true);
		Assert.assertEquals(responseBody.contains("Komal"), true);


	}

	@Test
	public void getAllUserStatusCode() {

		// Specify Base URI
		RestAssured.baseURI = "http://192.168.1.5:4200";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response response = httpRequest.request(Method.GET, "/user");

		int statusCode = response.getStatusCode();
		System.out.println("Status Code is :" + statusCode);

		AssertJUnit.assertEquals(statusCode, 200);

	}

	@Test
	public void getAllUserResponseHeaders() {

		// Specify Base URI
		RestAssured.baseURI = "http://192.168.1.5:4200";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response response = httpRequest.request(Method.GET, "/user");

//		JsonPath jsonpath  = response.jsonPath();
//		System.out.println(jsonpath.get("Content-Type"));
//        System.out.println(jsonpath.get("Content-Length"));
//		System.out.println(jsonpath.get("X-Powered-By"));
//		
		String header = response.getHeader("Content-Type");
		AssertJUnit.assertEquals(header, "application/json; charset=utf-8");
		// Assert.assertEquals(jsonpath.get("Content-Length"), "1505");

	}
}
