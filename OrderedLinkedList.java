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
	public boolean add(Comparable obj)
	{
		// TODO: Implement this method (8 points)
		
	}

	
	/*
	 *	Remove the first occurrence of the specified item from this OrderedLinkedList.
	 *
	 *	@param	obj		the item to be removed
	 */
	public boolean remove(Comparable obj)
	{
		// TODO: implement this method (7 points)
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
	public static class OrderedListNode
	{
		
		
		
		/************
		 * Attributes   
		 ************/
		
		
		/** the data item */
		Comparable theItem;
		
		/** reference to the next node in the list */
		OrderedListNode next;
		
		/** reference to the previous node in the list */
		OrderedListNode previous;
		
		
		
		/**************
		 * Constructors
		 **************/
		
		
		OrderedListNode(Comparable theItem)
		{
			this(theItem, null, null);
		}
		
		
		OrderedListNode(Comparable item, OrderedListNode previousNode, OrderedListNode nextNode)
		{
			this.theItem = item;
			this.previous = previousNode;
			this.next = nextNode;
		}
		
		
		
		/*********
		 * Methods
		 *********/
		
		
		/** get the item of data from a cell */
		Comparable getData()	
		{
			return theItem;
		}
		
		/** get a reference to the previous node */
		OrderedListNode getPrevious()	
		{
			return previous;
		}
		
		/** get a reference to the next node */
		OrderedListNode getNext()
		{
			return next;
		}
		
	}

	/**
	 *	Nested class OrderedListNode.
	 *
	 *	Encapsulates the fundamental building block of an OrderedLinkedList
	 *	contains a data item, and references to both the next and previous nodes
	 *	in the list
	 */
	
	
	// TODO: Implement the nested class OrderedListNode (5 points).  This nested class
	// should be similar to the nested class ListNode of the class LinkedList, but
	// should store a data item of type Comparable rather than Object.
    
}
