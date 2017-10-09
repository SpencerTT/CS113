import java.util.LinkedList;
/**
 * Printer.java : A class to hold the data of a printer
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class Printer
{
	private LinkedList<Job> queue;
	private String name;
	private int maxPages;
	
	/**
	 * 0-arg constructor that shouldn't be used, but sets variables to acceptable conditions
	 */
	public Printer()
	{
		this.queue = new LinkedList<Job>();
		this.name = "Printer";
		this.maxPages = 0;
	}
	
	/**
	 * 2-arg constructor that sets up the printer's name and how the max pages per job
	 * 
	 * @param name The name of the printer
	 * @param maxPages The max number of pages per job
	 */
	public Printer(String name, int maxPages)
	{
		this.queue = new LinkedList<Job>();
		this.name = name;
		this.maxPages = maxPages;
	}
	
	//queue does not have a getter/setter by design

	/**
	 * Gets the name of the Printer
	 * 
	 * @return The name of the Printer
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the maximum number of pages per job
	 * 
	 * @return The maximum number of pages per job
	 */
	public int getMaxPages()
	{
		return maxPages;
	}

	//The 2 setters are never used (and SHOULDN'T be used) and present only for cosmetics
	
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
	 * Sets the maximum number of pages per job
	 * 
	 * @param name The new value for the maximum number of pages per job
	 */
	public void setMaxPages(int maxPages)
	{
		this.maxPages = maxPages;
	}
	
	/**
	 * Offers Job aJob to queue
	 * 
	 * @param aJob A Job to add to queue
	 */
	public void add(Job aJob)
	{
		queue.offer(aJob);
	}
	
	/**
	 * An easy way to determine if queue is empty
	 * 
	 * @return True if queue is empty, false if not
	 */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	/**
	 * Progresses a minute in time for this Printer, checking to see if the job progress returns 0
	 * If it does, return a job completion message and remove the job from the queue, else return null
	 * 
	 * @param time The time at which this progression is taking place
	 * @return A job completion message if the job is finished, otherwise null
	 */
	public String progress(int time)
	{
		if (!queue.isEmpty())
		{
			if (queue.peek().progress() == 0)
			{
				return (time + ": " + name + " finished job " + queue.poll().getName());
			}
		}
		return null;
	}
}