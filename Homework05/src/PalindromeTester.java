import static org.junit.Assert.*;

import org.junit.Test;

/**
 * PalindromeTester.java : A Tester program to test out the Palindrome class with fixed input
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class PalindromeTester
{
	private Palindrome checker = new Palindrome();
	
	/**
	 * Checks false case scenarios
	 */
	@Test
	public void testFalse()
	{
		assertFalse(checker.isPal("ab"));
		assertFalse(checker.isPal("acb"));
		assertFalse(checker.isPal("aaaaaaaab"));
		assertFalse(checker.isPal("A dog! A panic in a pagodaa!"));//note the extra "a"
	}
	
	/**
	 * Checks true case scenarios
	 */
	@Test
	public void testTrue()
	{
		assertTrue(checker.isPal(""));
		assertTrue(checker.isPal("a"));
		assertTrue(checker.isPal("aa"));
		assertTrue(checker.isPal("abccba"));
		assertTrue(checker.isPal("abcdcba"));
		assertTrue(checker.isPal("A dog! A panic in a pagoda!"));//note the proper balance
		assertTrue(checker.isPal("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!"));
		assertTrue(checker.isPal("Madame, not one man is selfless; I name not one, madam."));
	}
}