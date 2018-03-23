import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTest {
	Property p1 ,p2,p3,p4,p5;
	ManagementCompany m ; 
	
	@Before
	public void setUp() throws Exception {
		p1 = new Property ("Belmar", "Silver Spring", 1200.45, "John Smith");
		p2 = new Property ("Camden Lakeway", "Rockville", 2450, "Ann Taylor");
		p3 = new Property ("Hamptons", "Rockville", 1250, "Rick Steves");
		
		m= new ManagementCompany("Alliance", "1235",6);
	 
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		p1=p2=p3=null;
		m=null;
	}

 	@Test
	public void testAddProperty() {
		p4 = new Property ("Mallory Square", "Wheaton", 1000, "Abbey McDonald");
		p5 = new Property ("Lakewood", "Rockville", 3000, "Alex Tan");
		 
		assertEquals(m.addProperty(p4),3,0);
		assertEquals(m.addProperty(p5),4,0);
		assertEquals(m.addProperty(p1),-1,0);  //exceeds the size of the array and can not be added, add property should return -1	
	}
 
	@Test
	public void testMaxPropertyRentIndex() {
		
		assertEquals(m.maxPropertyRentIndex(),1,0);
		
	}

	@Test
	public void testTotalRent() {

		assertEquals(m.totalRent(),4900.45,0);
	}

 }
