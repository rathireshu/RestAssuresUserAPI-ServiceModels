package models;

public class RegisterUserRequestPOJO {
	
	
	private String password;	
	private String email;
	
	
	public RegisterUserRequestPOJO(String password,String email) {
		
		
		this.password=password;
		this.email=email;		
		
	}
	



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public String toString() {
		return "RegisterUserRequestPOJO [password=" + password + ", email=" + email + "]";
	}




	
	
}



