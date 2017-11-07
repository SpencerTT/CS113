import java.util.ArrayList;
import java.util.Comparator;
/**
 * Heap.java : An abstract class that stores a heap as an ArrayList and has an optional Comparator
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public abstract class Heap<E extends Comparable<E>>
{
	protected ArrayList<E> heap;
	protected Comparator<E> comp;
	
	/**
	 * A quick way to switch two values in the heap given two indices
	 * @param a The first index
	 * @param b The second index
	 */
	protected void swap(int a, int b)
	{
		E temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
	}
	
	/**
	 * The string representation of a Heap
	 */
	public String toString()
	{
		return heap.toString();
	}
	
	/**
	 * The method responsible for correctly inserting an element into to heap
	 * 
	 * @param obj The element to insert into the heap
	 */
	public void insert(E obj)
	{
		heap.add(obj);
		int child = heap.size() - 1;
		int parent = (child - 1) / 2;
		while(child != 0 && compare(heap.get(child), heap.get(parent)) < 0)
		{
			swap(child, parent);
			child = parent;
			parent = (child - 1) / 2;
		}
	}
	
	/**
	 * The method responsible for correctly removing an element from the heap
	 * 
	 * @return The element that was removed from the heap
	 */
	public E remove()
	{
		if (heap.isEmpty())
		{
			return null;
		}
		else
		{
			E removed = heap.get(0);
			heap.set(0, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			int parent = 0;
			int lchild = 2*parent + 1;
			int rchild = 2*parent + 2;
			boolean hl = (lchild < heap.size());//hasleft
			boolean hr = (rchild < heap.size());//hasright
			boolean sl = hl && (compare(heap.get(lchild), heap.get(parent)) < 0);//swapleft
			boolean sr = hr && (compare(heap.get(rchild), heap.get(parent)) < 0);//swapright
			while(sl || sr)
			{
				int swapUp;
				if (!hr)
				{
					swapUp = lchild;
				}
				else
				{
					if (compare(heap.get(lchild), heap.get(rchild)) < 0)
					{
						swapUp = lchild;
					}
					else
					{
						swapUp = rchild;
					}
				}
				swap(swapUp, parent);
				parent = swapUp;
				lchild = 2*parent + 1;
				rchild = 2*parent + 2;
				hl = (lchild < heap.size());
				hr = (rchild < heap.size());
				sl = hl && (compare(heap.get(lchild), heap.get(parent)) < 0);
				sr = hr && (compare(heap.get(rchild), heap.get(parent)) < 0);
			}
			return removed;
		}
	}
	
	/**
	 * A method to compare two elements for correct placement in the heap
	 * 
	 * @param e1 The first element for comparison
	 * @param e2 The second element for comparison
	 * @return An int representation of the result of the comparison (-1 less than, 0 equal, 1 greater than)
	 */
	public abstract int compare(E e1, E e2);
}