import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private int size=-1,length=0;
	private T [] _stack;
	public MyQueue(int i) {
		length=i;
		_stack= (T[]) new Object[length];
	}

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return size==-1;
	}

	/**
	 * Determines of the Queue is empty
	 * @return
	 */
	@Override
	public boolean isFull() {
		return size+1==length;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (size==-1)
			throw new QueueUnderflowException();
		T temp = _stack[0];
		for(int i =0;i<size;i++) {
			_stack[i]=_stack[i+1];
		}
		size--;
		return temp;
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return size+1;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(size+1==length)
			throw new QueueOverflowException();
		size++;
		_stack[size]=e;
		return true ;
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String str=""; 
		for(int i=0; i<=size;i++) {
			str += _stack[i];
		}
		return str;	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str=""; 
		for(int i=0; i<=size;i++) {
			if(i!=0)
				str+=delimiter;
			str += _stack[i];
		}
		return str;	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  */
	@Override
	public void fill(ArrayList<T> list) {
		size =list.size()-1;
		_stack = list.toArray((T[])new Object[length]);
	}
	
 

}
