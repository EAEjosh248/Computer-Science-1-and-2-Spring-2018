import java.util.ArrayList;
/**
 * PasswordChecker
 * @author Rajashow Parajuli
 *  
 */
public class PasswordCheckerUtility {
	public static ArrayList<String> validPasswords(ArrayList<String> passwords) {
		ArrayList<String> output = new ArrayList<String>();
		for (String password : passwords) {
			try{
				isValidPassword(password);
			}
			catch(Exception e){
				output.add(e.getMessage());
			}
		}
		return output;
	}
	public static boolean isValidPassword(String password){
		boolean hasDigit,hasUpper,hasLower,hasSequn,valid;
		hasDigit=hasLower=hasUpper=hasSequn=false;
		valid =true;
		if(password.length()<6) {
			throw new LengthException(password);
		}
		for(int i =0 ; i < password.length();i++) {
		
			 if(Character.isDigit(password.charAt(i))) {
				 hasDigit = true;}

			 if(Character.isUpperCase(password.charAt(i))) {
				 hasUpper = true;}

			 if(Character.isLowerCase(password.charAt(i))) {
				 hasLower = true;}
			 if(i>2) {
				 if((password.charAt(i)==password.charAt(i-1))&&(password.charAt(i-1)==password.charAt(i-2))) {
					 hasSequn =true;
				 }
			 }}
			 if(!hasLower) {
					valid =false;
					throw new NoLowerAlphaException(password);
				}
			 if(!hasDigit) {
					valid =false;
					throw new NoDigitException(password);
				} 
			 if(!hasUpper) {
					valid =false;
				 throw new NoUpperAlphaException(password);
				} 
			
			 if(hasSequn) {
					valid =false;
					throw new InvalidSequenceException(password);
				} 
			return valid;
		}
		
	
	public static boolean isWeakPassword(String password) {
				return (password.length() >= 6 && password.length() < 10);
	}

	
}