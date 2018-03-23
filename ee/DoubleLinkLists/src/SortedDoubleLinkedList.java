import java.util.ListIterator;


/**
	Implements a generic sorted double list using a provided Comparator. It extends BasicDoubleLinkedList class. 




@Author: Rajashow Parajuli
	 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	java.util.Comparator<T> comp = null;
	/**
	 *  Creates an empty list that is associated with the specified comparator.
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> comparator2) {
		comp = comparator2;
	}
	/**
*Inserts the specified element at the correct position in the sorted list. Notice we can insert the same element several times. Your implementation must traverse the list only once in order to perform the insertion. Do not implement this method using iterators. Notice that you don't need to call any of the super class methods in order to implement this method. 
*@param elem - the data to be added to the list 
*	@return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T elem) {
		if (elem == null) {
			return this;
		}

		Node newnode = new Node(elem, null, null);
		if (header == null) {
			header = tail = new Node(elem, null, null);
		} else {
			if (comp.compare(elem, header.item) <= 0) {
				newnode.next = header;
				header = newnode;
			} else if (comp.compare(elem, tail.item) >= 0) {
				tail.next = newnode;
				tail = newnode;
			} else {
				Node next = header.next;
				Node prev = header;
				while (comp.compare(elem, next.item) > 0) {
					prev = next;
					next = next.next;
				}
				prev.next = newnode;
				newnode.next = next;
			}
		}
		size++;
		return this;
	}
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."  
	 * @param data - the data for the Node within the linked list 
	 * @return reference to the current object 
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data)  {
		throw new UnsupportedOperationException();
	}
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list." 
@param data - the data for the Node within the linked list 
	 * @return reference to the current object 
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException();
	}
	/**
	 * Implements the remove operation by calling the super class remove method.  
	 * @param data - the data for the Node within the linked list 
	 * @param comparator - the comparator to determine equality of data elements 
	 * @return reference to the current object 
*/
	public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator) {
		Node next = header;
		Node prev = null;
		while (next != null) {
			if (comparator.compare(next.item, data) == 0) {
				size--;
				if (prev != null) {
					prev.next = next.next;
				} else {
					header = next.next;
				}
				if (next == tail) {
					tail = prev;
				}
			}
			prev = next;
			next = next.next;
		}

		return this;

	}

	public ListIterator<T> iterator() {
		return new iter();
	}
	}

