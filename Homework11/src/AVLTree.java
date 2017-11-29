@SuppressWarnings("serial")
public class AVLTree<E extends Comparable<E>> extends BSTWithRotate<E>
{
	private boolean increase;
	private boolean decrease;
	
	@Override
	public boolean add(E object)
	{
		increase = false;
		root = add( (AVLNode<E>) root, object);
		return addReturn;
	}
	
	private AVLNode<E> add(AVLNode<E> current, E object)
	{
		if (current == null)
		{
			System.out.println("base case");
			addReturn = true;
			increase = true;
			return new AVLNode<E>(object);
		}
		else if (object.compareTo(current.data) == 0)
		{
			System.out.println("equals case");
			addReturn = false;
			increase = false;
			return current;
		}
		else if (object.compareTo(current.data) < 0)
		{
			System.out.println("< 0 case");
			current.left = add( (AVLNode<E>) current.left, object);
			
			if (increase)
			{
				decrementBalance(current);
				if (current.balance == AVLNode.BALANCED)
				{
					increase = false;
				}
				if (current.balance < AVLNode.LEFT_HEAVY)
				{
					increase = false;
					current = rebalanceLeft(current);
				}
			}
			return current;
		}
		else
		{
			System.out.println("> 0 case");
			current.right = add( (AVLNode<E>) current.right, object);
			
			if (increase)
			{
				incrementBalance(current);
				if (current.balance == AVLNode.BALANCED)
				{
					increase = false;
				}
				if (current.balance > AVLNode.RIGHT_HEAVY)
				{
					increase = false;
					current = rebalanceRight(current);
				}
			}
			return current;
		}
	}
	@Override
	public E delete(E object)
	{
		increase = false;
		root = delete( (AVLNode<E>) root, object);
		return deleteReturn;
	}
	public AVLNode<E> delete(AVLNode<E> current, E object)
	{
		if (current == null)
		{
			System.out.println("not found case");
			deleteReturn = null;
			decrease = false;
			return null;
		}
		else if (object.compareTo(current.data) < 0)
		{
			System.out.println("< 0 case");
			current.left = delete( (AVLNode<E>) current.left, object);
			
			if (decrease)
			{
				incrementBalance(current);
				if (current.balance != AVLNode.BALANCED)
				{
					decrease = false;
				}
				if (current.balance > AVLNode.RIGHT_HEAVY)
				{
					decrease = false;
					current = rebalanceRight(current);
				}
			}
			return current;
		}
		else if (object.compareTo(current.data) > 0)
		{
			System.out.println("> 0 case");
			current.right = delete( (AVLNode<E>) current.right, object);
			
			if (decrease)
			{
				decrementBalance(current);
				if (current.balance != AVLNode.BALANCED)
				{
					decrease = false;
				}
				if (current.balance < AVLNode.LEFT_HEAVY)
				{
					decrease = false;
					current = rebalanceLeft(current);
				}
			}
			return current;
		}
		else
		{
			System.out.println("found case");
			deleteReturn = current.data;
			decrease = true;
			if (current.left == null)
			{
				return (AVLNode<E>) current.right;
			}
			else if (current.right == null)
			{
				return (AVLNode<E>) current.left;
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
	
	private AVLNode<E> rebalanceLeft(AVLNode<E> current)
	{
		AVLNode<E> leftChild = (AVLNode<E>) current.left;
		
		if (leftChild.balance > AVLNode.BALANCED)
		{
			AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
			
			if (leftRightChild.balance < AVLNode.BALANCED)
			{
				leftChild.balance = AVLNode.BALANCED;
				leftRightChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.RIGHT_HEAVY;
			}
			else if (leftRightChild.balance > AVLNode.BALANCED)
			{
				leftChild.balance = AVLNode.LEFT_HEAVY;
				leftRightChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.BALANCED;
			}
			else
			{
				leftChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.BALANCED;
			}
			System.out.println("RebalanceLeft: RotateLeft:");
			current.left = rotateLeft(leftChild);
		}
		else
		{
			leftChild.balance = AVLNode.BALANCED;
			current.balance = AVLNode.BALANCED;
		}
		
		System.out.println("RebalanceLeft: RotateRight:");
		current = (AVLNode<E>) rotateRight(current);
		return current;
	}
	
	private AVLNode<E> rebalanceRight(AVLNode<E> current)
	{
		AVLNode<E> rightChild = (AVLNode<E>) current.right;
		
		if (rightChild.balance < AVLNode.BALANCED)
		{
			AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
			
			if (rightLeftChild.balance > AVLNode.BALANCED)
			{
				rightChild.balance = AVLNode.BALANCED;
				rightLeftChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.LEFT_HEAVY;
			}
			else if (rightLeftChild.balance < AVLNode.BALANCED)
			{
				rightChild.balance = AVLNode.RIGHT_HEAVY;
				rightLeftChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.BALANCED;
			}
			else
			{
				rightChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.BALANCED;
			}
			
			System.out.println("RebalanceRight: RotateRight:");
			current.right = rotateRight(rightChild);
		}
		else
		{
			rightChild.balance = AVLNode.BALANCED;
			current.balance = AVLNode.BALANCED;
		}
		
		System.out.println("RebalanceRight: RotateLeft:");
		current = (AVLNode<E>) rotateLeft(current);
		return current;
	}
	
	private void decrementBalance(AVLNode<E> node)
	{
		node.balance--;
		if (node.balance == AVLNode.BALANCED)
		{
			increase = false;
			//decrease = false;
		}
	}
	
	private void incrementBalance(AVLNode<E> node)
	{
		node.balance++;
		if (node.balance == AVLNode.BALANCED)
		{
			increase = false;
			//decrease = false;
		}
	}
	
	private static class AVLNode<E> extends Node<E>
	{
		public static final int LEFT_HEAVY = -1;
		public static final int BALANCED = 0;
		public static final int RIGHT_HEAVY = 1;
		
		private int balance;
		
		public AVLNode(E object)
		{
			super(object);
			balance = BALANCED;
		}
		
		@Override
		public String toString()
		{
			return balance + ": " + super.toString();
		}
	}
}