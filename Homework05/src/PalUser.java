import java.util.Scanner;

/**
 * PalUser.java : A Driver program to test out the Palindrome class with user input
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class PalUser
{
	/**
	 * Driver for PalUser
	 * 
	 * Algorithm:
	 * 1. Create the Palindrome object
	 * 2. Create a Scanner and get user input for a Palindrome phrase
	 * 3. Check to see if it is a Palindrome and display the results
	 * @param args command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		Palindrome checker = new Palindrome();
		Scanner user = new Scanner(System.in);
		System.out.println("Enter a phrase to see if it's a palindrome!");
		String phrase = user.nextLine();
		System.out.println("Your phrase is a Palindrome?: " + checker.isPal(phrase));
		user.close();
	}
}