/**
 * BST.java : A class that extends BinaryTree and implements SearchTree
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class BST<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>
{
	protected boolean addReturn;
	protected E deleteReturn;
	

	/**
	 * Tries to add object to the tree
	 * 
	 * @param object the item to add to the tree
	 * @return true if added, false if not
	 */
	@Override
	public boolean add(E object)
	{
		root = add(root, object);
		return addReturn;
	}
	
	/**
	 * Recursive add method that uses a current root and the object to add
	 * 
	 * @param current the current root in the recursive call
	 * @param object the item that it is trying to add
	 * @return the new node (base case) or current
	 */
	private Node<E> add(Node<E> current, E object)
	{
		if (current == null)
		{
			addReturn = true;
			return new Node<E>(object);
		}
		else if (object.compareTo(current.data) == 0)
		{
			addReturn = false;
			return current;
		}
		else if (object.compareTo(current.data) < 0)
		{
			current.left = add(current.left, object);
			return current;
		}
		else
		{
			current.right = add(current.right, object);
			return current;
		}
	}
	/**
	 * Determines if object is in the tree
	 * 
	 * @param object the item to check for
	 * @return true if find(object) != null
	 */
	@Override
	public boolean contains(E object)
	{
		return find(object) != null;
	}

	/**
	 * Finds the object in the tree and returns it if found, null if not
	 * 
	 * @param object the item to search for in the tree
	 * @return object if found, null if not found
	 */
	@Override
	public E find(E object)
	{
		return find(root, object);
	}
	/**
	 * Recursive find method that uses a current root and the object to find
	 * 
	 * @param current the current root in the recursive call
	 * @param object the item that it is trying to find
	 * @return null (not found base case) or current.data (found base case)
	 */
	private E find(Node<E> current, E object)
	{
		if (current == null)
		{
			return null;
		}
		
		int comp = object.compareTo(current.data);
		if (comp == 0)
		{
			return current.data;
		}
		else if (comp < 0)
		{
			return find(current.left, object);
		}
		else
		{
			return find(current.right, object);
		}
	}
	
	/**
	 * Tries to delete object from the tree
	 * 
	 * @param object the item to delete
	 * @return object if found, null if not found
	 */
	@Override
	public E delete(E object)
	{
		root = delete(root, object);
		return deleteReturn;
	}
	/**
	 * Recursive delete method that uses a current root and the object to delete
	 * 
	 * @param current the current root in the recursive call
	 * @param object the item that it is trying to delete
	 * @return current (with some work potentially done to descendants of current)
	 */
	private Node<E> delete(Node<E> current, E object)
	{
		if (current == null)
		{
			deleteReturn = null;
			return current;
		}
		
		int comp = object.compareTo(current.data);
		if (comp < 0)
		{
			current.left = delete(current.left, object);
			return current;
		}
		else if (comp > 0)
		{
			current.right = delete(current.right, object);
			return current;
		}
		else
		{
			deleteReturn = current.data;
			if (current.left == null)
			{
				return current.right;
			}
			else if (current.right == null)
			{
				return current.left;
			}
			else
			{
				if (current.left.right == null)
				{
					current.data = current.left.data;
					current.left = current.left.left;
					return current;
				}
				else
				{
					current.data = findLargestChild(current.left);
					return current;
				}
			}
		}
	}
	
	/**
	 * Finds the largest child of a given node current
	 * 
	 * @param current the node we want to find the largest child of
	 * @return the node current's largest child
	 */
	protected E findLargestChild(Node<E> current)
	{
		if (current.right.right == null)
		{
			E returnValue = current.right.data;
			current.right = current.right.left;
			return returnValue;
		}
		else
		{
			return findLargestChild(current.right);
		}
	}
	/**
	 * Returns delete(object) != null
	 * 
	 * @param object the item to remove
	 * @return delete(object) != null
	 */
	@Override
	public boolean remove(E object)
	{
		return (delete(object) != null);
	}
}