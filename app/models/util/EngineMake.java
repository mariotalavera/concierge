package models.util;

import java.util.Arrays;
import java.util.List;

public class EngineMake {
	public static String[] makes = {"All","Catepillar","Cummins","Detroit Diesel","OTHER"};
	
	public static List<String> getEngineMakes() {
		List<String> engineMakes = Arrays.asList(makes);  
		return engineMakes;
	}

}
