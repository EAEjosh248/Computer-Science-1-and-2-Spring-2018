/**
* This enumerated class will help to identify the valid values of company positions, which are "Manager","Sales","Design", and "Manufacturing".  
* @author Rajashow Parajuli
*/ 
public enum Position {
	MANAGER("Manager"), SALES("Sales"), DESIGN("Design"), MANUFACTURING("Manufacturing");
	
	private String positionName;
	
	/**
	 * Constructor
	 * @param name of position
	 */
	Position(String pos)
	{
		positionName = pos;
	}
	
	
	/**
	 * Returns the string value 
	 * @return string value of the position name.
	 */
	public String getPositionName()
	{
		return positionName;
	}
	
	
	/**
	 * Returns the string value
	 * @return string representation of the position name.
	 */
	public String toString()
	{
		return positionName;
	}
}
