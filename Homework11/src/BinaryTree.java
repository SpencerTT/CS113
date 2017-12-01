import java.io.Serializable;
import java.util.Scanner;

/**
 * BinaryTree.java : A class that has a root Node that can be used to create a binary tree of Nodes
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class BinaryTree<E> implements Serializable
{
	protected Node<E> root;
	
	/**
	 * 0-arg constructor for a new BinaryTree with a null root
	 */
	public BinaryTree()
	{
		root = null;
	}
	
	/**
	 * 1-arg constructor for a new BinaryTree with root "root"
	 * 
	 * @param root The Node that will become the root.
	 */
	protected BinaryTree(Node<E> root)
	{
		this.root = root;
	}
	
	/**
	 * 3-arg constructor for a new BinaryTree with root data "data", and left/right trees leftTree & rightTree
	 * 
	 * @param data The data to be stored in the root Node
	 * @param leftTree The left tree of the root Node
	 * @param rightTree The right tree of the root Node
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		root = new Node<E>(data);
		if (leftTree != null)
		{
			root.left = leftTree.root;
		}
		else
		{
			root.left = null;
		}
		if (rightTree != null)
		{
			root.right = rightTree.root;
		}
		else
		{
			root.right = null;
		}
	}
	
	/**
	 * A way to return the left sub-tree of the root
	 * 
	 * @return A BinaryTree that is the left sub-tree of the root
	 */
	public BinaryTree<E> getLeftSubtree()
	{
		if (root != null && root.left != null)
		{
			return new BinaryTree<E>(root.left);
		}
		else
		{
			return null;
		}
	}
	/**
	 * A way to return the right sub-tree of the root
	 * 
	 * @return A BinaryTree that is the right sub-tree of the root
	 */
	public BinaryTree<E> getRightSubtree()
	{
		if (root != null && root.right != null)
		{
			return new BinaryTree<E>(root.right);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Getter method for the root's variable "data"
	 * 
	 * @return The data of the root
	 */
	public E getData()
	{
		return root.data;
	}
	
	/**
	 * Method for determining if the root node is a leaf
	 * @return True is the left and right subtree's are both null, else false
	 */
	public boolean isLeaf()
	{
		return (root.left == null && root.right == null);
	}
	
	/**
	 * The string representation of a BinaryTree
	 * (Uses a helper method preOrderTraverse())
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		int height = preOrderTraverse(root, 1, sb);
		return sb.toString() + "Height: " + height + "\n";
	}
	
	/**
	 * Creates a preorder traversal of Node "node" and stores that representation in StringBuilder "sb"
	 * 
	 * @param node The node to start the traversal
	 * @param depth The current depth of the traversal
	 * @param sb The StringBuilder that will be used to store this string representation this traversal
	 * @return The height of the tree
	 */
	private int preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
	{
		for (int i = 1; i < depth; i++)
		{
			sb.append("|");
		}
		if (node == null)
		{
			sb.append("null\n");
			return depth;
		}
		else
		{
			sb.append(node.toString() + "\n");
			int a = preOrderTraverse(node.left, depth + 1, sb);
			int b = preOrderTraverse(node.right, depth + 1, sb);
			return (a > b) ? a : b;
		}
	}
	/**
	 * Creates a BinaryTree by recursively using the scanner "scan" to get the next input
	 * 
	 * @param scan the scanner that gets the data for the current node
	 * @return A BinaryTree comprised of all the data collected from the Scanner "scan"
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan) {
		String data = scan.nextLine().trim();
		if (data.equals("null"))
		{
			return null;
		}
		else
		{
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
	/**
	 * Inner class Node : A class that stores the basic info for a binary tree node
	 * 
	 * @author Spencer Thompson
	 * @version 1.0
	 *
	 */
	protected static class Node<E> implements Serializable
	{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		/**
		 * 1-arg constructor to make a new node
		 * 
		 * @param data The data to be stored in the node
		 */
		public Node (E data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
		/**
		 * The string representation of a Node
		 * 
		 * @return The string representation of a Node
		 */
		public String toString()
		{
			return this.data.toString();
		}
	}
}