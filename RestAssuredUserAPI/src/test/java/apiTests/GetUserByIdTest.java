package apiTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;


public class GetUserByIdTest {
	
	@Test
	void getTestBasic() {
		
		Response res = get("https://reqres.in/api/users?page=2");
		int code= res.getStatusCode();
		System.out.println("status code:-"+code);
		System.out.println(res.contentType());
		System.out.println("status msg:-"+res.getStatusLine());
		
		System.out.println("response time :-"+res.time());
		Assert.assertEquals(code, 200);
		
	}
	@Test
	void getUserTest() {
		
		baseURI ="https://reqres.in";
//validating without storing response in response object
//use the equalTo() method from Hamcrest Matchers to assert specific values in the response body.
         
		given()
		      .header("Contant-Type","application/json")
		      .baseUri(baseURI).
	     when()
		      .get("/api/users/2")
		 .then()
		      .statusCode(200)
		      .body("data.id", equalTo(2))
		      .body("data.email", equalTo("janet.weaver@reqres.in"))
		      .body("data.first_name", equalTo("Janet")) 
		      .body("data.last_name", equalTo("Weaver")); 
     
	}
}
