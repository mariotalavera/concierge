package controllers;

import java.util.List;

import models.util.*;
import models.User;
import play.*;
import play.mvc.*;

public class QuoteRequests extends CRUD {

	public static void blank() {
		String userEmail = Security.connected();
        User connectedUser = User.find("byEmail", userEmail).first();
        List<Integer> availableYears = Year.getAvailYears();
        List<String> truckMakes = TruckMake.getTruckMakes();
        List<String> engineMakes = EngineMake.getEngineMakes();
        render(connectedUser, availableYears, truckMakes, engineMakes);
    }

}	
