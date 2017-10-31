import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * MorseCodeTree.java : A class that extends BinaryTree<String> since all morse code deals with Strings
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class MorseCodeTree extends BinaryTree<String>
{
	/**
	 * 1-arg constructor for a new MorseCodeTree with a root "node"
	 * 
	 * @param node The node to set as the root for the new MorseCodeTree
	 */
	public MorseCodeTree(Node<String> node)
	{
		root = node;
	}
	
	/**
	 * A method that returns a MorseCodeTree with all nodes properly placed
	 * 
	 * @return A correct implementation of a MorseCodeTree (* means left, - means right)
	 */
	public static MorseCodeTree readMorseTree()
	{
		Scanner scan = null;
		try
		{
			scan = new Scanner(new File("MorseCode.txt"));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		Node<String> theRoot = new Node<String>("");
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			String data = line.substring(0, 1);
			String path = line.substring(1);
			Node<String> temp = theRoot;
			for (int x = 0; x < path.length()-1; x++)
			{
				if (path.charAt(x) == '*')
				{
					temp = temp.left;
				}
				else
				{
					temp = temp.right;
				}
			}
			if (path.charAt(path.length()-1) == '*')
			{
				temp.left = new Node<String>(data);
			}
			else
			{
				temp.right = new Node<String>(data);
			}
		}
		scan.close();
		return new MorseCodeTree(theRoot);
	}
	
	/**
	 * The first call to the traverseTable method (user doesn't need to know where to start, or what is path)
	 * 
	 * @param sb The StringBuilder that the String representation will be built with
	 */
	public void traverseTable(StringBuilder sb)
	{
		traverseTable(sb, root, "");
	}
	
	/**
	 * The recursive call to the TraverseTable method (to show each code and it's corresponding letter)
	 * @param sb The StringBuilder that the String representation will be built with
	 * @param root The Node that the method is currently working on
	 * @param path The Morse Code path that represents the current Node's code
	 */
	public void traverseTable(StringBuilder sb, Node<String> root, String path)
	{
		if (root != null)
		{
			sb.append(String.format("%-4s %s\n", path, root.data));
			traverseTable(sb, root.left, (path + "*"));
			traverseTable(sb, root.right, (path + "-"));
		}
	}
	
	/**
	 * Translates a single letter in morse code to it's corresponding alphabet letter
	 * @param code The morse code path (* = left, - = right) to a node on the MorseCodeTree
	 * @return The letter that corresponds to the given code
	 */
	public String translateLetter(String code)
	{
		Node<String> temp = root;
		for (int x = 0; x < code.length(); x++)
		{
			if (temp != null && code.charAt(x) == '*')
			{
				temp = temp.left;
			}
			else if (temp != null && code.charAt(x) == '-')
			{
				temp = temp.right;
			}
		}
		if (temp != null && temp.data != "")
		{
			return temp.data;
		}
		else
		{
			return "!";
		}
	}
	
	/**
	 * Translates user entered file from morse code to English
	 * 
	 * @param sb The StringBuilder that the translation gets written in
	 * @param in The Scanner to receive user input from
	 */
	public void translateFile(StringBuilder sb, Scanner in)
	{
		System.out.printf("Enter the file you wish to translate: ");
		String fileName = in.nextLine();
		Scanner scan = null;
		try
		{
			scan = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		while(scan.hasNext())
		{
			String code = scan.next();
			sb.append(translateLetter(code));
		}
		scan.close();
	}
	
	/**
	 * Translates user entered console input from morse code to English
	 * @param sb The StringBuilder that the translation gets written in
	 * @param in The Scanner to receive user input from
	 */
	public void translateConsole(StringBuilder sb, Scanner in)
	{
		System.out.println("Enter a line of morse code to translate:");
		String code = in.nextLine();
		String[] letters = code.split(" ");
		for(int x = 0; x < letters.length; x++)
		{
			sb.append(translateLetter(letters[x]));
		}
	}
}