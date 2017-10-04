/**
 * Stack.java : An interface that states the essential methods for implementing a Stack
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

public interface Stack<E>
{
	/**
	 * Returns true if the Stack is empty
	 * 
	 * @return true if the Stack is empty, false if not
	 */
	public abstract boolean empty();
	
	/**
	 * Pushes item onto the stack
	 * 
	 * @param item Item to be added to the stack
	 * @return the item that was added to the stack
	 */
	public abstract E push(E item);
	
	/**
	 * Looks at the data on the top of the stack
	 * 
	 * @return the data located on the top of the stack
	 */
	public abstract E peek();
	
	/**
	 * Removes the data on the top of the stack
	 * 
	 * @return the data removed from the top of the stack
	 */
	public abstract E pop();
}