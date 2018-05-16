/**
 * abstract ship
 * 
 * @author Rajashow
 **/
public abstract class Ship implements Comparable<Ship> {

	protected String name;
	protected String year;
	protected ShipType type;

	public abstract String toString();

	public abstract String writeString();

	/**
	 * Sets the name of the ship.
	 * 
	 * @param name
	 *            is the name of the ship.
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * Sets the year the ship was commissioned.
	 * 
	 * @param year
	 *            is the year the ship was commissioned.
	 */
	public void setYear(String year) {

		this.year = year;
	}

	/**
	 * Sets the type of ship.
	 * 
	 * @param type
	 *            the type of ship.
	 */
	public void setType(String t) {
		if (t.equals("Cargo")) {
			type = ShipType.Cargo;
		} else if (t.equals("Cruise")) {

			type = ShipType.Cruise;
		} else if (t.equals("Warship")) {
			type = ShipType.Warship;

		} else if (t.equals("Carrier")) {
			type = ShipType.Carrier;

		} else if (t.equals("Cruiser")) {
			type = ShipType.Cruiser;

		} else if (t.equals("Destroyer")) {
			type = ShipType.Destroyer;

		} else if (t.equals("Mine Sweeper")) {
			type = ShipType.Mine_Sweeper;

		} else if (t.equals("Submarine")) {
			type = ShipType.Submarine;
		}
	}

	/**
	 * 
	 * @return The name of the ship;
	 */
	public String getName() {

		return name;
	}

	/**
	 * 
	 * @return The year the ship was commissioned.
	 */
	public String getYear() {

		return year;
	}

	/**
	 * 
	 * @return The type of ship.
	 */
	public String getType() {
		String s = "";
		switch (type) {
		case Cargo:
			s = "Cargo";

			break;
		case Cruise:
			s = "Cruise";

			break;
		case Warship:
			s = "Warship";

			break;
		case Carrier:
			s = "Carrier";

			break;
		case Cruiser:
			s = "Cruiser";

			break;
		case Destroyer:
			s = "Destroyer";

			break;
		case Mine_Sweeper:
			s = "Mine Sweeper";

			break;
		case Submarine:
			s = "Submarine";

			break;
		}

		return s;
	}

	public int compareTo(Ship ship) {

		return this.name.charAt(0) - ship.getName().charAt(0);

	}

}
