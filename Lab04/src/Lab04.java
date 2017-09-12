/**
 * Lab4.java : Compares the values of y1 and y2 in the expressions of n up to 100
 * 		in increments of 10 and then displays the results to the user.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

public class Lab04
{
	/**
	 * Driver for Lab4
	 * 
	 * Algorithm:
	 * 1. Initialize the two expression values to 0.
	 * 2. Print out the table header.
	 * 3. Enter a for loop based on variable n, up to 100, in increments of 10.
	 * 4. In the loop, evaluate the new y1 and y2.
	 * 5. In the loop, display the new values in a tabular format.
	 * 
	 * @param args
	 *            command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		int y1, y2 = 0;
		System.out.println("  n          y1         y2");
		for (int n = 0; n < 101; n+=10)
		{
			y1 = 100 * n + 10;
			y2 = 5 * n * n + 2;
			System.out.printf("%3d  %10d %10d \n", n, y1, y2);
		}
	}
}