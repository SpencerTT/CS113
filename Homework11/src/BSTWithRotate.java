@SuppressWarnings("serial")
public class BSTWithRotate<E extends Comparable<E>> extends BST<E>
{
	protected void rotateLeft(Node<E> parent)
	{
		Node<E> temp = parent.right;
		parent.right = temp.left;
		temp.left = parent;
		parent = temp;
	}
	
	protected void rotateRight(Node<E> parent)
	{
		Node<E> temp = parent.left;
		parent.left = temp.right;
		temp.right = parent;
		parent = temp;
	}
}