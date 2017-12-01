/**
 * AVLTree.java : A tester class for the AVLTree class.  Both addition and deletion are tested.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class AVLTreeDriver
{
	/**
	 * Method used for all the addition and deletion testing.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		//I HAVE 3 EXAMPLES (only the first is required) SO BE SURE TO SCROLL UP TO SEE EVERYTHING!  THANKS!
		BST<Integer> bst = new BST<Integer>();
		AVLTree<Integer> avl = new AVLTree<Integer>();
		StringBuilder sb = new StringBuilder();
		int[] numbers = new int[20];
		
		for (int x = 0; x < 20; x++)
		{
			numbers[x] = (int) (Math.random() * 100);
			bst.add(numbers[x]);
			avl.add(numbers[x]);
			sb.append(numbers[x] + " ");
		}
		System.out.println("Binary Tree: \n" + bst.toString());
		System.out.println("AVLTree: \n" + avl.toString());
		System.out.println(sb.toString());
		
		//This addition example is covered in the Topic 15 slides and performs exactly as expected (I checked!)
		AVLTree<String> tree = new AVLTree<String>();
		String[] words = {"The", "quick", "brown", "fox", "jumps",
						  "over", "the", "lazy", "dog"};
		for (String word : words)
		{
			tree.add(word);
			System.out.println(tree.toString());
		}
		//ALL OF THIS IS DELETION STUFF (It works, but not part of assignment)
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