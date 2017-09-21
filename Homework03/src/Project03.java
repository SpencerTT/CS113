import java.util.Scanner;
/**
 * Project03.java : A Driver program to test out the CourseList class.
 * 					All four major methods are tested by a user:
 * 						addBot, addTop, removeTop, removeName
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class Project03
{
	/**
	 * Driver for Project03
	 * 
	 * Algorithm:
	 * 1. Create and populate a new CourseList cl
	 * 2. Create user Scanner and other helper variables
	 * 3. While end is false:
	 * 	a) Display updated list and list of commands
	 * 	b) Accept a command 1-5 to addTop, addBot, removeTop, removeName, or exit program
	 * 	c) Execute the specific choice chosen
	 * 4. When user chooses to end the program, end the loop, close the Scanner, and end the program
	 * @param args command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		CourseList cl = new CourseList();
		cl.addBot("Albert");
		cl.addBot("Bobby");
		cl.addBot("Curtis");
		cl.addTop("Danny");
		cl.addTop("Ernist");
		
		Scanner user = new Scanner(System.in);
		boolean end = false;
		int choice = 0;
		String name = "";
		
		while (end == false)
		{
			System.out.println("Course Waiting List: " + cl.toString());
			System.out.println("1. Add name to the bottom of the list.");
			System.out.println("2. Add name to the top of the list.");
			System.out.println("3. Remove student at the top of the list.");
			System.out.println("4. Remove student by name.");
			System.out.println("5. Exit the program.");
			
			choice = user.nextInt();
			user.nextLine();  //Clear the line
			switch (choice)
			{
				case 1: System.out.print("Enter name to add to the bottom: ");
						name = user.nextLine();
						cl.addBot(name);
						break;
				case 2: System.out.print("Enter name to add to the top: ");
						name = user.nextLine();
						cl.addTop(name);
						break;
				case 3: cl.removeTop();
						break;
				case 4: System.out.print("Enter name to remove: ");
						name = user.nextLine();
						cl.removeName(name);
						break;
				case 5: end = true;
						break;
				default: System.out.println("Please select 1-5");
						break;
			}
		}
		user.close();
	}
}