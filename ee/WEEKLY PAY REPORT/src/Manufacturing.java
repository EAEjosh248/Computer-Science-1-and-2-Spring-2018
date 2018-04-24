/**
 * The employee is of manufacturing subclass
 *  @author Rajashow Parajuli
 */
public class Manufacturing extends Employee
{
	// Fields
	private final static Position p = Position.MANUFACTURING;
	private double pieceAmount;
	private double pricePerPiece;



	/**
	 * Default constructor for Manufacturing
	 */
	public Manufacturing()
	{
		super();
		setPieceAmount(0);
		setPricePerPiece(0);
	}
	
	/**
	 * Parameterized constructor
	 * @param firstName first name
	 * @param lastName last name 
	 * @param pieceAmount piece amount 
	 * @param pricePerPiece price per piece 
	 * @param empNum employee number
	 */
	public Manufacturing(String firstName, String lastName, double pieceAmount, double pricePerPiece, int empNum)
	{
		// call super
		super(firstName, lastName, empNum, p);
		setPieceAmount(pieceAmount);
		setPricePerPiece(pricePerPiece);
	}
	/**
	 * Gets weekly pay for manufacturer
	 */
	public double calculateWeeklyPay() {
		return pieceAmount* pricePerPiece;
	}
	
	/**
	 * Returns amount of pieces
	 * @return  pieceAmount 
	 */
	public double getPieceAmount() {
		return pieceAmount;
	}
	
	/**
	 * Set amount of pieces
	 * @param pieceAmount - the number of pieces
	 */
	public void setPieceAmount(double pieceAmount) {
		this.pieceAmount = pieceAmount;
	}
	
	/**
	 * Returns price per piece
	 * @return pricePerPiece
	 */
	public double getPricePerPiece() {
		return pricePerPiece;
	}
	
	/**
	 * Set price per piece
	 * @param pricePerPiece - the price for each piece
	 */
	public void setPricePerPiece(double pricePerPiece) {
		this.pricePerPiece = pricePerPiece;
	}
	
	
}