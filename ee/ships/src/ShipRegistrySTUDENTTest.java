import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Add your test methods here. Follow the examples in ShipRegistryTest.java
 * 
 * @author Rajashow Parajuli
 *
 */
public class ShipRegistrySTUDENTTest {

	private ShipRegistry shipsSTUDENT;

	@Before
	public void setUpSTUDENT() throws Exception {
		shipsSTUDENT = new ShipRegistry();
		shipsSTUDENT = new ShipRegistry();
		shipsSTUDENT.addShip("Westralia (O 195)", "Cargo", "1944", 25000, 0, 0, 0, 0);
		shipsSTUDENT.addShip("AIDAaura", "Cruise", "2003", 0, 1300, 0, 0, 0);
		shipsSTUDENT.addShip("Montgomery", "Warship", "1813", 0, 0, 11, 0, 0);
		shipsSTUDENT.addShip("Kitty Hawk (CV-63)", "Carrier", "1961", 0, 0, 0, 0, 85);
		shipsSTUDENT.addShip("Arleigh Burke (DDG-51)", "Destroyer", "1989", 0, 0, 90, 0, 0);
	}

	@After
	public void tearDown() throws Exception {
		shipsSTUDENT = null;
	}

	@Test
	public void testAddShipSTUDENT() {
		shipsSTUDENT.addShip("Bunker Hill (CG-52)", "Cruiser", "1986", 0, 0, 130, 0, 0);
		shipsSTUDENT.addShip("Inchon (LPH-12)", "Mine Sweeper", "1970", 0, 0, 10, 0, 0);
		shipsSTUDENT.addShip("John Adams (SSBN-620)", "Submarine", "1964", 0, 0, 0, 20, 0);
		ArrayList<Ship> shipList = shipsSTUDENT.getShips();
		assertEquals("Bunker Hill", shipList.get(5).toString().substring(0, 11));
		assertEquals(130, ((WarShip) shipList.get(5)).getNumGuns());

	}

	@Test
	public void testReadFileSTUDENT() throws IOException {
		try {
			// this statement just rewrites an empty file over any existing ones
			new PrintWriter("testShips.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		shipsSTUDENT.writeFile(new File("testShips.csv"));
		shipsSTUDENT = new ShipRegistry();
		try {
			shipsSTUDENT.readFile(new File("testShips.csv"));
			ArrayList<Ship> shipList = shipsSTUDENT.getShips();
			Ship s = shipList.get(1);
			assertEquals("AIDAaura", s.writeString().substring(0, 8));
			s = shipList.get(3);
			assertEquals("Kitty Hawk", s.writeString().substring(0, 10));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testWriteFileSTUDENT() {
		ArrayList<Ship> shipList = shipsSTUDENT.getShips();
		Ship s = shipList.get(2);
		assertEquals("Montgomery", s.writeString().substring(0, 10));
	}

}
