/**
 * a cargo ship
 * 
 * @author Rajashow
 */
public class CargoShip extends Ship {

	private int tons;

	/**
	 * Create a new cargo ship with a name, year , type and number of tons of goods
	 * 
	 * @param name
	 *            : String - name of the ship
	 * @param type
	 *            : String - type of the ship
	 * @param year
	 *            : String - year of production of the ship
	 * @param tons
	 *            : int - amount of cargo in tonnage
	 */
	public CargoShip(String name, String type, String year, int tons) {

		this.name = name;
		setType(type);
		this.year = year;
		this.tons = tons;
	}

	/**
	 * 
	 * @return The tons carried by ship.
	 */
	public int getTons() {

		return tons;
	}

	/**
	 * 
	 * @return details about the ship, Name, year , type etc.
	 */
	public String toString() {

		return name + " was built in " + year + "," + type + " class with " + getTons() + " tons capacity";
	}

	/**
	 * 
	 * @return details about the ship, Name, year , type , tonnage.
	 */

	public String writeString() {

		return name + "," + type + "," + year + "," + getTons() + ",\n";
	}
}
