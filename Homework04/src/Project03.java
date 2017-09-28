import java.util.ListIterator;
import java.util.Scanner;
/**
 * Project03.java : A Driver program to test out the ThompsonList class.
 * 					The ListIterator Methods are tested, then
 * 					the four major methods are tested by a user:
 * 						addBot, addTop, removeTop, remove
 * 
 * @author Spencer Thompson
 * @version 2.0
 *
 */
public class Project03
{
	/**
	 * Driver for Project03
	 * 
	 * Algorithm:
	 * 1. Create and populate a new ThompsonList tl
	 * 2. Test a variety of ListIterator methods
	 * 3. Create user Scanner and other helper variables
	 * 4. While end is false:
	 * 	a) Display updated list and list of commands
	 * 	b) Accept a command 1-5 to addTop, addBot, removeTop, removeName, or exit program
	 * 	c) Execute the specific choice chosen
	 * 5. When user chooses to end the program, end the loop, close the Scanner, and end the program
	 * @param args command line arguments (unused)
	 */
	public static void main(String[] args)
	{
		ThompsonList<String> tl = new ThompsonList<String>();
		tl.add("Albert");
		tl.add("Bobby");
		tl.add("Curtis");
		tl.addFront("Danny");
		tl.addFront("Ernist");
		
		System.out.println("The initial list:");
		System.out.println(tl.toString());
		
		//Begin ListIterator Tests
		
		ListIterator<String> it = tl.listIterator();
		//Walk-through forwards and backwards
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		while (it.hasPrevious())
		{
			System.out.println(it.previous());
		}
		//Remove from the middle
		System.out.println(it.next());
		System.out.println(it.next());
		it.remove();
		System.out.println(it.previous());
		System.out.println(tl.toString());
		//Remove from the head
		it.remove();
		System.out.println(it.next());
		System.out.println(tl.toString());
		//Remove from the tail
		while (it.hasNext())
		{
			it.next();
		}
		it.remove();
		System.out.println(it.previous());
		//Add to the list and show list
		it.add("Herp");
		System.out.println(tl.toString());
		//Add to the list a second time from same index and show list
		it.add("Derp");
		System.out.println(tl.toString());
		//Add to the list from the tail
		System.out.println(it.next());
		it.add("Khan");
		System.out.println(tl.toString());
		//Add to the list from head
		System.out.println(it.previous());
		while (it.hasPrevious())
		{
			it.previous();
		}
		it.add("Pikachu");
		System.out.println(tl.toString());
		
		//End ListIterator Tests
		
		
		Scanner user = new Scanner(System.in);
		boolean end = false;
		int choice = 0;
		String name = "";
		
		while (end == false)
		{
			System.out.println("Course Waiting List: " + tl.toString());
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
						tl.add(name);
						break;
				case 2: System.out.print("Enter name to add to the top: ");
						name = user.nextLine();
						tl.addFront(name);
						break;
				case 3: tl.removeFront();
						break;
				case 4: System.out.print("Enter name to remove: ");
						name = user.nextLine();
						tl.remove(name);
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