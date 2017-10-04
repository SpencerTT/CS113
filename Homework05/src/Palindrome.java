/**
 * Palindrome.java : A class that can test to see if a string is a palindrome
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

public class Palindrome
{
	
	/**
	 * Checks to see if entered phrase is a palindrome
	 * 
	 * @param phrase The phrase to be checked
	 * @return True if it is a palindrome, false if not.
	 */
	public boolean isPal(String phrase)
	{
		//Create the two ArrayStacks
		ArrayStack<Character> stack1 = new ArrayStack<Character>();
		ArrayStack<Character> stack2 = new ArrayStack<Character>();
		
		//Make sure the data is pure
		phrase = phrase.replaceAll("[^a-zA-Z]", "");
		phrase = phrase.toLowerCase();
		
		//Create letters array for pushing
		char[] letters = phrase.toCharArray();
		int half = letters.length / 2;
		
		//Push everything to the first stack
		for (int x = 0; x < letters.length; x++)
		{
			stack1.push(letters[x]);
		}
		
		//Pop and push half the first stack's pops to the second stack
		for (int x = 0; x < half; x++)
		{
			stack2.push(stack1.pop());
		}
		
		//If the phrase was of odd length, pop one more from the first stack to even it out
		if (letters.length % 2 == 1)
		{
			stack1.pop();
		}
		
		//Give a visual of the two stacks and return
		System.out.println(phrase);
		System.out.println(stack1.toString());
		System.out.println(stack2.toString());
		return (stack1.equals(stack2));
	}
}