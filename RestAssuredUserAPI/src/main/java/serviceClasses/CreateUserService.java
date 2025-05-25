package serviceClasses;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import models.CreateUserRequestPOJO;

public class CreateUserService {
	
	public static Response createUser(CreateUserRequestPOJO request) {
			
	baseURI = "https://reqres.in";			
			
	 Response res =  given()
					      .header("Content-Type", "application/json")
					      .baseUri(baseURI)
					      .body(request)    // Serialize POJO to JSON
					 .when()
					      .post("api/user").
					 then()
					      .extract().response();
	
	       return res;	            
		}		
	}
