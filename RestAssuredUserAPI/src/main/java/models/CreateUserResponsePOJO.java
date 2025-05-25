package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserResponsePOJO {

    @JsonProperty("id") // Ensure Jackson maps JSON field "id" correctly
    private int id;

    @JsonProperty("token") // Ensure Jackson maps JSON field "token" correctly
    private String token;

    // Default constructor (required for Jackson deserialization)
    public CreateUserResponsePOJO() {
    }

    public CreateUserResponsePOJO(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ResponsePOJO [id=" + id + ", token=" + token + "]";
    }
}
