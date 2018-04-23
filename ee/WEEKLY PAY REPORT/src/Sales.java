/**
 * Sales employee
 *@author Rajashow Parajuli
 */
public class Sales extends Employee{
	private final static int bonus = 250;
	private final static Position p = Position.SALES;
	private double weeklySales;


	/** 
	 * Default Constructor for sales employee. calls super and init other fields to default super field and set the weeklySales to zero
	 */
	public Sales()
	{
		super();
		weeklySales = 0;
	}
	
	/**
	 * Parameterized constructor
	 * @param firstName first name 
	 * @param lastName last name 
	 * @param empNum employee number
	 * @param weeklySales weekly sales of this sales person
	 */
	public Sales(String firstName, String lastName, int empNum, double weeklySales)
	{
		super(firstName, lastName, empNum, p);
		this.weeklySales = weeklySales;
		
	}
	/**
	 * Get weekly pay for this sales person
	 */
	public double calculateWeeklyPay() {
		return (weeklySales * .057) + bonus;
	}
	
	/**
	 * Set weekly sales of this sales person
	 * @param weeklySales amount of weekly sales
	 */
	public void setWeeklySales(double weeklySales)
	{
		this.weeklySales = weeklySales;
	}
	
	/**
	 * Get weekly sales
	 * @return weekly sales
	 */
	public double getWeeklySales()
	{
		return weeklySales;
	}
	
	/**
	 * Checks user input data
	 */
	public boolean inputValidation()
	{
		return !(weeklySales < 0);
			
	}
	
	
}