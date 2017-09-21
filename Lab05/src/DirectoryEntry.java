/**
 * Project2_2.java : This class contains information relevant to a DirectoryEntry,
 * 		an object with a name field and a number field.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class DirectoryEntry
{
	private String name;
	private String number;
	
	/**
	 * 2-arg constructor to make a new DirectoryEntry
	 * @param name The DirectoryEntry's name
	 * @param number The DirectoryEntry's number
	 */
	public DirectoryEntry(String name, String number)
	{
		this.name = name;
		this.number = number;
	}
	
	/**
	 * Setter for name
	 * @param name The name for the DirectoryEntry
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Setter for number
	 * @param number The number for the DirectoryEntry
	 */
	public void setNumber(String number)
	{
		this.number = number;
	}
	
	/**
	 * Getter for name
	 * @return name The name of the DirectoryEntry
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Getter for number
	 * @return number The number of the DirectoryEntry
	 */
	public String getNumber()
	{
		return number;
	}
	
	/**
	 * String representation of the DirectoryEntry object
	 * @return name and number separated by a colon and spaces
	 */
	public String toString()
	{
		return name + " : " + number;
	}
	/**
	 * Method for determining if two DirectoryEntry objects are equal
	 * @param other The other DirectoryEntry to check against
	 * @return true if they have the same name and number, else false
	 */
	public boolean equals(DirectoryEntry other)
	{
		return (name == other.getName() && number == other.getNumber());
	}
}