@SuppressWarnings("serial")
public class BST<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>
{
	protected boolean addReturn;
	protected E deleteReturn;
	

	@Override
	public boolean add(E object)
	{
		root = add(root, object);
		return addReturn;
	}
	
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

	@Override
	public boolean contains(E object)
	{
		return find(object) != null;
	}

	@Override
	public E find(E object)
	{
		return find(root, object);
	}
	
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
	

	@Override
	public E delete(E object)
	{
		root = delete(root, object);
		return deleteReturn;
	}
	
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
	
	private E findLargestChild(Node<E> current)
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

	@Override
	public boolean remove(E object)
	{
		return (delete(object) != null);
	}
}