package utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonUtil {

	//Utility Class to Read test JSON
	
	private static final ObjectMapper objectMapper = new ObjectMapper();

	// Read JSON and convert to Java Object
    public static <T> T readFromJson(String filePath, Class<T> clazz) throws IOException 
    {
        File jsonFile = new File(filePath);
      //readValue() is a method to deserialize json content from json file into pojo cls
    	return objectMapper.readValue(jsonFile, clazz);
    }

    
    //Convert Java Object to JSON String
    public static String toJson(Object obj) throws IOException {
    	
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }
}
