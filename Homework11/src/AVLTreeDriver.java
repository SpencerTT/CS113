public class AVLTreeDriver
{
	public static void main(String[] args)
	{
		AVLTree<String> tree = new AVLTree<String>();
		String[] words = {"The", "quick", "brown", "fox", "jumps",
						  "over", "the", "lazy", "dog"};
		for (String word : words)
		{
			tree.add(word);
			System.out.println(tree.toString());
		}
		
		/*
		AVLTree<Integer> iTree = new AVLTree<Integer>();
		iTree.add(1);
		iTree.add(3);
		iTree.add(2);
		System.out.println(iTree.toString());
		iTree.add(0);
		iTree.add(-1);
		System.out.println(iTree.toString());
		*/
	}
}