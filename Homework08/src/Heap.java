import java.util.ArrayList;
import java.util.Comparator;

public abstract class Heap<E extends Comparable<E>>
{
	protected ArrayList<E> heap;
	protected Comparator<E> comp;
	
	protected void swap(int a, int b)
	{
		E temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
	}
	
	public String toString()
	{
		return heap.toString();
	}
	
	
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
	
	public abstract int compare(E e1, E e2);
}