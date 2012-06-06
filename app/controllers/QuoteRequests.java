package controllers;

import java.util.List;

import models.util.Year;
import models.User;
import play.*;
import play.mvc.*;

public class QuoteRequests extends CRUD {

	public static void blank() {
		String userEmail = Security.connected();
        User connectedUser = User.find("byEmail", userEmail).first();
        List<Integer> availableYears = Year.getAvailYears();
        render(connectedUser, availableYears);
    }

}	
