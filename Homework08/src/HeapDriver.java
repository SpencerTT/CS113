
public class HeapDriver
{
	public static void main(String[] args)
	{
		//Test Lab11
		MinHeap<Integer> min = new MinHeap<Integer>();
		min.insert(10);
		min.insert(14);
		min.insert(3);
		min.insert(6);
		min.insert(12);
		min.insert(13);
		min.insert(7);
		min.insert(4);
		min.insert(1);
		min.insert(2);
		System.out.println(min); //Should match Lab11 (and does)
		Integer testMin = min.remove();
		System.out.println(testMin);
		System.out.println(min);
		System.out.println();
		
		//Test Max version of Lab11
		MaxHeap<Integer> max = new MaxHeap<Integer>();
		max.insert(10);
		max.insert(14);
		max.insert(3);
		max.insert(6);
		max.insert(12);
		max.insert(13);
		max.insert(7);
		max.insert(4);
		max.insert(1);
		max.insert(2);
		System.out.println(max); 
		Integer testMax = max.remove();
		System.out.println(testMax);
		System.out.println(max);
		System.out.println();
		
		//Make a MinHeap that acts like a MaxHeap
		MinHeap<Integer> minMax = new MinHeap<Integer>(new MaxHeapComparator<Integer>());
		minMax.insert(10);
		minMax.insert(14);
		minMax.insert(3);
		minMax.insert(6);
		minMax.insert(12);
		minMax.insert(13);
		minMax.insert(7);
		minMax.insert(4);
		minMax.insert(1);
		minMax.insert(2);
		System.out.println(minMax); //Should match MaxHeap (and does)
		Integer testMinMax = minMax.remove();
		System.out.println(testMinMax);
		System.out.println(minMax);
		System.out.println();
		
		//Make a MinHeap that acts like a MaxHeap
		MaxHeap<Integer> maxMin = new MaxHeap<Integer>(new MinHeapComparator<Integer>());
		maxMin.insert(10);
		maxMin.insert(14);
		maxMin.insert(3);
		maxMin.insert(6);
		maxMin.insert(12);
		maxMin.insert(13);
		maxMin.insert(7);
		maxMin.insert(4);
		maxMin.insert(1);
		maxMin.insert(2);
		System.out.println(maxMin); //Should match MinHeap (and does)
		Integer testMaxMin = maxMin.remove();
		System.out.println(testMaxMin);
		System.out.println(maxMin);
		System.out.println();
	}
}