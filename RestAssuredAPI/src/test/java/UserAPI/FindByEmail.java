package UserAPI;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FindByEmail {

	@Test
	public void getUserByEmail_StatusCode() {

		RestAssured.baseURI = "http://192.168.1.5:4200/user/findByEmail";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/audvik.metkar@gmail.com");

		int statusCode = response.getStatusCode();
		System.out.println("Find By Email Status code is :"+statusCode);

		//Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void getUserByEmail_ResponseBody() {

		RestAssured.baseURI = "http://192.168.1.5:4200/user/findByEmail";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/audvik.metkar@gmail.com");

		//String responseBody = response.getBody().asString();
		
		JsonPath jsonpath = response.jsonPath();
		
		System.out.println(jsonpath.get("email"));

		//Assert.assertEquals(jsonpath.get("email"),"audvik.metkar@gmail.com");
	}

	@Test
	public void getUserByFirstNameResponseHeader() {

		RestAssured.baseURI = "http://192.168.1.5:4200/user/findByEmail";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/shamal.bhambere@gmail.com");

		Headers allHeader = response.headers();
		
		for(Header header : allHeader) {
			
			System.out.println(header.getName() + "-->"+header.getValue());
		}

	}


}
