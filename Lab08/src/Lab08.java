import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Lab08.java : A Driver program test out Lab08
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class Lab08
{
	/**
	 * Driver for Lab08
	 * 
	 * Algorithm:
	 * 1. Create the three necessary data structures (LinkedList implements Queue)
	 * 2. Fill the first stack with six values
	 * 3. Fill the second stack and queue with inverse of first stack
	 * 4. Empty both the stack and queue and display each value pair
	 * @param args command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		//Create the three necessary data structures
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		
		//Fill the first stack with six values
		s1.push(-1);
		s1.push(15);
		s1.push(23);
		s1.push(44);
		s1.push(4);
		s1.push(99);
		
		//Fill the second stack and queue with inverse of first stack
		while(!s1.empty())
		{
			Integer temp = s1.pop();
			s2.push(temp);
			q1.offer(temp);
		}
		
		//Empty both the stack and queue and display each value pair
		while(!s2.empty())
		{
			Integer sNum = s2.pop();
			Integer qNum = q1.remove();
			System.out.println("Stack: " + sNum + "  Queue: " + qNum);
		}
	}
}