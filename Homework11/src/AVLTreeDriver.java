/**
 * AVLTree.java : A tester class for the AVLTree class.  Both addition and deletion are tested
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class AVLTreeDriver
{
	/**
	 * Method used for all the addition and deletion testing
	 * 
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		//This addition example is covered in the Topic 15 slides and performs exactly as expected (I checked!)
		AVLTree<String> tree = new AVLTree<String>();
		String[] words = {"The", "quick", "brown", "fox", "jumps",
						  "over", "the", "lazy", "dog"};
		for (String word : words)
		{
			tree.add(word);
			System.out.println(tree.toString());
		}
		
		//Not able to be removed
		tree.remove("dogs");
		System.out.println(tree.toString());
		//Able to be removed
		tree.remove("dog");
		System.out.println(tree.toString());
		tree.remove("fox");
		System.out.println(tree.toString());
		//Should cause a rebalance-right with a rotate-right on quick and rotate-left on jumps
		tree.remove("The");
		System.out.println(tree.toString());
	}
}