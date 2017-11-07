import java.util.Comparator;
/**
 * MaxHeapComparator.java : A class that extends Comparator that is used to make a max value comparison for a heap
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class MaxHeapComparator<T extends Comparable<T>> implements Comparator<T>
{
	/**
	 * Returns a max value comparison for a heap to use
	 */
	public int compare(T arg0, T arg1)
	{
		return -arg0.compareTo(arg1);
	}
}