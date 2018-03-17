@SuppressWarnings("serial")
public class NoUpperAlphaException extends RuntimeException {
	public NoUpperAlphaException(String message) {
		super(message + " The password must contain at least one uppercase alphabetic character");
		   System.out.println(message+"NU");

	}
}
