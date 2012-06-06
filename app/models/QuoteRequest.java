package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;

@Entity
public class QuoteRequest extends Model {
	
	public String year;
	public String make;
	public String model;
	public String vin;
	public String engineMake;
	public String engineSerial;
	@Column(precision=6, scale=0)
	public BigDecimal quantity;
	@Lob
    @MaxSize(10000)
	public String partDescription;
	public String partNumber;
	public String shippingMethod;
	public Date neededBy;
	@Lob
    @MaxSize(10000)
	public String alternateDescription;
	@Required
	@ManyToOne
	public User user;


	public QuoteRequest(
			String year, 
			String make, 
			String model, 
			String vin, 
			String engineMake, 
			String engineSerial, 
			BigDecimal quantity,
			String partDescription, 
			String partNumber, 
			String shippingMethod, 
			Date neededBy, 
			String alternateDescription,
			User user) {
		
		this.year = year; 
		this.make = make;
		this.model = model;
		this.vin = vin;
		this.engineMake = engineMake; 
		this.engineSerial = engineSerial;
		this.quantity = quantity;
		this.partDescription = partDescription;
		this.partNumber = partNumber;
		this.shippingMethod = shippingMethod;
		this.neededBy = neededBy;
		this.alternateDescription = alternateDescription;
		this.user = user;
	}
}
