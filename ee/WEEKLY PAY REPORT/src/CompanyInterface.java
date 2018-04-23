
/**
 * Interface for the Employees class for CMSC203, Assignment 6, Fall 2016
 * Contains an ArrayList of objects that inherit from the Abstract class Employee
 * Keeps track of the number of Mangers, Designers, Sales 
 *      and Manufacturing employees
 * Manages company employees
 * Create a static variable to keep track of the number
 * of company instances created
 * @author Professor Myers changed by Prof. Justh
 *
 */

public interface CompanyInterface {
	/**
	 * Add an employee to the ArrayList.
	 * @param type Type of employee: Manager, Design, Sales, Manufacturing
	 * @param fname First Name
	 * @param lname Last Name
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
	public String addEmployee(String fname, String lname, String type, double firstParam, int secondParam, int empNum);
	
	/**
	 * Remove a specified employee from the ArrayList.
	 * @param firstName First name of the employee to remove from the payroll
	 * @param lastName Last name of the employee to remove from the payroll
	 * @return true if the employee was successfully removed, false otherwise
	 */
	public boolean removeEmployee(String firstName, String lastName);
	
	/**
	 * Returns the number of Managers in the ArrayList
	 * @return number of Managers
	 */
	public int getNumManager();
	
	/**
	 * Returns the number of Hourly Workers in the ArrayList
	 * @return number of Hourly Workers
	 */
	public int getNumDesign();
	
	/**
	 * Returns the number of Commission Worker in the ArrayList
	 * @return number of Commission Worker
	 */
	public int getNumSales();
	
	/**
	 * Returns the number of Piece Worker in the ArrayList
	 * @return number of Piece Worker
	 */
	public int getNumManufacturing();
	
	/**
	 * Generates a weekly report of employee weekly pay
	 * @return String that contains the Weekly Report
	 */
	public String generateWeeklyReport();
	
	/**
	 * Calculate the total weekly pay for all employees in the ArrayList
	 * @return the total weekly pay for all employees
	 */
	public double calculateTotalWeeklyPay();
	
	/**
	   * Creates a string with the name of the company followed by the first and last name 
	   * and position of each of the employees
	   * @return string
	   * Example:
	   * <p>PigeonHawks</p>
	   * <p>John Smith   Position: Manufacturing</p>
	   * <p>Bob Jones   Position: Sales</p>
	   */
	  public String printCompany();
	  
	/**
	 * Creates a string representation of the object
	 * @return String that represents all the objects in the ArrayList
	 */
	public String toString();
	

}
