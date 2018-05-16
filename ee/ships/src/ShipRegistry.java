import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javafx.stage.FileChooser;

/***
 * ShipRegistry is a Data Manager that keeps a list of ships. Note that this
 * list is not precise in its naval jargon.
 * 
 * @author Rajashow
 */
public class ShipRegistry implements ShipRegistryInterface {

	private ArrayList<Ship> shipList = new ArrayList<Ship>();

	/**
	 * The getShips method returns the current shipList
	 * 
	 * @return  shipList : ArrayList<Ship>
	 */
	public ArrayList<Ship> getShips() {

		return shipList;
	}

	/**
	 * The addShip method adds ships to the ShipRegistry's ArrayList, distinguishing
	 * by type, creating a ship instance of the correct type, and specifying the
	 * correct parameters according to its type. This method does not add in any
	 * sorted order - the ships are held in the order they are added
	 * 
	 * @param name
	 *            A string representing the name of the ship
	 * @param type
	 *            A string representing one of "Cargo", "Cruise", "Warship",
	 *            "Carrier", "Cruiser","Destroyer","Mine Sweeper",or "Submarine"
	 * @param year
	 *            A string representing the year launched
	 * @param tons
	 *            A string representing the number of tons of cargo (net register
	 *            tonnage (NRT)) the ship can carry
	 * @param pax
	 *            A string representing the number of passengers a cruise ship can
	 *            carry
	 * @param guns
	 *            A string representing the number of guns a warship can carry.
	 *            "Guns" is loosely defined, not according to naval jargon
	 * @param torpedoes
	 *            A string representing the number of torpedoes a warship can carry.
	 * @param aircraft
	 *            A string representing the number of aircraft a warship can
	 *            nominally carry.
	 */
	public void addShip(String name, String type, String year, int tons, int pax, int guns, int torpedoes,
			int aircraft) {

		if (type.equals("Cargo")) {
			shipList.add(new CargoShip(name, type, year, tons));
		} else if (type.equals("Cruise")) {
			shipList.add(new CruiseShip(name, type, year, pax));
		} else if (type.equals("Warship")) {
			shipList.add(new WarShip(name, type, year, guns, torpedoes, aircraft));
		} else if (type.equals("Carrier")) {
			shipList.add(new WarShip(name, type, year, aircraft));
		} else if (type.equals("Cruiser")) {
			shipList.add(new WarShip(name, type, year, guns, torpedoes, aircraft));
		} else if (type.equals("Destroyer")) {
			shipList.add(new WarShip(name, type, year, guns, torpedoes, aircraft));
		} else if (type.equals("Mine Sweeper")) {
			shipList.add(new WarShip(name, type, year, guns, torpedoes, aircraft));

		} else if (type.equals("Submarine")) {
			shipList.add(new WarShip(name, type, year, guns, torpedoes, aircraft));

		}
	}

