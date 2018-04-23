
/**
 * Designer subclass of Employee
 *@author Rajashow parajuli
 */
public class Manager extends Employee{
	// Fields
		private final static Position p = Position.MANAGER;
		private double salary;

	/**
	 * Default constructor
	 * init everything fields to super class and then sets salary to 0
	 */
public Manager()
{
	super();
	salary = 0;
}
	
	/**
	 * Parameterized constructor
	 * @param firstName first name
	 * @param lastName last name 
	 * @param empNum employee number
	 * @param payRate pay rate
	 * @param hours hours worked
	 */
public Manager(String firstName, String lastName, int empNum, double salary)
{
	super(firstName, lastName, empNum, p);
	this.salary = salary;
}

	/**
	 * Gets weekly pay for this designer
	 */
/**
 * Calculates weekly pay of this manager
 */
public double calculateWeeklyPay() {
	// TODO Auto-generated method stub
	return salary;
}

/**
 * get salary of this manager
 * @return salary
 */
public double getSalary() {
	return salary;
}

/**
 * Set salary of this manager
 * @param salary
 */
public void setSalary(double salary) {
	this.salary = salary;
}

/**
 * Validates input from user
 * @return false if salary < 0.
 */
public boolean inputValidation()
{
	return !(salary < 0);
}
}