package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class User extends Model {
	
	@Required
	public String firstname;
	@Required
	public String lastname;
	@Email
	@Required
	public String email;
	@Password
	@Required
	public String password;
	public boolean isAdmin;
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
//	public List<Location> locations = new ArrayList<Location>();
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
//	public List<Shipment> shipments = new ArrayList<Shipment>();
	
	@ManyToOne //(cascade=CascadeType.REFRESH, optional=true)
	public Company company;
	
	public User(
			String firstname,
			String lastname,
			String email,
			String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;		
	}
	
	public static User connect(String email, String password) {
	    return find("byEmailAndPassword", email, password).first();
	}
	
	public String toString() {
	    return firstname + ' ' + lastname;
	}
	
}
