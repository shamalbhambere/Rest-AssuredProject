package UserAPI;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SearchByUserName {

	@Test
	public void getUserByFirstNameStatusCode() {

		RestAssured.baseURI = "http://192.168.1.5:4200/user/search";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "?by=firstName&val=Amit");

		int statusCode = response.getStatusCode();

		AssertJUnit.assertEquals(statusCode, 200);

	}

	@Test
	public void getUserByFirstNameResponseBody() {

		RestAssured.baseURI = "http://192.168.1.5:4200/user/search";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "?by=firstName&val=Amit");

		String responseBody = response.getBody().asString();

		AssertJUnit.assertEquals(responseBody.contains("Amit"), true);
	}

	@Test
	public void getUserByFirstNameResponseHeader() {

		RestAssured.baseURI = "http://192.168.1.5:4200/user/search";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "?by=firstName&val=Amit");
		
		Headers allHeader = response.headers();
		
		for(Header header : allHeader) {
			
			System.out.println(header.getName() + "-->"+header.getValue());
		}

	}

}
