package Linklist;


public class driver {

	public static void main(String[] args) {
		
	    LinkedList cookies = new LinkedList();
	    Cookies peanut_cookie = new Cookies("Peanut Butter");
	    Cookies chip_cookie = new Cookies("Chips");
	    Cookies raisin_cookie = new Cookies("Raisin");
	    Cookies sugar_cookie = new Cookies("Sugar");
		
	    cookies.insert(peanut_cookie);  
	    cookies.insert(chip_cookie);  
	    cookies.insert(raisin_cookie); 
	    cookies.insert(sugar_cookie);
	    cookies.showAll();
	    System.out.println(cookies.fetch("Chips").toString());
	    cookies.delete("Chips");
	    cookies.showAll();
	    System.out.println("Done");
		 System.exit(0);

	}
}
