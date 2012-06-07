package models.util;

import java.util.*;

public class TruckMake {
	public static String[] makes = {"All","Autocar","Bering","Capacity","Caterpillar","Century","Chevrolet","Dodge","Ford","Freightliner","GMC","Hino","Holmes","Hummer","International","Isuzu","Jeep","Kenworth","Mack","Magnum","Mercedes Benz","Mitsubishi-Fuso","Oshkosh","Ottawa","Peterbilt","Sterling","Volvo","OTHER"};
	
	public static List<String> getTruckMakes() {
		List<String> truckMakes = Arrays.asList(makes);  
		return truckMakes;
	}

}
