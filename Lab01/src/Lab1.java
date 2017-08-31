/**
 * Lab1.java : Displays numbers 1-100 except Fizz every multiple of 3, Buzz
 * 		every multiple of 5, and Fizzbuzz every multiple of 15
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

public class Lab1
{
	/**
	 * Driver for Lab1
	 * 
	 * Algorithm:
	 * 1. Enter a for loop from x = 1 to x = 100
	 * 2. In each pass, check to see if the number is not a multiple of both 3 or 5, and if
	 * 		it isn't display just the number
	 * 3. Else if it is just a multiple of 3, but not 5, display Fizz
	 * 4. Else if it is just a multiple of 5, display Buzz
	 * 5. Else it must be a multiple of 3 & 5, so display Fizzbuzz
	 * 
	 * @param args
	 *            command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		for (int x = 1; x < 101; x++)
		{
			if ( x % 3 != 0 && x % 5 != 0)
			{
				System.out.println(x);
			}
			else if ( x % 3 == 0 && x % 5 != 0)
			{
				System.out.println("Fizz");
			}
			else if ( x % 3 != 0 && x % 5 == 0)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println("Fizzbuzz");
			}
		}
	}
}