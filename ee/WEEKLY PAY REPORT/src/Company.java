// imports
import java.util.ArrayList;
import java.text.NumberFormat;

/**
 * 
 *
 */
public class Company implements CompanyInterface {
	// Fields
	private String companyName;
	private ArrayList<Employee> employees;
	private static int numberOfCompanies = 0;
	private int numDesign;
	private int numEmployees;
	private int numManufacturing;
	private int numSales;
	private int numManager;
	private NumberFormat fmt;
	
	
	
		
	
	/**
	 * Constructor for company
	 * @param arg name of company
	 */
	public Company(String arg)
	{
		// Instantiate fields
		companyName = arg;
		employees = new ArrayList<Employee>();
		numSales = 0;
		numEmployees = 0;
		numDesign = 0;
		numManufacturing = 0;
		numManager = 0;
		fmt = NumberFormat.getCurrencyInstance();
	}
	/**
	 * returns  name of company
	 * @return  companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * set the name of company
	 * @param  companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Add an employee to the ArrayList.
	 * @param type Type of employee: Manager, Design, Sales, Manufacturing
	 * @param firstName First Name
	 * @param lastName Last Name
	 * @param firstParam Manager-salary, Design-hourly rate, Sales-weekly sales, Manufacturing-rate per piece
	 * @param secondParam Manager-not needed (0), Design-number of hours, Sales-not needed (0), Manufacturing-number of pieces
	 * @param empNum employee number
	 * @return null if successful add.  Returns a string that describes the reason 
	 * for not adding the employee.  It will be one of the following:
	 * <p>1.  There is already a sales person\nEmployee not added</p>
	 * <p>2.  There are already two design persons\nEmployee not added</p>
	 * <p>3.  There are already four manufacturing persons \nEmployee not added</p>
	 * <p>4.  There is already a manager\nEmployee not added</p>
	 * <p>5.  There are already 8 employees\nEmployee not added</p>
	 */
	public String addEmployee(String firstName, String lastName, String pos,double firstParam, int secondParam, int empNum)
	{	
		if(numSales == 1 && pos.equals("Sales")){
			return "There is already a sales person\nEmployee not added";
		}
		else if(numDesign == 2 && pos == "Design")
			return "There are already two design persons\nEmployee not added";
		else if(numManufacturing == 4 && pos.equals("Manufacturing"))
			return "There are already four manufacturing persons\nEmployee not added";
		else if (numManager == 1 && pos.equals("Manager"))
			return "There is already a manager\nEmployee not added";
		else if(this.getNumEmployees()== 8)
			return "There are already 8 employees\nEmployee not added";
		else if(pos.equals("Sales") == false && pos.equals("Design") == false && pos.equals("Manufacturing") == false && pos.equals("Manager") == false)
			return "That position does not exist";
		else{
			if(pos.equals("Sales")){
				Sales s = new Sales(firstName, lastName, empNum, firstParam);
				employees.add(s);
				numSales++;
			}
			else if (pos.equals("Design")){
				Design d = new Design(firstName, lastName, empNum, firstParam, secondParam);
				employees.add(d);
				numDesign++;
			}
			else if(pos.equals("Manufacturing")){
				Manufacturing m = new Manufacturing(firstName, lastName, secondParam, firstParam, empNum);
				employees.add(m);
				numManufacturing++;
			}
			else{
				Manager m = new Manager(firstName, lastName, empNum, firstParam);
				employees.add(m);
				numManager++;
			}
			return null;
		}
	}
	

	/**
	 * Gets the number of employees
	 * @return number of employees
	 */
	public int getNumEmployees()
	{
		return numEmployees;
	}
	
	/**
	   * Creates a string with the name of the company followed by the first and last name 
	   * and position of each of the employees
	   * @return string
	   * Example:
	   * <p>PigeonHawks</p>
	   * <p>John Smith   Position: Manufacturing</p>
	   * <p>Bob Jones   Position: Sales</p>
	   */
	public String printCompany()
	{
		String a = companyName;
		a = this.companyName + "\n";
		for(Employee e: employees){
			a += e.getFirstName() + " " + e.getLastName()+ "  Position: " + e.getPos() + "\n";
		}
		return a;
	}
	/**
	 * Creates a string representation of the object
	 * @return String that represents all the objects in the ArrayList
	 */
	public String toString()
	{
		String s = "";
		for(Employee e : employees){
			s += e.toString() + "\n";
		}
		return s;
	}
	/**
	 * Creates a string of employeee info 
	 * @return String that represents all the objects as employees in the ArrayList
	 */
	public String listOfEmp()
	{
		String s = "";
		for(Employee e : employees){
			s += e.empInfo() + "\n";
		}
		return s;
	}



	/**
	 * Generates a weekly report of employee weekly pay
	 * @return String that contains the Weekly Report
	 */
	public String generateWeeklyReport() {
		// TODO Auto-generated method stub
		String s = "WEEKLY PAY REPORT FOR " + companyName + " COMPANY\n\nEMPLOYEE        WEEKLY PAY\n" + toString() + "\nTotal payroll: " + fmt.format(calculateTotalWeeklyPay()) + "\nTotal number of managers paid:   " + String.valueOf(numManager) + "\nTotal number of Design employees paid:  " + String.valueOf(numDesign) + "\nTotal number of Sales employees paid:  " + String.valueOf(numSales) + "\nTotal number of Manufacturing employees paid:  " + String.valueOf(numManufacturing) ;
		return s;
	}

	/**
	 * Calculate the total weekly pay for all employees in the ArrayList
	 * @return the total weekly pay for all employees
	 */
	public double calculateTotalWeeklyPay() {
		double total = 0;
		for(Employee e: employees){
			
			total += e.calculateWeeklyPay();
		}
		return total;
	}


	/**
	 * Returns the number of Managers in the ArrayList
	 * @return number of Managers
	 */
	public int getNumManager() {
		// TODO Auto-generated method stub
		return numManager;
	}

	/**
	 * Returns the number of Hourly Workers in the ArrayList
	 * @return number of Hourly Workers
	 */
	public int getNumDesign() {
		// TODO Auto-generated method stub
		return numDesign;
	}

	/**
	 * Returns the number of Commission Worker in the ArrayList
	 * @return number of Commission Worker
	 */
	public int getNumSales() {

		return numSales;
	}


	/**
	 * Returns the number of Piece Worker in the ArrayList
	 * @return number of Piece Worker
	 */
	public int getNumManufacturing() {
		// TODO Auto-generated method stub
		return numManufacturing;
	}
	/**
	 * Remove a specified employee from the ArrayList.
	 * @param firstName First name of the employee to remove from the payroll
	 * @param lastName Last name of the employee to remove from the payroll
	 * @return true if the employee was successfully removed, false otherwise
	 */
	@Override
	public boolean removeEmployee(String firstName, String lastName) {
		
for(int i = 0; i< employees.size();i++) {
	if(employees.get(i).getFirstName().equals(firstName)&&employees.get(i).getLastName().equals(lastName)) {
		employees.remove(i);
		return true;
	}
}	
		return false;
	}
	
}