package models;

import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Company extends Model {

	@Required
	public String name;

//	@OneToMany//(cascade=CascadeType.ALL, mappedBy="user")

//	public List<User> users = new ArrayList<User>();

	public String toString() {
	    return name;
	}
	
}
