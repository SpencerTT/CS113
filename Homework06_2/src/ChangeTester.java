import static org.junit.Assert.*;

import org.junit.Test;

public class ChangeTester
{
	/**
	 * Tests 7 common cases (0, 1, 5 ,10, 25, 75, 100)
	 * Confirms that the method returns the same value as the known answer
	 * Also shows permutations in an orderly fashion and total permutations
	 */
	@Test
	public void test()
	{
		ProjectChange pc = new ProjectChange();
		int value = 0;
		
		value = pc.changePerms(0);
		System.out.println(value);
		assertTrue(value == 1);
		
		value = pc.changePerms(1);
		System.out.println(value);
		assertTrue(value == 1);
		
		value = pc.changePerms(5);
		System.out.println(value);
		assertTrue(value == 2);
		
		value = pc.changePerms(10);
		System.out.println(value);
		assertTrue(value == 4);
		
		value = pc.changePerms(25);
		System.out.println(value);
		assertTrue(value == 13);
		
		value = pc.changePerms(75);
		System.out.println(value);
		assertTrue(value == 121);
		
		value = pc.changePerms(100);
		System.out.println(value);
		assertTrue(value == 242);
	}
}
