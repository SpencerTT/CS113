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
		tree.remove("dog");
		System.out.println(tree.toString());
		tree.remove("fox");
		System.out.println(tree.toString());
		tree.remove("The");
		System.out.println(tree.toString());
	}
}