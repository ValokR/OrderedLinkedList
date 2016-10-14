package dataStructures;
import java.util.*;

/**
 *	Class OrderedLinkedList.
 *
 *	This class functions as a linked list, but ensures items are stored in ascending order.
 *
 */
public class OrderedLinkedList
{
	
	/**************************************************************************
	 * Constants
	 *************************************************************************/
	
	/** return value for unsuccessful searches */
	private static final OrderedListNode NOT_FOUND = null;
	

	/**************************************************************************
	 * Attributes
	 *************************************************************************/

	/** current number of items in list */
	private int theSize;
	
	/** reference to list header node */
	private OrderedListNode head;
	
	/** reference to list tail node */
	private OrderedListNode tail;
	
	/** current number of modifications to list */
	private int modCount;
	
	
	/**************************************************************************
	 * Constructors
	 *************************************************************************/

	
	/**
	 *	Create an instance of OrderedLinkedList.
	 *
	 */
	public OrderedLinkedList()
	{
		// empty this OrderedLinkedList
		clear();
	}
	
	
	/**************************************************************************
	 * Methods
	 *************************************************************************/


	/*
	 *	Add the specified item to this OrderedLinkedList.
	 *
	 *	@param	obj		the item to be added
	 */
	
	public boolean add(Comparable obj) {
		//create new node
		OrderedListNode node = new OrderedListNode(obj);
		
		/** special case: list is empty */
		if (head.next == tail) {
			head.next = node;
			node.previous = head;
			node.next = tail;
			tail.previous = node;
			
			return true;
		}
		
		/** special case: new object is first in the list */
		if (obj.compareTo(head.next.theItem) < 0) {
			OrderedListNode originalFirstNode = head.next;
			node.next = head.next;
			originalFirstNode.previous = node;
			head.next = node;
			node.previous = head;
			
			return true;
		}
		
		/** special case: new object is last in the list */
		if (obj.compareTo(tail.previous.theItem) > 0) {
			OrderedListNode originalLastNode = tail.previous;
			node.next = tail;
			node.previous = originalLastNode;
			originalLastNode.next = node;
			tail.previous = node;
			
			return true;
		}
		
		/** when new object is in between the first and last items of the list */
		OrderedListNode previous = head;
		OrderedListNode current = head.next;
		
		// traverse through items in list until you find an object that is > new object */
		while (current != tail && node.theItem.compareTo(current.theItem) >= 0) {
			previous = current;
			current = current.next;
		}
		
		previous.next = node;
		node.previous = previous;
		node.next = current;
		current.previous = node;
		
		return true;
	}

	
	/*
	 *	Remove the first occurrence of the specified item from this OrderedLinkedList.
	 *
	 *	@param	obj		the item to be removed
	 */
	
	public boolean remove(Comparable obj)
	{
		/** special case: list is empty */
		if (head.next == tail) {
			return false;
		}
		
		/** list is not empty */
		OrderedListNode previous = head;
		OrderedListNode current = head.next;
		OrderedListNode next = current.next;
		
		// traverse through list until 1. current references the tail node or 2. an matching item is found
		while (current != null && !(current.theItem.compareTo(obj) == 0)) {
			previous = current;
			current = next;
			next = next.next;
		}
		
		// when the specified item is not found in the list
		if (current == null) {
			return false;
		} else {          // when item is found in the list
		    previous.next = next;
		    next.previous = previous;
		    return true;
		}
	}

	
	/**
	 *	Empty this OrderedLinkedList.
	 */
	public void clear()
	{
		// reset header node
		head = new OrderedListNode("HEAD", null, null);
		
		// reset tail node
        tail = new OrderedListNode("TAIL", head, null);
        
        // header references tail in an empty LinkedList
        head.next = tail;
        
        // reset size to 0
		theSize = 0;
		
		// emptying list counts as a modification
		modCount++;
	}


	/**
	 *	Return true if this OrderedLinkedList contains 0 items.
	 */
	public boolean isEmpty()
	{
		return theSize == 0;
	}


	/**
	 *	Return the number of items in this OrderedLinkedList.
	 */
	public int size()
	{
		return theSize;
	}
	

	/*	
	 *	Return a String representation of this OrderedLinkedList.
	 *
	 *	(non-Javadoc)
     *	@see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
    	String s = "";
    	
    	OrderedListNode currentNode = head.next;
    	
    	while (currentNode != tail)
    	{
    		s += currentNode.theItem.toString();
    		
    		if (currentNode.next != tail)
    		{
    			s += ", ";
    		}
    		
    		currentNode = currentNode.next;
    	}
    	
    	return s;
    }

	
	/**************************************************************************
	 * Inner Classes
	 *************************************************************************/
	public static class OrderedListNode {
		/*
		 * Attributes   
		 */
		
		// the data item
		Comparable theItem;
		// reference to the next node in the list
		OrderedListNode next;
		// reference to the previous node in the list
		OrderedListNode previous;
		
		/*
		 * Constructors
		 */
		
		OrderedListNode(Comparable theItem) {
			this(theItem, null, null);
		}
		
		OrderedListNode(Comparable item, OrderedListNode previousNode, OrderedListNode nextNode) {
			this.theItem = item;
			this.previous = previousNode;
			this.next = nextNode;
		}
		
		/*
		 * Methods
		 */
		
		// get the item of data from a cell
		Comparable getData() {
			return theItem;
		}
		// get a reference to the previous node
		OrderedListNode getPrevious() {
			return previous;
		}
		// get a reference to the next node
		OrderedListNode getNext() {
			return next;
		}
		
	}
	
	/***** for testing purposes only *************
	public static void main(String[] args)
	{
		OrderedLinkedList list = new OrderedLinkedList();
	     list.add("first");
	     list.add("last");
	     list.add("next");
	     list.add("before");
	     list.add("after");
	     System.out.println(list.toString());
	     list.remove("last");
	     System.out.println(list.toString());
	} *******************************************/
}
