@SuppressWarnings("serial")
public class AVLTree<E extends Comparable<E>> extends BSTWithRotate<E>
{
	private boolean increase;
	
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
			addReturn = true;
			increase = true;
			return new AVLNode<E>(object);
		}
		else if (object.compareTo(current.data) == 0)
		{
			increase = false;
			addReturn = false;
			return current;
		}
		else if (object.compareTo(current.data) < 0)
		{
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
					return rebalanceLeft(current);
				}
			}
			return current;
		}
		else
		{
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
					return rebalanceRight(current);
				}
			}
			return current;
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
			
			current.left = rotateLeft(leftChild);
		}
		else
		{
			leftChild.balance = AVLNode.BALANCED;
			current.balance = AVLNode.BALANCED;
		}
		
		return (AVLNode<E>) rotateRight(current);
	}
	
	private AVLNode<E> rebalanceRight(AVLNode<E> current)
	{
		AVLNode<E> rightChild = (AVLNode<E>) current.right;
		
		if (rightChild.balance < AVLNode.BALANCED)
		{
			AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
			
			if (rightLeftChild.balance < AVLNode.BALANCED)
			{
				rightChild.balance = AVLNode.BALANCED;
				rightLeftChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.RIGHT_HEAVY;
			}
			else if (rightLeftChild.balance > AVLNode.BALANCED)
			{
				rightChild.balance = AVLNode.LEFT_HEAVY;
				rightLeftChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.BALANCED;
			}
			else
			{
				rightChild.balance = AVLNode.BALANCED;
				current.balance = AVLNode.BALANCED;
			}
			
			current.right = rotateRight(rightChild);
		}
		else
		{
			rightChild.balance = AVLNode.BALANCED;
			current.balance = AVLNode.BALANCED;
		}
		
		return (AVLNode<E>) rotateLeft(current);
	}
	
	private void decrementBalance(AVLNode<E> node)
	{
		node.balance--;
		if (node.balance == AVLNode.BALANCED)
		{
			increase = false;
		}
	}
	
	private void incrementBalance(AVLNode<E> node)
	{
		node.balance++;
		if (node.balance == AVLNode.BALANCED)
		{
			increase = false;
		}
	}
	
	private static class AVLNode<E> extends Node<E>
	{
		public static final int LEFT_HEAVY = -1;
		public static final int BALANCED = 0;
		public static final int RIGHT_HEAVY = -1;
		
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