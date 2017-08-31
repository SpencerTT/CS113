/**
 * Lab2.java : Checks user input to determine if it is a power of 2
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
import java.util.Scanner;
public class Lab2
{
	/**
	 * Driver for Lab2
	 * 
	 * Algorithm:
	 * 1. Declare necessary variables
	 * 2. Get user input to test
	 * 3. Enter a while loop that runs while number > 1
	 * 4. In the while loop, divide the number by 2
	 * 5. If the number is equal to 1, the number is a multiple of 2,
	 * 		if not it is not.  Display results.
	 * 
	 * @param args
	 *            command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		double number;
		
		System.out.print("Enter a number to see if it is a power of 2: ");
		number = keyboard.nextDouble();
		keyboard.close();
		while (number > 1) 
		{
			number = number / 2;
		}
		if (number == 1)
		{
			System.out.println("YAY! It's a power of 2!");
		}
		else
		{
			System.out.println("Sorry, it's not a power of 2.");
		}
	}
}