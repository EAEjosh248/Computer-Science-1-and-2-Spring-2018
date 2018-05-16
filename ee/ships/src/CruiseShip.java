/**
 * a passenger ship
 * 
 * @author Rajashow
 */
public class CruiseShip extends Ship {

	private int pax;

	/**
	 * Create a new cruise ship with a name, year , type and number of passengers
	 * 
	 * @param name
	 *            : String - name of the ship
	 * @param type
	 *            : String - type of the ship
	 * @param year
	 *            : String - year of production of the ship
	 * @param pax
	 *            : int - number of the passengers
	 */
	public CruiseShip(String name, String type, String year, int pax) {

		this.name = name;
		setType(type);
		this.year = year;
		this.pax = pax;
	}

	/**
	 * 
	 * @return The amount of passengers.
	 */
	public int getPass() {

		return pax;
	}
	/**
	 * 
	 * @return details about the ship, Name, year , type etc.
	 */
	public String toString() {

		String ret = "";

		ret += name + " built in " + year + "," + type + " class carrying " + getPass() + " passengers.";

		return ret;
	}

	/**
	 * 
	 * @return details about the ship, Name, year , type , passengers.
	 */
	public String writeString() {

		String s = "";

		s += name + "," + type + "," + year + "," + getPass() + ",\n";

		return s;
	}
}
