import java.util.ArrayList;
import java.util.Comparator;

public class MinHeap<E extends Comparable<E>> extends Heap<E>
{
	public MinHeap()
	{
		heap = new ArrayList<E>();
		comp = null;
	}
	
	public MinHeap(Comparator<E> comp)
	{
		heap = new ArrayList<E>();
		this.comp = comp;
	}
	
	public int compare(E e1, E e2)
	{
		if (comp != null)
		{
			return comp.compare(e1, e2);
		}
		else
		{
			return ((Comparable<E>) e1).compareTo(e2);
		}
	}
}