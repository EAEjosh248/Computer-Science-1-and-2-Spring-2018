@SuppressWarnings("serial")
public class LengthException extends RuntimeException {
	   public LengthException(String message)  
	   {   
		   super( message + " The password must be at least 6 characters long."); 
		   System.out.println(message+"6L");
    } 
	   } 

