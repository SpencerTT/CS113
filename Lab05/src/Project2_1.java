import java.util.ArrayList;

/**
 * Project2_1.java : A driver program to test out printing a list,
 * 		replacing a list member, and removing a list member
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

public class Project2_1
{
	/**
	 * Driver for Project2_1
	 * 
	 * Algorithm:
	 * 1. Create the ArrayList of Strings theList and populate it.
	 * 2. Print the starting list
	 * 3. Print out the list after replacing Cal with Con
	 * 4. Print out the list after deleting Con
	 */
	public static void main(String[] args)
	{
		ArrayList<String> theList = new ArrayList<String>();
		theList.add("Amy");
		theList.add("Bob");
		theList.add("Cal");
		theList.add("Dan");
		theList.add("Eve");
		
		System.out.println("List at start:");
		print(theList);
		System.out.println("List after replacing Cal with Con:");
		replace(theList, "Cal", "Con");
		print(theList);
		System.out.println("List after deleting Con:");
		delete(theList, "Con");
		print(theList);
		
	}
	/**
	 * Prints the given ArrayList
	 * @param aList The list that will be printed
	 */
	public static void print(ArrayList<String> aList)
	{
		for (String s : aList)
		{
			System.out.print(s + " => ");
		}
		System.out.print("\n");
	}
	
	/**
	 * Replaces the oldItem with the newItem in aList
	 * @param aList The list that will searched to replace
	 * @param oldItem The item to search for in aList
	 * @param newItem The item to replace oldItem with after finding oldItem
	 */
	public static void replace(ArrayList<String> aList, String oldItem, String newItem)
	{
		int pos = 0;
		boolean found = false;
		while (pos < aList.size() && found == false)
		{
			if (aList.get(pos).equals(oldItem))
			{
				aList.set(pos, newItem);
				found = true;
			}
			pos++;
		}
	}
	
	/**
	 * Removes a target item from the list
	 * @param aList The list that will searched for removal
	 * @param target The item to search for to remove in aList
	 */
	public static void delete(ArrayList<String> aList, String target)
	{
		int pos = 0;
		boolean found = false;
		while (pos < aList.size() && found == false)
		{
			if (aList.get(pos).equals(target))
			{
				aList.remove(pos);
				found = true;
			}
			pos++;
		}
	}
}