package models;

import java.util.*;

import javax.persistence.*;

import controllers.Security;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Location extends Model {
	
	public String name;
	@Required
	public String addresslineone;
	public String addresslinetwo;
	@Required
	public String city;
	@Required
	public String state;
	public String zip;
	@Required
	public String country;
	@Required
	public String phone;
	
	@ManyToOne
	public User user;
	
	public Location(
			User user, 
			String name,
			String addresslineone,
			String addresslinetwo,
			String city,
			String state,
			String zip,
			String country,
			String phone) {
		this.user = user;
		this.name = name;
		this.addresslineone = addresslineone;
		this.addresslinetwo = addresslinetwo;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		
	}
	
	public String toString() {
	    return name;
	}

	/**
	 * Locations belong to user and company has many users.
	 * A user can use, however, any location from any other 
	 * user in the same company
	 */
	public static List<Location> findByUser(String email) {
		User user = User.find("byEmail", email).first();
		
        //1 find company of user connected
        //2 find all users of company connected
        List<User> companyUsers = User.find("byCompany", user.company).fetch();
        
        //3 create a list of locations
        List<Location> allLocations = new ArrayList();
        
        //4 loop users
        for (int i = 0; i < companyUsers.size(); i++) {
        	
        	User thisUser = companyUsers.get(i);
        	
        	List<Location> userLocations = Location.find("byUser", thisUser).fetch();
        	
        	//5 find locations for user being looped
        	//6 add user locations to locations list
        	if (userLocations != null) {
        		allLocations.addAll(userLocations);
        	}
        }
		
		return allLocations;
	}
	
	
}
