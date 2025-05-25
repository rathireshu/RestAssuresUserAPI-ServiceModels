package serviceClasses;
import io.restassured.response.Response;
import serviceClasses.BaseService;


public class GetUsersService extends BaseService {

	
	//all endpoints for this service
	
	private static final String getUser_endpoint ="/api/users/{page}";
	
	private static final String getUserById_endpoint ="/api/users/{page}";
	
	
	
	public static Response getUser(int page) {
	
		
		return getRequestSpec()
				.pathParam("page", page)
				.when()
				.get(getUser_endpoint);
		
	}
	
	
	public static Response getUserByUserId(int userId) {
		
		return getRequestSpec()
				.pathParam("userId",userId)
				.when()
				.get(getUserById_endpoint);
		
	}


	
}
