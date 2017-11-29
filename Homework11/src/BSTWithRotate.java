@SuppressWarnings("serial")
public class BSTWithRotate<E extends Comparable<E>> extends BST<E>
{
	protected Node<E> rotateLeft(Node<E> parent)
	{
		System.out.println("Rotated left on " + parent.data);
		Node<E> temp = parent.right;
		parent.right = temp.left;
		temp.left = parent;
		return temp;
	}
	
	protected Node<E> rotateRight(Node<E> parent)
	{
		System.out.println("Rotated right on " + parent.data);
		Node<E> temp = parent.left;
		parent.left = temp.right;
		temp.right = parent;
		return temp;
	}
}