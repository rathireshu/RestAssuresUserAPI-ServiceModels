package apiTests;

import org.testng.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import serviceClasses.GetUsersService;
import serviceClasses.RegisterUserService;

public class UsersServiceTest extends GetUsersService{	
	
	@Test
	public void getUsersTest() {
		
		
		int page = 2;
		Response rep = GetUsersService.getUser(page);
		
		Assert.assertEquals(rep.statusCode(), 200);
		Assert.assertTrue(rep.statusLine().contains("OK"));
		System.out.println(rep.getBody().jsonPath().getString("data.email"));
		
	}
	
	@Test
	public void registerUserTest() {
		
		Response res = RegisterUserService.registerUser("eve.holt@reqres.in","cityslicka");
		System.out.println("Response: " + res.getBody().asString());
		System.out.println(res.getStatusLine());
		//Assert.assertEquals(res.statusCode(), 200);
		Assert.assertTrue(res.statusLine().contains("OK"));
		System.out.println(res.getBody().jsonPath().getString("token"));
		 Assert.assertNotNull(res.jsonPath().getString("token"), "Token should not be null");
		
		
		
	}

}
