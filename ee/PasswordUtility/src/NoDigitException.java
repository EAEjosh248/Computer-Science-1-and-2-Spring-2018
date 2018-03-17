@SuppressWarnings("serial")
public class NoDigitException extends RuntimeException {
	
	   public NoDigitException(String message)  
	   {   super( message + " The password must contain at least one digit.");
	   System.out.println(message+"ND");

    } 
	   } 

