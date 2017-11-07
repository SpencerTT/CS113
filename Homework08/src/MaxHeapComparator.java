import java.util.Comparator;

public class MaxHeapComparator<T extends Comparable<T>> implements Comparator<T>
{
	public int compare(T arg0, T arg1)
	{
		return -((Comparable<T>) arg0).compareTo(arg1);
	}
}