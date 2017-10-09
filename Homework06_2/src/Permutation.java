import java.util.ArrayList;

/**
 * Permutation.java : A class to hold the data of a permutation of change
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class Permutation
{
	private static String[] names = {"Quarters", "Dimes", "Nickels", "Pennies"};
	
	private ArrayList<Integer> change;
	
	/**
	 * 0-arg constructor that makes an ArrayList of Integers of 4 0's to represent a fresh permutation 
	 */
	public Permutation()
	{
		change = new ArrayList<Integer>();
		for (int x = 0; x < 4; x++)
		{
			change.add(0);
		}
	}
	
	/**
	 * Increments the value in change at index index by 1
	 * 
	 * @param index The index to be incremented
	 */
	public void add(int index)
	{
		change.set(index, change.get(index)+1);
	}
	
	/**
	 * Sets the value of change at index index to value value
	 * 
	 * @param index The index at which to replace the value
	 * @param value The value to replace at the given index
	 */
	public void setChange(int index, int value)
	{
		change.set(index, value);
	}
	
	/**
	 * Gets the value of change at index index
	 * 
	 * @param index The index to retrieve the value from
	 * @return The value of change at index index
	 */
	public int getChange(int index)
	{
		return change.get(index);
	}
	
	/**
	 * The string representation of a Permutation
	 * 
	 * @return The string representation of a Permutation (Qs, Ds, Ns, Ps)
	 */
	public String toString()
	{
		String aString = "";
		for (int x = 0; x < 4; x++)
		{
			aString += change.get(x) + " " + names[x] + " ";
		}
		return aString;
	}
	
	/**
	 * Makes a clone of the data of this Permutation and returns it
	 * 
	 * @return A clone of the data of this Permutation
	 */
	public Permutation clone()
	{
		Permutation aClone = new Permutation();
		for (int x = 0; x < 4; x++)
		{
			aClone.setChange(x, change.get(x));
		}
		return aClone;
	}
}