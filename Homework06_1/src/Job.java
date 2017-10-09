/**
 * Job.java : A class to hold the data of a printer job
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class Job
{
	private String name;
	private int pages;
	private int TTF; //Time To Finish
	
	/**
	 * 0-arg constructor that shouldn't be used, but sets variables to acceptable conditions
	 */
	public Job()
	{
		this.name = "";
		this.pages = 0;
		this.TTF = 0;
	}
	
	/**
	 * 2-arg constructor to set up a new job with a name, number of pages, and a calculated time-to-finish(TTF)
	 * 
	 * @param name The name of the job
	 * @param pages The number of pages for the job
	 */
	public Job(String name, int pages)
	{
		this.name = name;
		this.pages = pages;
		this.TTF = (int) Math.ceil((float) pages / 10);
	}

	/**
	 * Gets the name of the Job
	 * 
	 * @return The name of the job
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the number of pages of the job
	 * 
	 * @return The number of pages of the job
	 */
	public int getPages()
	{
		return pages;
	}

	/**
	 * Gets the Time-To-Finish (TTF) of the job
	 * 
	 * @return the Time-To-Finish (TTF) of the job
	 */
	public int getTTF()
	{
		return TTF;
	}
	
	//The 3 setters are never used (and SHOULDN'T be used) and present only for cosmetics

	/**
	 * Sets the name to the new value for name
	 * 
	 * @param name The new value for name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Sets the pages to the new value for pages
	 * 
	 * @param pages The new value for pages
	 */
	public void setPages(int pages)
	{
		this.pages = pages;
	}

	/**
	 * Sets the Time-To-Finish (TTF) to the new value for TTF
	 * 
	 * @param TTF The new value for TTF
	 */
	public void setTTF(int TTF)
	{
		this.TTF = TTF;
	}
	
	/**
	 * Returns the string representation of this object
	 * 
	 * @return The string representation of this object (name : pages : TTF)
	 */
	public String toString()
	{
		return name + " : " + pages + " : " + TTF;
	}
	
	/**
	 * Decrements the job's TTF and then returns that value
	 * 
	 * @return A decremented value of TTF
	 */
	public int progress()
	{
		return --TTF;
	}
}