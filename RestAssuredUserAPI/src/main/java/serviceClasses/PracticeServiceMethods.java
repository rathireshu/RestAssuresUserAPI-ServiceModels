package serviceClasses;

import static io.restassured.RestAssured.given;
import  io.restassured.response.*;
import models.CreateUserRequestPOJO;

public class PracticeServiceMethods {

	
	public static final String baseURI = "https://reqres.in";	
	public static final String getEndpoint = "/api/users/2";
	public static final String postEndpoint="api/user";
	public static final String deleteEndpoint="/api/users/2";
	
	//either create this object or static import for given()
	//RestAssured restassured = new RestAssured();
	
	
	
	public static Response getUser() {
		
		return given().header("Contant-Type","application/json").baseUri(baseURI)
							.when().get(getEndpoint);
		
	}
	
	public static Response postUser(CreateUserRequestPOJO requestBody) {
		return given().header("Content-Type","application/json").baseUri(baseURI)
				.body(requestBody).when().post(postEndpoint);
	}
	
	public static Response deleteUser() {
		return given().baseUri(baseURI).when().delete();
	}
	
	
	
	
	
	
}
