import java.util.ArrayList;
import java.util.ListIterator;



public class BasicDoubleLinkedList <T> {
	protected int size =0;
	protected Node header,last;
	protected void addToEnd(T elem) {
		Node n = new Node();
		if(n != null) {// out of memory
			n.next = header.next;
			header.next = n;
			n.item = (T)elem;	
			size++;}
	}
	protected void addToFront(T elem) {
		
		Node n = new Node();
		if(n != null) {// out of memory
			n.next = header.next;
			header.next = n;
			n.item = (T)elem;	
			size++;}
	
		
	}


	protected int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	protected T getLast() {
		// TODO Auto-generated method stub
		return last.item;
	}

	protected T getFirst() {
		// TODO Auto-generated method stub
		return header.item;
	}

	
	protected ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void remove(T elem,  java.util.Comparator<T> comparator) {
		// TODO Auto-generated method stub
		
	}



	protected Object retrieveFirstElement() {
		size--;
		// TODO Auto-generated method stub
		return null;
	}

	protected Object retrieveLastElement() {
		size--;
		// TODO Auto-generated method stub
		return null;
	}

	protected ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

	protected class Node
	{  protected T item;
	protected Node next,previous;
	protected Node() {}
	}
}

