package models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Setter
@Getter
@Data
@NoArgsConstructor 

//we'll use Jackson annotations to customize serialization/deserialization.
//and Lombok @Data will automatically generate:
// - Getters and setters for name and job
// - toString(), equals(), hashCode(), and constructor

public class CreateUserRequestPOJO {	
		
	
	@JsonProperty("user_name")  // JSON key will be "user_name"
    private String name;
	
	private String job;
	
	//@JsonIgnore  // This field will be ignored in JSON
    //private String password;
	
	
	
}
