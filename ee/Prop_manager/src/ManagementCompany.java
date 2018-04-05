/**
 * Represents management company object 
 * @author Rajashow Parajuli
 * */
public class ManagementCompany {
	private int MAX_PROPERTY = 5;

	@SuppressWarnings("unused")
	private double mgmFeePer;

	private Property[] properties;

	@SuppressWarnings("unused")
	private String taxID, name;

	/**
	 * Constructor Creates a ManagementCompany object using the passed informations. "properties" array is initialized here as well. 
	 * @param name - management company name
	 * @param taxID - tax id
	 * @param mgmFee - management fee
	 * */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[MAX_PROPERTY ];

	}
	/**
	 * Adds the property object to the "properties" array. It returns either -1 if the array is full or the index in the array where the property was added successfully. 
	 * @param property - a property object 
	 * @return -1 if the array is full , otherwise return the index of the array where the property was added.
	 * */

	public int addProperty(Property p) {
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				properties[i] = p;
				return i;
			}
		}
		return -1;
	}
	/**
	 * Return the MAX_PROPERTY constant that represent the size of the "properties" array. 	 * @param name - management company name
	 * @return the MAX_PROPERTY a constant attribute for this class that is set 5
	 * */

	public int maxPropertyRentIndex() {
		int index = 0;
		double max = 0;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null)
				if (properties[i].getRentAmount() > max) {
					index = i;
					max = properties[i].getRentAmount();
				}
		}
		return index;
	}
/**
 * This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount. 

@return total rent*/
	public double totalRent() {
		double total = 0;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null)
				total += properties[i].getRentAmount();
		}
		return total;
	}
	/**
	 * Displays the information of the property at index i 
	 * @param i - The index of the property within the array "properties" 
	 * @return information of the property at index i
	 * */

	public String displayPropertyAtIndex(int maxPropertyRentIndex) {
		// TODO Auto-generated method stub
		return properties[maxPropertyRentIndex].toString();
	}
/**
 * Displays the information of all the properties in the "properties" array. 

@return information of ALL the properties within this management company by accessing the "Properties" array. The format is as following example: List of the properties for Alliance ,taxID: 1235 ______________________________________________________ Property Name : Belmar Located in Silver Spring Belonging to:John Smith Rent Amount: 1200.0 Property Name : Camden Lakeway Located in Rockville Belonging to:Ann Taylor Rent Amount: 2450.0 Property Name : Hamptons Located in Rockville Belonging to:Rick Steves Rent Amount: 1250.0 ______________________________________________________ total management Fee: 294.0
 * */
	public String toString() {
		String temp = "List of the properties for "+name+" ,taxID: "+taxID+"\n______________________________________________________\n";

		for (int i = 0; i < properties.length; i++) {
			if( properties[i]!=null)
			temp += properties[i].toString() + "\n";
		}
		return temp+"\n______________________________________________________\nTotal management Fee:"+totalRent()*mgmFeePer/100;
	}

	public int getMAX_PROPERTY() {
		// TODO Auto-generated method stub
		return MAX_PROPERTY;
	}

}
