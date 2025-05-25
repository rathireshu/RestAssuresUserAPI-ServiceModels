package serviceClasses;

import io.restassured.response.Response;
import models.RegisterUserRequestPOJO;

public class RegisterUserService extends BaseService{
	
	 private static final String REGISTER_ENDPOINT = "/api/register";
	
	public static  Response registerUser(String eamil,String pwd) {
		
		RegisterUserRequestPOJO registerPojo = new RegisterUserRequestPOJO(eamil,pwd);
		
		         return getRequestSpec()
		            .body(registerPojo) //Automatic Serialization of request pojo
		            .when()
		            .post("/api/register")
		            .then()
		            .extract()
		            .response();
		
	}

}
