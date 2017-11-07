import java.util.ArrayList;
import java.util.Comparator;
/**
 * MinHeap.java : A class that stores a minimum value heap as an ArrayList and has an optional Comparator
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class MinHeap<E extends Comparable<E>> extends Heap<E>
{
	/**
	 * 0-arg constructor that initializes heap and sets comp to null
	 */
	public MinHeap()
	{
		heap = new ArrayList<E>();
		comp = null;
	}
	
	/**
	 * 1-arg constructor that initializes heap and gives comp a proper value
	 * @param comp
	 */
	public MinHeap(Comparator<E> comp)
	{
		heap = new ArrayList<E>();
		this.comp = comp;
	}
	
	/**
	 * A method to compare two elements for correct placement in the heap (default min values at top of heap)
	 * 
	 * @param e1 The first element for comparison
	 * @param e2 The second element for comparison
	 * @return An int representation of the result of the comparison (-1 less than, 0 equal, 1 greater than)
	 */
	public int compare(E e1, E e2)
	{
		if (comp != null)
		{
			return comp.compare(e1, e2);
		}
		else
		{
			return e1.compareTo(e2);
		}
	}
}