	/**
	 * The readFile method reads from the input file, one line at a time, assuming
	 * each line represents data for one ship. It assumes that the second field is a
	 * string representing the ship type, one of "Cargo", "Cruise", "Warship",
	 * "Carrier", "Cruiser","Destroyer","Mine Sweeper",or "Submarine". It further
	 * assumes specific formats for each type of ship, as follows: Cargo:
	 * name,"Cargo",year,tons Cruise: name,"Cruise",year,passengers Warship:
	 * name,"Warship",year,guns,aircraft,torpedoes Carrier:
	 * name,"Carrier",year,aircraft Cruiser, Destroyer, and Mine Sweeper:
	 * name,type,year,guns Submarine: name,"Submarine",year,torpedoes It then calls
	 * addShip to instantiate it and add it to the ShipRegistry's ArrayList
	 * 
	 * @param file
	 *            the file of type File to read from, assumed to be a csv file
	 *            (comma-delimited) in the above order.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void readFile(File file) throws FileNotFoundException, IOException {

		String[] fields;
		String name, type, year;
		int tons, pax, guns, torpedoes, aircraft;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {

				fields = line.split(",");
				name = fields[0];
				type = fields[1];
				year = fields[2];

				if (fields[1].equals("Cargo")) {

					tons = Integer.parseInt(fields[3]);
					Ship s = new CargoShip(name, type, year, tons);
					shipList.add(s);
				}

				else if (fields[1].equals("Cruise")) {

					pax = Integer.parseInt(fields[3]);
					Ship s = new CruiseShip(name, type, year, pax);
					shipList.add(s);
				}

				else if (fields[1].equals("Warship")) {

					guns = Integer.parseInt(fields[3]);

					torpedoes = Integer.parseInt(fields[4]);

					aircraft = Integer.parseInt(fields[5]);

					Ship s = new WarShip(name, type, year, guns, torpedoes, aircraft);
					shipList.add(s);

				}

				else if (fields[1].equals("Carrier")) {

					aircraft = Integer.parseInt(fields[3]);

					Ship s = new WarShip(name, type, year, aircraft);
					shipList.add(s);

				}

				else if (fields[1].equals("Destroyer")) {

					guns = Integer.parseInt(fields[3]);

					Ship s = new WarShip(name, type, year, guns);
					shipList.add(s);
				}

				else if (fields[1].equals("Mine_Sweeper")) {
					guns = Integer.parseInt(fields[3]);
					Ship s = new WarShip(name, type, year, guns);
					shipList.add(s);
				}

				else if (fields[1].equals("SUBMARINE")) {
					torpedoes = Integer.parseInt(fields[3]);
					Ship s = new WarShip(name, type, year, torpedoes);
					shipList.add(s);
				}
			}
		}

	}

	/**
	 * The writeFile method writes to a specified file, either creating a new file
	 * or appending to the end of an existing file. It iterates through
	 * ShipRegistry's ArrayList<Ship>, writes one line at a time representing data
	 * for each ship. It writes the second field as a string representing the ship
	 * type, one of "Cargo", "Cruise", "Warship", "Carrier",
	 * "Cruiser","Destroyer","Mine Sweeper",or "Submarine". It further writes
	 * specific formats for each type of ship, as follows: Cargo:
	 * name,"Cargo",year,tons Cruise: name,"Cruise",year,passengers Warship:
	 * name,"Warship",year,guns,aircraft,torpedoes Carrier:
	 * name,"Carrier",year,aircraft Cruiser, Destroyer, and Mine Sweeper:
	 * name,type,year,guns Submarine: name,"Submarine",year,torpedoes
	 * 
	 * @param file
	 *            the file of type File to write to
	 * @throws IOException
	 */
	public void writeFile(File file) throws IOException {
		PrintWriter pw = null;
		FileOutputStream fo = null;
		try {
			pw = new PrintWriter(new FileOutputStream(file));
			fo = new FileOutputStream(file);
			int list = shipList.size();

			for (int i = 0; i < list; i++) {

				pw.write(shipList.get(i).writeString());

			}
		} finally {
			pw.flush();
			pw.close();
			fo.close();
		}
	}

	/**
	 * The getShipDescriptions method is used in the GUI to set the radio button
	 * labels for basic ship types
	 * 
	 * @return the string array {ShipType.CARGO.toString(),
	 *         ShipType.CRUISE.toString(), ShipType.WARSHIP.toString()};
	 */
	public String[] getShipDescriptions() {

		String array[] = { ShipType.Cargo.toString(), ShipType.Cruise.toString(), ShipType.Warship.toString() };

		return array;
	}

	/**
	 * The getWarshipDescriptions method is used in the GUI to set the radio button
	 * labels for the five warship types
	 * 
	 * @return the string array {ShipType.CARRIER.toString(),
	 *         ShipType.CRUISER.toString(), ShipType.DESTROYER.toString(),
	 *         ShipType.MINE_SWEEPER.toString(), ShipType.SUBMARINE.toString()};
	 */

	public String[] getWarshipDescriptions() {

		String array[] = { ShipType.Carrier.toString(), ShipType.Cruiser.toString(), ShipType.Destroyer.toString(),
				ShipType.Mine_Sweeper.toString(), ShipType.Submarine.toString() };
		return array;
	}

	/**
	 * Create a toString method that sorts the currents ships according to the
	 * alphabetic order of the ship's name, and then iterates through the current
	 * ships and appends each ship's toString method to the string returned.
	 * 
	 */
	public String toString() {

		Collections.sort(shipList);

		String ret = "";

		for (Ship s : shipList) {

			ret += s.toString() + "\n";

		}
		return ret;

	}
}
