package apiTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import models.CreateUserRequestPOJO;
import serviceClasses.PracticeServiceMethods;
import utils.jsonUtil;

public class PracticeRequestTest extends PracticeServiceMethods {
	
	String jsonPath = "src/test/resources/userPayload.json";
	
	@Test
	public void testGet() {
		
		Response getres =PracticeServiceMethods.getUser();
		
		Assert.assertEquals(getres.statusCode(), 200);
	}
	
	
	@Test
	public void testPost() throws IOException {
		
 CreateUserRequestPOJO reqBody = jsonUtil.readFromJson(jsonPath, CreateUserRequestPOJO.class);
		    
		    Response postRes =PracticeServiceMethods.postUser(reqBody);
		    
		    Assert.assertEquals(postRes.statusCode(), 201);
			//Assert.assertTrue(postRes.body().asString().contains("test"));
			System.out.println(postRes.body().jsonPath().getString("name"));
			System.out.println(postRes.statusLine());
			Assert.assertTrue(postRes.body().asString().contains("id"));
			
		
				
		//response schema validation
		
		String jsonSchema ="{"
				+ "  \"type\": \"object\",\r\n"
				+ "  \"properties\": {\r\n"
				+ "    \"name\": {\r\n"
				+ "      \"type\": \"string\"\r\n"
				+ "    },\r\n"
				+ "    \"job\": {\r\n"
				+ "      \"type\": \"string\"\r\n"
				+ "    },\r\n"
				+ "    \"id\": {\r\n"
				+ "      \"type\": \"string\"\r\n"
				+ "    },\r\n"
				+ "    \"createdAt\": {\r\n"
				+ "      \"type\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  },\r\n"
				+ "  \"required\": [\r\n"
				+ "    \"name\",\r\n"
				+ "    \"job\",\r\n"
				+ "    \"id\",\r\n"
				+ "    \"createdAt\"\r\n"
				+ "  ]\r\n"
				+ "}";	
		
		postRes
		.then()
		   .assertThat()
		       .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema)) ;
		
		
	}
	
	@Test
	public void testDelete() {
		
		Response postRes =PracticeServiceMethods.deleteUser();
		
		//Assert.assertEquals(postRes.statusCode(), 204);
	}
	

}
