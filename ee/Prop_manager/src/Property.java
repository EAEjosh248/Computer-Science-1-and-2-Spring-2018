import org.junit.platform.commons.util.ToStringBuilder;

public class Property {
private String city,owner,propertyName; 
private double rentAmount;

 public Property(String propertyName, String city, double rentAmount, String owner) {
this.propertyName= propertyName;
this.city= city;
this.rentAmount =  rentAmount;
this.owner= owner;

 }

	public Property(Property p) {
        this(p.propertyName, p.city, p.rentAmount, p.owner);
}
	public Property() {
	}

	public String getCity() {
		return city;
	}
	public String getOwner() {
		return owner;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public double getRentAmount() {
		return rentAmount;
	}

public void setCity(String city) {
	this.city=city;
}

public void setOwner(String owner) {
	this.owner=owner;
}

public void setPropertyName(String propertyName) {
	this.propertyName = propertyName;
}

public void setRentAmount(double rentAmount) {
	this.rentAmount = rentAmount;
}
public String toString() {
	return String.format("Property Name : %s \n Located in %s \n Belonging to: %s \n Rent Amount %2d", propertyName,city,owner,rentAmount);
}


}
