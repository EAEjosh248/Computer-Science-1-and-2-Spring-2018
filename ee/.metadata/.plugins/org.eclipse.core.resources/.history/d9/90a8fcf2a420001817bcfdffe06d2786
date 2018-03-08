package Linklist;

import Linklist.DS;

public class LinkedList <T extends DS>
{  
	private Node h;  // list header

	public LinkedList()
	{  
		h = new Node();  // dummy node
		h.item = null;
		h.next = null;
	}


	public boolean insert(T t)
	{  
		Node n = new Node();
		if(n == null) // out of memory
			return false;
		else
		{ 
			n.next = h.next;
			h.next = n;
			n.item = (T)t.deepCopy();
			return true;
		}
	}


	public T fetch(Object targetKey)
	{  Node p = h.next;  // set p to refer to the first node
	 while ( p != null  &&  0!= (p.item.compareTo(targetKey))) // move p down list
	       p = p.next; 
	if (p != null)   // requested node was found
	       return (T) p.item.deepCopy( );  
	    else
	      return null;  // the request node is not in the list

	}


	public boolean delete(Object targetKey)
	{  
		Node q = h; // set trailing reference, q, to reference the dummy node
	     Node p = h.next;  // set p pointing to the node after the dummy node
	     while ( p != null  &&  p.item.compareTo(targetKey)!=0) // traverse the list
	     {  q = p;    // make q trail p throughout the traverse
	        p = p.next; }  
	     if (p != null)   // node found
	     {  q.next = p.next;  // “jump over” the deleted node  
	        return true;}
	     else  return false;
	     } 
		
	


	public boolean update(Object targetKey, T newCookie)
	{  
		System.out.println("UPDATEE: TO DO");
		return false;

	}


	public void showAll()
	{ Node p = h.next;
	while (p != null) //continue to traverse the list
	{   System.out.println(p.item.toString( ));
	p = p.next;
	}
	}


	public class Node
	{  private T item;
	private Node next;
	public Node() {}
	}// end of inner class Node

}//end SinglyLinkedList outer class

