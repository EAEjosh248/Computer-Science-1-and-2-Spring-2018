import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CompanyTest {
	Company company,StudentCompany;

	@Before
	public void setUp() throws Exception {
		company = new Company("Wacky Widgets");
		company.addEmployee("John","Smith", "Manufacturing", 6.75, 120, 444); //Manufacturing
		company.addEmployee("Betty","White","Manager",1200.00, 0, 111); //Manager
		company.addEmployee("Stan","Slimey","Sales",10000.00, 0, 332); //Sales
		company.addEmployee("Betty","Boop","Design",12.50, 50, 244); //Hourly worker
		//STUDENT:  Create another company object.  Add several employees.  Use this object in the
		StudentCompany = new Company("Billy Bobs");
		StudentCompany.addEmployee("John","Smith", "Manufacturing", 6.75, 120, 444); //Manufacturing
		StudentCompany.addEmployee("Betty","White","Manager",1200.00, 0, 111); //Manager
		StudentCompany.addEmployee("Stan","Slimey","Sales",10000.00, 0, 332); //Sales
		StudentCompany.addEmployee("Betty","Boop","Design",12.50, 50, 244); //Hourly worker
		// Student test methods.
	}

	@After
	public void tearDown() throws Exception {
		company = null;
	}

	@Test
	public void testAddEmployee() {
		String result = company.generateWeeklyReport();
		Scanner report = new Scanner(result);
		report.nextLine(); //WEEKLY PAY REPORT FOR WIDGET COMPANY
		report.nextLine();  //empty line
		report.nextLine();  //EMPLOYEE        WEEKLY PAY
		report.nextLine(); //employee 444
		report.nextLine(); //employee 111
		report.nextLine(); //employee 332
		assertEquals("244",report.next()); //employee 244
		company.addEmployee("Charles","Emory","Design", 7.50, 35, 343); //Design employee
		result = company.generateWeeklyReport();
		report = new Scanner(result);
		report.nextLine(); //WEEKLY PAY REPORT FOR Wacky Widget COMPANY
		report.nextLine();  //empty line
		report.nextLine();  //EMPLOYEE        WEEKLY PAY
		report.nextLine(); //employee 444
		report.nextLine(); //employee 111
		report.nextLine(); //employee 332
		report.nextLine(); //employee 244
		assertEquals("343",report.next()); //employee 343
		assertEquals(2,company.getNumDesign());
	}

	@Test
	public void testAddEmployeeSTUDENT() {
		fail("Not yet implemted");
	}
	
	@Test
	public void testCalculateTotalWeeklyPay() {
		assertEquals(3517.50, company.calculateTotalWeeklyPay(), .001);
		company.addEmployee("Charles","Emory","Design", 7.50, 35, 343); //Design employee
		assertEquals(3780.00, company.calculateTotalWeeklyPay(), .001);
	
	}

	@Test
	public void testCalculateTotalWeeklyPaySTUDENT()
	{
		assertEquals(3517.50, company.calculateTotalWeeklyPay(), .001);
		company.addEmployee("Charles","Emory","Design", 7.50, 35, 343); //Design employee
		assertEquals(3780.00, company.calculateTotalWeeklyPay(), .001);
		company.removeEmployee("Charles","Emory");
		assertEquals(3517.50, company.calculateTotalWeeklyPay(), .001);
	}
	
	@Test
	public void testGetNumManager() {
		assertEquals(1, company.getNumManager());
	}

	@Test
	public void testGetNumDesign() {
		assertEquals(1, company.getNumDesign());
	}

	@Test
	public void testGetNumManufacturing() {
		assertEquals(1, company.getNumManufacturing());
	}

	@Test
	public void testGetNumSales() {
		assertEquals(1, company.getNumSales());
	}

	@Test
	public void testGenerateWeeklyReport() {
		String result = company.generateWeeklyReport();
		Scanner report = new Scanner(result);
		report.nextLine(); //WEEKLY PAY REPORT FOR Wacky Widget COMPANY
		report.nextLine();  //empty line
		report.nextLine();  //EMPLOYEE        WEEKLY PAY
		assertEquals("444",report.next()); //444
		assertEquals("$810.00",report.next()); //$1,200.00
		report.nextLine();//extracts newline at end of line
		assertEquals("111",report.next()); //22222

	}
	
	@Test
	public void testGenerateWeeklyReportSTUDENT() {
		String result = company.generateWeeklyReport();
		Scanner report = new Scanner(result);
		report.nextLine(); //WEEKLY PAY REPORT FOR Wacky Widget COMPANY
		report.nextLine();  //empty line
		report.nextLine();  //EMPLOYEE        WEEKLY PAY
		assertEquals("444",report.next()); //444
		assertEquals("$810.00",report.next()); //$1,200.00
		report.nextLine();//extracts newline at end of line
		assertEquals("111",report.next()); //22222	
		}
	
	@Test
	/**
	 * Test to
	 * 1.  add 3 new Employees as a manufacturing person
	 *     check if recognizes there are already 4 manufacturing persons
	 * 2.  add a new employee as a sales person
	 *     check if recognizes there is already a a sales person
	 * 3.  add 2 new employee as a design person
	 *     check if recognizes there is already 2 design persons
	 */
	public void testAddEmployeeForErrors() {
		String result;
		//add another designer - No problem, should return null
		result = company.addEmployee("Bobby", "Match", "Design",200,35,333);
		assertEquals(null, result);
		//add another designer - already 2 designers - return error message
		result = company.addEmployee("Albert","Pine", "Design",200,35,777);
		assertEquals("There are already two design persons\nEmployee not added", result);
		//add another sales person - already 1 sales person - return error message
		result = company.addEmployee("Susie", "Smith", "Sales",4000,0,888);
		assertEquals("There is already a sales person\nEmployee not added", result);
		//add another manufacturer - No problem, should return null
		result = company.addEmployee("Benedict", "Cumberbatch", "Manufacturing",.35,2500,999);
		assertEquals(null, result);
		//add another manufacturer - No problem, should return null
		result = company.addEmployee("Martin", "Freeman", "Manufacturing",.37,1500,543);
		assertEquals(null, result);
		//add another manufacturer - No problem, should return null
		result = company.addEmployee("Fred", "Flintstone", "Manufacturing",.37,1500,389);
		assertEquals(null, result);
		//add another manufacturer - already 4 manufacturers - return error message
		result = company.addEmployee("Andrew", "Scott", "Manufacturing",.52,1000,765);
		assertEquals("There are already four manufacturing persons\nEmployee not added", result);
			
	}
	
	@Test
	/**
	 * Test to:
	 * 1.  Check if the company name is on the first line
	 * 2.  Check if John is on the second line
	 * 3.  Check if Betty is on the third line
	 * 4.  Check if Stan is on the fourth line
	 * 5.  Check if Betty is on the fifth line
	 */
	public void testPrintCompany() {
		String result = company.printCompany();
		Scanner company = new Scanner(result);
		assertEquals("Wacky Widgets",company.nextLine()); 
		//extract three Employees
		assertEquals("John", company.next());
		company.nextLine();  //Smith     Position manufacturing (rest of line)
		assertEquals("Betty", company.next());
		company.nextLine();  //White     Position manager (rest of line)
		assertEquals("Stan",company.next());
		company.nextLine();  //Slimey     Position Sales (rest of line);
		assertEquals("Betty",company.next());
	}
}
