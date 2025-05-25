import static io.restassured.RestAssured.*;

import java.io.File;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class PostLoginTest {
@Test
	void postTest() {
		
		baseURI = "https://reqres.in";
		
File jsonFile = new File("C:\\Users\\reshu\\eclipse-workspace\\RestAssuredUserAPI\\loginData.json");
		
		              given()
				          .header("Content-Type", "application/json")
				          .body(jsonFile).
				       when()
				          .post("/api/login").
				        then()
				           .statusCode(200)
				           .body("token", equalTo("QpwL5tke4Pnpja7X4"))
				           .log().all();
	
	}
	
}
