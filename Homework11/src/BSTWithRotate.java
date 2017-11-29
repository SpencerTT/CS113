/**
 * BSTWithRotate.java : A class that extends BST that allows for node rotation
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class BSTWithRotate<E extends Comparable<E>> extends BST<E>
{
	/**
	 * Rotates a node left
	 * 
	 * @param parent the node on which rotation is occurring
	 * @return the new node that will take the place of parent in the tree
	 */
	protected Node<E> rotateLeft(Node<E> parent)
	{
		System.out.println("Rotated left on " + parent.data);
		Node<E> temp = parent.right;
		parent.right = temp.left;
		temp.left = parent;
		return temp;
	}
	
	/**
	 * Rotates a node right
	 * 
	 * @param parent the node on which rotation is occurring
	 * @return the new node that will take the place of parent in the tree
	 */
	protected Node<E> rotateRight(Node<E> parent)
	{
		System.out.println("Rotated right on " + parent.data);
		Node<E> temp = parent.left;
		parent.left = temp.right;
		temp.right = parent;
		return temp;
	}
}