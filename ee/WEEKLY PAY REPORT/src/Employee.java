/**
 * Abstract class Employee represents an employee
 *  @author Rajashow Parajuli
 */
public abstract class Employee 
{
	private String firstName;
	private String lastName;
	private int employeeNumber;
	private Position p;
	
	/**
	 * Default constructor
	 */
	public Employee() {
		firstName = "";
		lastName = "";
		employeeNumber = -1;
		p = null;
	}
	
	/**
	 * Specialized constructor
	 * @param firstName first name
	 * @param lastName last name
	 * @param employeeNumber employee number
	 * @param p position of this employee
	 */
	public Employee(String firstName, String lastName, int employeeNumber, Position p)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.p = p;
	}

	/**
	 * Get weekly pay
	 * @return double weekly pay
	 */
	public abstract double calculateWeeklyPay();

	/**
	 * String representation of Employee
	 * @return String representation of Employee
	 */
	public String toString() {
		if(String.valueOf(calculateWeeklyPay()) != null){
			return String.valueOf(employeeNumber) + "           $"  + calculateWeeklyPay()+"0";
		}
		return null;
	}
	/**
	 * String infomation of Employee with their names
	 * @return String representation of Employee
	 */
	public String empInfo() {
		if(String.valueOf(calculateWeeklyPay()) != null){
			return (firstName +" " +lastName) + "           Postion:"  +p ;
		}
		return null;
	}
	/**
	 * Get position of Employee
	 * @return position of this employee
	 */
	public Position getPos() {
		return p;
	}

	/**
	 * Set position of this Employee
	 * @param pos position of this Employee
	 */
	public void setPos(Position pos) {
		this.p = pos;
	}
	
	/**
	 * get first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set firstName
	 * @param FirstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * get last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set last name
	 * @param lastName last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * get employee number
	 * @return employee number
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * set employee number
	 * @param employeeNumber
	 */
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
}