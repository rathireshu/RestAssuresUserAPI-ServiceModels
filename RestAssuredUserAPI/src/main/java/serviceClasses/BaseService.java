package serviceClasses;

import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;


public class BaseService {

	protected static final String baseURI ="https://reqres.in";	 
	
	//using pojo class to get body 
	
	
	public static RequestSpecification getRequestSpec() {
		
		
		return given()
				.baseUri(baseURI)
				.header("Content-Type","application/json")
				.log().all();		
	}
	
	
	
}
