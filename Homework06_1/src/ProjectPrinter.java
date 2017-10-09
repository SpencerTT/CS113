import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * ProjectPrinter.java : A class that can demonstrate how 100 print jobs
 * 		can be added to between 1-3 printers and their progress shown through output.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class ProjectPrinter
{
	/**
	 * Driver for ProjectPrinter
	 * 
	 * Algorithm:
	 * 1. Create the ArrayList of printers
	 * 2. Create a Scanner and get user input for how many printers there are
	 * 3. Set up between 1-3 printers based on user input with maxPages set to predetermined values
	 * 4. Set time = 0 and enter the while loop that finishes when all the printers have no more jobs
	 * 5. Progress all the printers, printing job completion messages as they occur
	 * 6. If time < 100, create a new job with a random number of pages between 1-50, and then attempt to give the Job to
	 * 		one of the printers (smallest printers on the left, largest on the right) (51+ do not get added (or occur))
	 * @param args command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		ArrayList<Printer> printers = new ArrayList<Printer>();
		Scanner user = new Scanner(System.in);
		System.out.print("How many printers are there? (1-3): ");
		int printNum = user.nextInt();
		user.close();
		
		if (printNum == 1)
		{
			printers.add(new Printer ("P1", 50));
		}
		else if (printNum == 2)
		{
			printers.add(new Printer ("P1", 10));
			printers.add(new Printer ("P2", 50));
		}
		else
		{
			printers.add(new Printer ("P1", 10));
			printers.add(new Printer ("P2", 20));
			printers.add(new Printer ("P3", 50));
		}
		
		int time = 0;
		while (!done(printers) || time == 0)
		{
			//Progress the printers
			for (Printer aPrinter : printers)
			{
				String temp = aPrinter.progress(time);
				if (temp != null)
				{
					System.out.println(temp);
				}
			}
			//Add a Job
			if(time < 100)
			{
				Random rand = new Random();
				Job aJob = new Job(("J" + time), (Math.abs((rand.nextInt() % 50)) + 1));
				
				boolean added = false;
				for (Printer aPrinter : printers)
				{
					if (!added && aPrinter.getMaxPages() >= aJob.getPages())
					{
						aPrinter.add(aJob);
						added = true;
						System.out.println(time + ": " + aJob.getPages() + " Page Job " +
								aJob.getName() + " added to " + aPrinter.getName());
					}
				}
			}
			time++;
		}
	}
	
	/**
	 * An easy way to determine if all the printers have no more jobs
	 * 
	 * @param printers All of the printers
	 * @return False if there are still jobs, true if not
	 */
	public static boolean done(ArrayList<Printer> printers)
	{
		for (Printer aPrinter : printers)
		{
			if (!aPrinter.isEmpty())
			{
				return false;
			}
		}
		return true;
	}
}