package netflixNchill;



public class driver {

	public static void main(String[] args) {
		// System.out.println("Done");
		GreetingRunnable r1 = new GreetingRunnable("Watching Netflix ...");
	      GreetingRunnable r2 = new GreetingRunnable("Playing Game");
	      
	      Thread t1 = new Thread(r1);
	      Thread t2 = new Thread(r2);
//	      
//	      t1.start();
	      t2.start();
	      
	       t1.run();
	       t2.run();
	      
	      

	}

}
