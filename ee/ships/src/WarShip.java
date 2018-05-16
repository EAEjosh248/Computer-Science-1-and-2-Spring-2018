/**
 * a warship ship
 * 
 * @author Rajashow
 */
public class WarShip extends Ship {

	private int guns;
	private int torp;
	private int air;

	/**
	 * Create a new cruise ship with a name, year , type and number of passengers
	 * 
	 * @param name
	 *            : String - name of the ship
	 * @param type
	 *            : String - type of the ship
	 * @param year
	 *            : String - year of production of the ship
	 * @param guns
	 *            : int - number of the guns
	 * @param torpedoes
	 *            : int - number of the torpedoes
	 * @param aircraft
	 *            : int - number of the aircraft
	 */
	public WarShip(String name, String type, String year, int guns, int torpedoes, int aircraft) {
		this.name = name;

		setType(type);

		this.year = year;

		this.guns = guns;

		torp = torpedoes;

		air = aircraft;

	}

	public WarShip(String name, String type, String year, int aircraft) {

		this.name = name;

		setType(type);

		this.year = year;

		air = aircraft;
	}

	/**
	 * 
	 * @return The number of guns on the ship.
	 */
	public int getNumGuns() {

		if (type == ShipType.Submarine) {
			return torp;
		}

		return guns;
	}

	/**
	 * 
	 * @return The number of torpedoes on the ship.
	 */
	public int getTorpedoesNum() {

		return torp;
	}

	/**
	 * 
	 * @return The number of aircraft it carries.
	 */
	public int getAirCraft() {

		return air;
	}

	/**
	 * 
	 * @return details about the ship, Name, year , type etc.
	 */
	public String toString() {
		String ret = "";
		switch (type) {
		case Warship:
			ret += name + " built in " + year + "," + type + " class with " + getNumGuns() + "guns" + ","
					+ getTorpedoesNum() + " torpedoes " + ", and" + getAirCraft() + " aircraft.";
			break;
		case Carrier:
			ret += name + " built in " + year + "," + type + " class carrying " + getAirCraft() + " aircraft";

			break;
		case Cruiser:
			ret += name + " built in " + year + "," + type + " class with " + getNumGuns() + " guns.";

			break;
		case Destroyer:
			ret += name + " built in " + year + "," + type + " class with " + getNumGuns() + " guns.";

			break;
		case Mine_Sweeper:
			ret += name + " built in " + year + "," + type + " class with " + getNumGuns() + " guns.";

			break;
		case Submarine:
			ret += name + " built in " + year + "," + type + " class with " + getNumGuns() + " torpedoes.";

			break;
		}
		return ret;
	}

	/**
	 * 
	 * @return details about the ship, Name, year , type , passengers.
	 */
	public String writeString() {
		String s = "";
		switch (type) {
		case Warship:
			s += name + "," + type + "," + year + "," + getNumGuns() + "," + getTorpedoesNum() + "," + getAirCraft()
					+ ",\n";

			break;
		case Carrier:
			s += name + "," + type + "," + year + "," + getAirCraft() + ",\n";

			break;
		case Cruiser:
			s += name + "," + type + "," + year + "," + getNumGuns() + ",\n";

			break;
		case Destroyer:
			s += name + "," + type + "," + year + "," + getNumGuns() + ",\n";

			break;
		case Mine_Sweeper:
			s += name + "," + type + "," + year + "," + getNumGuns() + ",\n";

			break;
		case Submarine:
			s += name + "," + type + "," + year + "," + getNumGuns() + ",\n";
			break;
		}

		return s;
	}

}
