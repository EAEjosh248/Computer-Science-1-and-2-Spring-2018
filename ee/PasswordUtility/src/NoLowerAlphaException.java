@SuppressWarnings("serial")
public class NoLowerAlphaException extends RuntimeException {
	public NoLowerAlphaException(String message) {
		super(message + " The password must contain at least one lowercase alphabetic character");
		System.out.println(message+"NL");

	}
}
