/**
 * Lab07.java : A Driver program that tests out ArrayStack
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class Lab07
{
	/**
	 * Driver for Lab07
	 * 
	 * Algorithm:
	 * 1. Create the ArrayStack
	 * 2. Fill the ArrayStack
	 * 3. While not empty, peek, then pop each item
	 * @param args command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		//Create the ArrayStack
		ArrayStack<String> aStack = new ArrayStack<String>();
		
		//Fill the ArrayStack (test push)
		System.out.println("Pushing " + aStack.push("A"));
		System.out.println("Pushing " + aStack.push("B"));
		System.out.println("Pushing " + aStack.push("C"));
		
		//While not empty, peek, then pop each item
		while (!aStack.empty()) // test empty
		{
			System.out.println("Peeking at top: " + aStack.peek()); //test peek
			System.out.println("Poping at top: " + aStack.pop()); //test pop
		}
		System.out.println("The ArrayStack is now empty!");
	}
}