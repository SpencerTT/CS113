import java.util.ArrayList;

/**
 * ProjectChange.java : A class that recursively determines how many combinations
 * 		of change could be offered to the user for a given amount.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class ProjectChange
{
	public static int[] coins = {25, 10, 5, 1};
	public static ArrayList<Permutation> all = new ArrayList<Permutation>();
	
	/**
	 * 1-arg changePerms that calls the 3-arg changePerms, (user should only give cents)
	 * prints out all the permutations, and then empties the ArrayList all for future use.
	 * 
	 * @param cents The amount of cents to find all the possible permutations for.
	 * @return The number of permutations found for value cents
	 */
	public int changePerms(int cents)
	{
		int total = changePerms(cents, 0, new Permutation());
		for (Permutation p : all)
		{
			System.out.println(p);
		}
		all = new ArrayList<Permutation>();
		return total;
	}
	
	/**
	 * 3-arg changePerms that steadily finds all possible permutations of the given change amount
	 * @param cents The total amount of remaining cents
	 * @param index The coin index currently being worked on
	 * @param current The current permutation (storing what coins have been used so far)
	 * @return 0 if cents < 0 or index == 4, 1 if cents == 0 (a Successful Permutation), or the sum of
	 * 		two additional recursive calls, 1 subtracting a coin at index (adding to the pCoin permutation)
	 * 		and 1 increasing the index using the current permutation
	 */
	public int changePerms(int cents, int index, Permutation current)
	{
		if (cents < 0 || index == 4)
		{
			return 0;
		}
		else if (cents == 0)
		{
			all.add(current);//For printing later
			return 1;
		}
		else
		{
			//Get a clone permutation ready and increment a coin value
			Permutation pCoin = current.clone();
			pCoin.add(index);
			//Get the result changePerms with taking away a coin from cents and using the pCoin permutation
			int subCoin = changePerms(cents - coins[index], index, pCoin);
			//Get the result of changePerms with increasing the index and using the current permutation
			int incIndex = changePerms(cents, index + 1, current);
			return subCoin + incIndex;
		}
	}
}