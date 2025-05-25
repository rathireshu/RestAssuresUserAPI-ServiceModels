package apiTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.CreateUserRequestPOJO;
import models.CreateUserResponsePOJO;
import serviceClasses.CreateUserService;
import utils.jsonUtil;


public class CreateUserTest extends CreateUserService {

	@Test
	public void createUserTest() throws IOException {
		
		// Step 1: Create User Object (POJO)
		// and Read User data from JSON file
		
		String jsonPath = "src/test/resources/userPayload.json";
		
		CreateUserRequestPOJO userData = jsonUtil.readFromJson(jsonPath, CreateUserRequestPOJO.class);

		String name = userData.getName();
        String job = userData.getJob();
		
        
		
        // Step 2: Call createUser post service
        Response response = CreateUserService.createUser(userData);
        
        // Convert response JSON to POJO
        CreateUserResponsePOJO responseBody = response.as(CreateUserResponsePOJO.class);        
        
        // Step 3: Validate Response
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertTrue(response.statusLine().contains("Created"));
        
    
        // Print the response for debugging
        System.out.println("Response as POJO: " + responseBody);

     // Validate response fields
        Assert.assertNotNull(responseBody.getId(), "ID is null in response!");
        Assert.assertNotNull(responseBody.getToken(), "Token is null in response!");
        
      	Assert.assertNotNull(response.jsonPath().getString("id"), "id should not be null");
			
		// Printing response body for debugging
        System.out.println("Response name: " + name);
        System.out.println("Response job: " + job);

        System.out.println("Test pass");

		
	}
}
