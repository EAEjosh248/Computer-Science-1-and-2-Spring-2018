
/**
 * Designer subclass of Employee
 *  @author Rajashow Parajuli
 */
public class Design extends Employee{
	private final static Position p = Position.DESIGN;
	private double payRate;
	private double hours;
	
	/**
	 * Default constructor
	 * init everything fields to super class and then sets payRate and hours to 0
	 */
	public Design()
	{
		super();
		payRate = 0;
		hours = 0;
	}
	
	/**
	 * parameterized constructor
	 * @param firstName first name
	 * @param lastName last name 
	 * @param empNum employee number
	 * @param payRate pay rate
	 * @param hours hours worked
	 */
	public Design(String firstName, String lastName, int empNum, double payRate, double hours)
	{
		super(firstName, lastName, empNum, p);
		setPayRate(payRate);
		setHours(hours);
		
	}
	/**
	 * Gets weekly pay for this designer
	 */
	public double calculateWeeklyPay() {
		
		if(hours < 0 || payRate < 0)
			return -1;
		else{			
			return (hours <= 40)?hours*payRate:40 * payRate+(hours - 40) * (payRate*1.5);
		}
			
	}

	/**
	 * Get pay rate
	 * @return pay rate
	 */
	public double getPayRate() {
		return payRate;
	}

	/**
	 * Set pay rate
	 * @param payRate pay rate
	 */
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	/**
	 * Get hours worked
	 * @return hours 
	 */
	public double getHours() {
		return hours;
	}
	
	/**
	 * Set hours worked
	 * @param hours 
	 */
	public void setHours(double hours) {
		this.hours = hours;
	}
	
	/**
	 * Validates input by user
	 * @return false if either payRate or hours < 0.
	 */
	public boolean inputValidation()
	{return !(payRate < 0 || hours < 0);}

}