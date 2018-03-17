@SuppressWarnings("serial")
public class InvalidSequenceException extends RuntimeException {
	   public InvalidSequenceException(String message)  
	   {       super( message + " The password cannot contain more than two of the same character in sequence.");   
	   System.out.println(message+"IS");
} 
	   
} 

