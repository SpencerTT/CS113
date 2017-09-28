import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * ThompsonList.java : A class that implements List
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */

public class ThompsonList<E> implements List<E>
{
	private TNode<E> head;
	private TNode<E> tail;
	private int size;
	
	/**
	 * 0-arg constructor for a ThompsonList
	 */
	public ThompsonList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Returns a string representation of the list
	 * 
	 * @return The string representation of the list
	 */
	public String toString()
	{
		String aString = "";
		ListIterator<E> it = listIterator();
		while (it.hasNext())
		{
			aString += it.next() + " => ";
		}
		return aString;
	}
	
	/**
	 * Removes the front (head) node from the list
	 * @return true if there is something to remove, false if not
	 */
	public boolean removeFront()
	{
		TNode<E> cNode = head;
		if(cNode != null)
		{
			if (cNode.getNext() != null)
			{
				cNode.getNext().setPrev(null);
				head = cNode.getNext();
			}
			else
			{
				head = null;
				tail = null;
			}
			size--;
			return true;
		}
		return false;
	}
	
	/**
	 * Removes a given Object entry
	 * 
	 * @param entry The data to be removed from the list
	 * @return true if object removed, false if object not found
	 */
	@Override
	public boolean remove(Object entry)
	{
		TNode<E> cNode = head;
		while (cNode != null)
		{
			if (cNode.getData().equals(entry))
			{
				if (cNode.getNext() != null && cNode.getPrev() != null)
				{
					cNode.getNext().setPrev(cNode.getPrev());
					cNode.getPrev().setNext(cNode.getNext());
				}
				else if (cNode.getNext() != null && cNode.getPrev() == null)
				{
					cNode.getNext().setPrev(null);
					head = cNode.getNext();
				}
				else if (cNode.getNext() == null && cNode.getPrev() != null)
				{
					cNode.getPrev().setNext(null);
					tail = cNode.getPrev();
				}
				else
				{
					head = null;
					tail = null;
				}
				size--;
				return true;
			}
			cNode = cNode.getNext();
		}
		return false;
	}
	
	/**
	 * Adds data to the front of the list
	 * 
	 * @param entry Data to add to the front of the list
	 * @return true if added, false if failed (never occurs)
	 */
	public boolean addFront(E entry)
	{
		//Add new node to front of list
		head = new TNode<E>(entry, head, null);
		//Make sure next node's previous points to head
		if (head.getNext() != null)
		{
			head.getNext().setPrev(head);
		}
		//If tail was null, set it to head (0=>1 element list)
		if (tail == null)
		{
			tail = head;
		}
		//Increment size and return true
		size++;
		return true;
	}
	
	/**
	 * Adds a piece of data entry to the back of the list
	 * 
	 * @param entry the piece of data to add to the list
	 * @return true if the item is added (always occurs)
	 */
	@Override
	public boolean add(E entry)
	{
		//Add new node to back of list
		tail = new TNode<E>(entry, null, tail);
		//Make sure previous node's next points to tail
		if (tail.getPrev() != null)
		{
			tail.getPrev().setNext(tail);
		}
		//If head was null, set it to tail (0=>1 element list)
		if (head == null)
		{
			head = tail;
		}
		//Increment size and return true
		size++;
		return true;
	}
	
