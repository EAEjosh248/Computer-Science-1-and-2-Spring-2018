package thread_lab;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

	Queue<Integer> qeue = new ArrayDeque<>();
	Random rand =  new Random();
	public CarQueue () {
		for(int i =0 ; i < 5; i++ ) {
		qeue.add(rand.nextInt(4));
		}
		
	}
	public void addToQueue() {
		class MyRunnable implements Runnable{

			@Override
			public void run() {
try {
	for(int i = 0 ; i<4;i++)
	qeue.add(rand.nextInt(4));
	Thread.sleep(1000);
}				catch(InterruptedException e) {
	
}
			}
			
		}
	
		MyRunnable running  = new MyRunnable() ;
		Thread t = new Thread(running);
		t.start();
	
	}
	public int deleteQueue() {
if(qeue.isEmpty())
	return 0;

return qeue.remove();
	}
}
