import java.util.ArrayList;

/**
 * ArrayStack.java : A class that uses an ArrayList to function as a Stack
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class ArrayStack<E> implements Stack<E>
{
	private ArrayList<E> theData;
	
	/**
	 * 0-arg constructor for ArrayStack
	 */
	public ArrayStack()
	{
		theData = new ArrayList<E>();
	}
	
	/**
	 * Gets theData
	 * 
	 * @return theData
	 */
	public ArrayList<E> getData()
	{
		return theData;
	}
	
	/**
	 * Returns true if theData is empty
	 * 
	 * @return true if theData is empty, false if not
	 */
	public boolean empty()
	{
		return theData.isEmpty();
	}
	
	/**
	 * Pushes item onto the stack
	 * 
	 * @param item Item to be added to the stack
	 * @return the item that was added to the stack
	 */
	
	public E push(E item)
	{
		theData.add(item);
		return item;
	}
	
	/**
	 * Looks at the data on the top of the stack
	 * 
	 * @return the data located on the top of the stack
	 */
	public E peek()
	{
		return theData.get(theData.size() - 1);
	}
	
	/**
	 * Removes the data on the top of the stack
	 * 
	 * @return the data removed from the top of the stack
	 */
	public E pop()
	{
		return theData.remove(theData.size() - 1);
	}
	
	/**
	 * Returns a string representation of ArrayStack
	 * The left is the bottom and the right is the top
	 * 
	 * @return The theData ArrayList's toString method
	 */
	public String toString()
	{
		return theData.toString();
	}
	
	/**
	 * Returns true if the ArrayStacks are equal, false if not
	 * 
	 * @param other The other ArrayStack to compare
	 * @return True if the two theData are equal, false if not
	 */
	public boolean equals(ArrayStack<E> other)
	{
		return theData.equals(other.getData());
	}
}