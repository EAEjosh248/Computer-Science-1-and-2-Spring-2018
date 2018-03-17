@SuppressWarnings("serial")
public class WeakPasswordException extends RuntimeException
{
  public WeakPasswordException(String message) {
    super( message + " Password is OK but weak.");
	   System.out.println(message);

  }
}