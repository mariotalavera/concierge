package models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class AirCargo extends Model {
	
	public String byWeightIn;

	@Column(precision=6, scale=2)
	public BigDecimal minimumCharge;
	
	@Required
	public String name;
	
	@Column(precision=6, scale=2)
	public BigDecimal rateCaribbean;
	
	@Column(precision=6, scale=2)
	public BigDecimal rateSouthAmerica;

	public String toString() {
	    return name;
	}
	

}
