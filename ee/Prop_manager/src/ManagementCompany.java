
public class ManagementCompany {
	private int MAX_PROPERTY;

	private double mgmFeePer;

	private Property[] properties;

	private String taxID, name;

	public ManagementCompany(String name, String taxID, int mgmFeePer) {
		this.name = name;
		this.taxID= taxID;
		this.mgmFeePer=mgmFeePer;
		properties = new Property[5];


	}

	public int addProperty(Property p) {
		for(int i=0; i< properties.length;i++) {
			if(properties[i]== null) {
				properties[i]=p;
				return i;
			}
		}
return -1;
	}

	public int maxPropertyRentIndex() {
		int index=0;
		double max=0;
		for(int i=0; i< properties.length;i++) {
			if(properties[i]!=null)
		if(properties[i].getRentAmount()>max) {
			index=i;
			max= properties[i].getRentAmount();
		}
		}
		return index;
	}

	public double totalRent() {
double total=0;
for(int i=0; i< properties.length;i++) {
	if(properties[i]!=null)
total+= properties[i].getRentAmount();	
}
return total;
	}

	public String displayPropertyAtIndex(int maxPropertyRentIndex) {
		// TODO Auto-generated method stub
		return properties[maxPropertyRentIndex].toString();
	}
	public String toString() {
		String temp="";
		
		for(int i=0; i< properties.length;i++) {
			temp+= properties[i].toString()+"\n";
		}
	return temp;
	}

}
