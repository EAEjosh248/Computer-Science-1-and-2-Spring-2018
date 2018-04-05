
/**
 * Represents a Property object
 * 
 * @author Rajashow Parajuli
 */
public class Property {
	private String city, owner, propertyName;
	private double rentAmount;

	/**
	 * Constructor, Parametarized constructor
	 * @param propertyName-name of the property
	 * @param city-name of the city where property is located
	 * @param rentAmount-the rent of Property
	 * @param owner-name of the owner of the property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;

	}

	/**
	 * 
	 * Copy Constructor, creates a new object using the information of the object
	 * passed to it.
	 * 
	 * @param p-Property type argument
	 */
	public Property(Property p) {
		this(p.propertyName, p.city, p.rentAmount, p.owner);
	}

	/**
	 * 
	 * No-arg Constructor, creates a new object with default values of empty strings
	 * and 0 for rent amount
	 */
	public Property() {
	}

	/**
	 * return the city
	 * 
	 * @return city- name of the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * return the owner name
	 * 
	 * @return owner - name of the owner of the property
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * return the property's name
	 * 
	 * @return propertyName- name of the property
	 */

	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * return the property's rent
	 * 
	 * @return rentAmount- rent of the property
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * set the city
	 * 
	 * @param city- name of the city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * set the owner name
	 * 
	 * @param owner - name of the owner of the property
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * set the property's name
	 * 
	 * @param propertyName- name of the property
	 */

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * set the property's rent
	 * 
	 * @param rentAmount  - rent of the property
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Prints out the name, city, owner and rent amount for a property. Example:
	 * Property Name: Lakewood Located in Rockville Belonging to: Alex Tan Rent
	 * Amount: 3000.0 Be sure the last item is the rent amount, preceded by a space.
	 * 
	 * 
	 * @return property- with property info
	 */
	public String toString() {
		return String.format("Property Name : %s \n Located in %s \n Belonging to: %s \n Rent Amount %.2f", propertyName,
				city, owner, rentAmount);
	}

}
