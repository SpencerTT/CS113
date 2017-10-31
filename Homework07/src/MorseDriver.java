import java.util.Scanner;
/**
 * MorseCodeDriver.java : A driver program to test out the key functions of the MorseCodeTree class
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class MorseDriver
{
	public static void main(String[] args)
	{
		//Create the MorseCodeTree
		MorseCodeTree mTree = MorseCodeTree.readMorseTree();
		Scanner in = new Scanner(System.in);
		boolean end = false;
		while(!end)
		{
			System.out.println("Morse Code Menu");
			System.out.println("1. Output the code --> letter table");
			System.out.println("2. Translate Morse Code from a file");
			System.out.println("3. Enter Morse Code via the console");
			System.out.println("4. End the program");
			StringBuilder sb = new StringBuilder();
			int choice = in.nextInt();
			in.nextLine(); //Clear the buffer
			if (choice == 1)
			{
				mTree.traverseTable(sb);
				System.out.println(sb.toString());
			}
			else if (choice == 2)
			{
				mTree.translateFile(sb, in);
				System.out.println(sb.toString());
			}
			else if (choice == 3)
			{
				mTree.translateConsole(sb, in);
				System.out.println(sb.toString());
			}
			else
			{
				end = true;
			}
		}
		in.close();
	}
}