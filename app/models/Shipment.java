package models;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Shipment extends Model {

	@Required
	@ManyToOne
	public User user;
	@OneToOne
	public Location destination;
	@OneToOne
	public Location origin;
	public Date createdAt = new Date();
	
	@Lob
	public String description;

	@Column(precision=6, scale=2)
	public BigDecimal flete;
	@Column(precision=6, scale=2)
	public BigDecimal impuestos;
	@Column(precision=6, scale=2)
	public BigDecimal itbm;
	@Column(precision=6, scale=2)
	public BigDecimal aduana;
	@Column(precision=6, scale=2)
	public BigDecimal acarreo;
	@Column(precision=6, scale=2)
	public BigDecimal seguro;
	@Column(precision=6, scale=2)
	public BigDecimal usodesistema;
	@Column(precision=6, scale=2)
	public BigDecimal itbms;
    @Column(precision=6, scale=2)
	public BigDecimal cost;
	public int guiano;
	public int peso;
	
	
//	public Number getCost() {
//		BigDecimal cost =
//				Sum(flete, impuestos, itbm, aduana, acarreo,seguro, usodesistema,itbms);
//		return cost;
//	}

	public static List<Shipment> findByUser(String email) {
		User user = User.find("byEmail", email).first();
		
		List<Shipment> shipments = Shipment.find("byUser_id",user.id).fetch();			
		if(user.isAdmin) {
			shipments =  Shipment.findAll();
		}
		
		return shipments;
	}
	


	// todo push to heroku
}
