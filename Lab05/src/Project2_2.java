import java.util.ArrayList;

/**
 * Project2_2.java : A driver program to test out printing a list,
 * 		changing or adding a list member, and removing a list member
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

public class Project2_2
{
	static ArrayList<DirectoryEntry> theDirectory = new ArrayList<DirectoryEntry>();
	/**
	 * Driver for Project2_2
	 * 
	 * Algorithm:
	 * 1. Create an ArrayList of DirectoryEntry objects
	 * 2. Print the starting directory
	 * 3. Print the directory after changing Brian's number
	 * 4. Print the directory after adding Chris Swisher
	 * 5. Print the directory after removing Brian
	 */
	public static void main(String[] args)
	{
		//ArrayList<DirectoryEntry> theDirectory = new ArrayList<DirectoryEntry>();
		theDirectory.add(new DirectoryEntry("Billy Bob", "000-000-0000"));
		theDirectory.add(new DirectoryEntry("Jimmy Fan", "000-000-0001"));
		theDirectory.add(new DirectoryEntry("Brian Lane", "000-000-0002"));
		theDirectory.add(new DirectoryEntry("Jon Lane", "000-000-0003"));
		System.out.println("The starting directory:");
		printTheDirectory();
		System.out.println("Directory after changing Brian's number:");
		addOrChangeEntry("Brian Lane", "012-345-6789");
		printTheDirectory();
		System.out.println("Directory after adding Chris Swisher:");
		addOrChangeEntry("Chris Swisher", "111-111-1111");
		printTheDirectory();
		System.out.println("Directory after removing Brian:");
		removeEntry("Brian Lane");
		printTheDirectory();
		
	}
	/**
	 * Prints theDirectory in a String representation
	 */
	public static void printTheDirectory()
	{
		for (DirectoryEntry dE : theDirectory)
		{
			System.out.println(dE);
		}
	}
	
	/**
	 * This method adds or changes a DirectoryEntry, depending on if aName exists in theDirectory
	 * @param aName The name that will be added or changed
	 * @param newNumber The number that will be added or changed
	 * @return The old number or null if new contact
	 */
	public static String addOrChangeEntry(String aName, String newNumber)
	{
		for (DirectoryEntry dE : theDirectory)
		{
			if (dE.getName().equals(aName))
			{
				String old = dE.getNumber();
				dE.setNumber(newNumber);
				return old;
			}
		}
		theDirectory.add(new DirectoryEntry(aName, newNumber));
		return null;
	}
	
	/**
	 * Method for Removing a DirectoryEntry from theDirectory based on aName 
	 * @param aName The name that will be searched for and removed if found
	 * @return The DirectoryEntry that was removed, or null if not found 
	 */
	public static DirectoryEntry removeEntry(String aName)
	{
		for (DirectoryEntry dE : theDirectory)
		{
			if (dE.getName().equals(aName))
			{
				return theDirectory.remove(theDirectory.indexOf(dE));
			}
		}
		return null;
	}
}