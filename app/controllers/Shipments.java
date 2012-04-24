package controllers;

import java.util.List;

import models.Location;
import models.Shipment;
import models.User;
import controllers.CRUD.ObjectType;
import play.*;
import play.mvc.*;

public class Shipments extends CRUD {

    public static void list(int page, String search, String searchFields, String orderBy, String order) {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        if (page < 1) {
            page = 1;
        }

        User user = User.find("byEmail", Security.connected()).first();
        String userEmail = user.email;

        List<Shipment> objects = Shipment.findByUser(userEmail);
        Long count = type.count(search, searchFields, (String) request.args.get("where"));
        Long totalCount = type.count(null, null, (String) request.args.get("where"));
        
        render(type, objects, count, totalCount, page, orderBy, order, user);
    }

    // TODO shipment show have only my locations
    // TODO change color scheme
    // TODO shipment created at like client. hidden and default, in this case, to currentdate
    
	public static void blank() {
		String userEmail = Security.connected();
        User connectedUser = User.find("byEmail", userEmail).first();
        List<Location> availableLocations = Location.findByUser(userEmail);
        render(connectedUser, availableLocations);
    }
	
	public static void form() {
		blank();
    }
	
}