	/**
	 * Adds an element to the list at a given index
	 * 
	 * @param element The piece of data to be added to the list
	 */
	@Override
	public void add(int index, E element)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0)
		{
			addFront(element);
		}
		else
		{
			TNode<E> cNode = head;
			int current = 0;
			
			if (cNode != null)
			{
				while (current < index)
				{
					cNode = cNode.getNext();
					current++;
				}
				TNode<E> addNode = new TNode<E>(element, cNode, cNode.getPrev());
				cNode.getPrev().setNext(addNode);
				cNode.setPrev(addNode);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Obtains the data stored at a given index
	 * 
	 * @param index The index at which the desired data is stored
	 * @return The data of the node at position index
	 */
	@Override
	public E get(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			TNode<E> cNode = head;
			int current = 0;
			while (current < index)
			{
				cNode = cNode.getNext();
				current++;
			}
			return cNode.getData();
		}
	}

	/**
	 * Finds the index of a target object
	 * 
	 * @param target The target data to find the index for
	 * @return The index of the target, or -1 if not found
	 */
	@Override
	public int indexOf(Object target)
	{
		TNode<E> current = head;
		int count = 0;
		if (head == null)
		{
			return -1;
		}
		else
		{
			while (count < size)
			{
				E item = current.getData();
				if (target.equals(item))
				{
					return count;
				}
				current = current.getNext();
				count++;
			}
			return -1;
		}
	}

	/**
	 * Determines if the list is empty
	 * 
	 * @return true if the list is empty, false if not
	 */
	@Override
	public boolean isEmpty()
	{
		return (head == null);
	}
	
	@Override
	public Iterator<E> iterator(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Creates and returns a ListIterator
	 * 
	 * @return The constructed ListIterator
	 */
	@Override
	public ListIterator<E> listIterator()
	{
		ListIterator<E> it = new ListIterator<E>()
		{
			private TNode<E> next = head;
			private TNode<E> prev = null;
			private TNode<E> last = null;
			private int index = 0;

			/**
			 * Determines if there is a next token
			 * 
			 * @return True if next is not null, false if null
			 */
			@Override
			public boolean hasNext()
			{
				return (next != null);
			}

			/**
			 * Iterates forward towards the tail
			 * 
			 * @return The data that was iterated over
			 */
			@Override
			public E next()
			{
				if (next != null)
				{
					last = next;
					prev = last;
					next = next.getNext();
					index++;
					return last.getData();
				}
				throw new NoSuchElementException();
			}
			
			/**
			 * Returns the next index
			 * @return The next index or size if at end of list
			 */
			@Override
			public int nextIndex()
			{
				if (hasNext())
				{
					return index;
				}
				else
				{
					return size;
				}
			}
			/**
			 * Determines if there is a previous token
			 * 
			 * @return True if prev is not null, false if null
			 */
			@Override
			public boolean hasPrevious()
			{
				return (prev != null);
			}
			
			/**
			 * Iterates backwards towards the head
			 * 
			 * @return The data that was iterated over
			 */
			@Override
			public E previous()
			{
				if (prev != null)
				{
					last = prev;
					next = last;
					prev = prev.getPrev();
					index--;
					return last.getData();
				}
				throw new NoSuchElementException();
			}

			/**
			 * Returns the previous index
			 * @return The previous index or -1 if at front of list
			 */
			@Override
			public int previousIndex()
			{
				if (hasPrevious())
				{
					return index - 1;
				}
				else
				{
					return -1;
				}
			}
			
			/**
			 * Sets the last traversed node's data to element
			 * 
			 * @param element The data to set over the last traversed node's data
			 */
			@Override
			public void set(E element)
			{
				if (last != null)
				{
					last.setData(element);
				}
				else
				{
					throw new IllegalStateException();
				}
			}
			
			/**
			 * Adds the data element to the list behind next and after previous
			 * 
			 * @param element The data to be added to the list
			 */
			@Override
			public void add(E element)
			{
				TNode<E> aNode = new TNode<E>(element, next, prev);
				if (next != null)
				{
					if (prev != null)
					{
						prev.setNext(aNode);
						next.setPrev(aNode);
						System.out.println("Add middle");
					}
					else
					{
						next.setPrev(aNode);
						head = aNode;
						System.out.println("Add head");
					}
				}
				else
				{
					if (prev != null)
					{
						prev.setNext(aNode);
						tail = aNode;
						System.out.println("Add tail");
					}
					else
					{
						head = aNode;
						tail = head;
						next = head;
						prev = null;
						System.out.println("Add empty");
					}
				}
				prev = aNode;
				index++;
			}

			/**
			 * Removes the last traversed node from the list
			 * 
			 */
			@Override
			public void remove()
			{
				if (last != null)
				{
					System.out.println("Remove " + last.getData());
					if (last.getNext() != null && last.getPrev() != null)
					{
						last.getNext().setPrev(last.getPrev());
						last.getPrev().setNext(last.getNext());
						next = last.getNext();
						prev = last.getPrev();
						System.out.println("Remove From Middle");
					}
					else if (last.getNext() != null && last.getPrev() == null)
					{
						last.getNext().setPrev(null);
						head = last.getNext();
						next = last.getNext();
						prev = null;
						System.out.println("Remove From Head");
					}
					else if (last.getNext() == null && last.getPrev() != null)
					{
						last.getPrev().setNext(null);
						tail = last.getPrev();
						next = null;
						prev = last.getPrev();
						System.out.println("Remove From Tail");
					}
					else
					{
						head = null;
						tail = null;
						next = null;
						prev = null;
						System.out.println("List is now empty");
					}
					size--;
					last = null;
				}
				else
				{
					throw new IllegalStateException();
				}
			}
		};
		return it;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Sets the node data at index to element
	 * 
	 * @param index The index of the node to set
	 * @param element The data to set in the node
	 * @return The old data from the node
	 */
	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			TNode<E> cNode = head;
			int current = 0;
			while (current < index)
			{
				cNode = cNode.getNext();
				current++;
			}
			E temp = cNode.getData();
			cNode.setData(element);
			return temp;
		}
	}

	/**
	 * Returns the size of the list
	 * 
	 * @return The size of the list
	 */
	@Override
	public int size()
	{
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * TNode.java : A class that can be used to form a doubly-linked list
	 * 
	 * @author Spencer Thompson
	 * @version 1.0
	 *
	 */
	private static class TNode<E>
	{
		private E data;
		private TNode<E> next;
		private TNode<E> prev;
		
		/**
		 * 3-arg constructor to make a new TNode
		 * 
		 * @param data the data to be held in the node
		 * @param next the node to the right of this node
		 * @param prev the node to the left of this node
		 */
		public TNode(E data, TNode<E> next, TNode<E> prev)
		{
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		/**
		 * Sets the data of this node
		 * 
		 * @param data The data to be set as this node's data
		 */
		public void setData(E data)
		{
			this.data = data;
		}
		/**
		 * Sets the next node of this node
		 * 
		 * @param next The node to be set as this node's next node
		 */
		public void setNext(TNode<E> next)
		{
			this.next = next;
		}
		/**
		 * Sets the previous node of this node
		 * 
		 * @param prev The node to be set as this node's previous node
		 */
		public void setPrev(TNode<E> prev)
		{
			this.prev = prev;
		}
		
		/**
		 * Gets the data of the node
		 * 
		 * @return the data of the node
		 */
		public E getData()
		{
			return data;
		}
		/**
		 * Gets the next node of the node
		 * 
		 * @return the next node
		 */
		public TNode<E> getNext()
		{
			return next;
		}
		/**
		 * Gets the previous node of the node
		 * 
		 * @return the previous node
		 */
		public TNode<E> getPrev()
		{
			return prev;
		}
		
		/**
		 * Returns the string representation of the node
		 * 
		 * @return The string representation of the node
		 */
		public String toString()
		{
			return data.toString();
		}
		
		/**
		 * Determines if two TNodes are equal to each other
		 * @param other The other TNode to compare against
		 * @return True if they have the same data, false if not
		 */
		public boolean equals(TNode<E> other)
		{
			return data.equals(other.getData());
		}
	}
}