import java.util.ArrayList;
import java.util.LinkedList;

public class Radix4
{
	public static void main(String[] args)
	{
		int SIZE = 100;
		int[] nums = new int[SIZE];
		for(int x = 0; x < SIZE; x++)
		{
			nums[x] = (int) (Math.random()*10000);
		}
		int[] sorted = radixSort(nums);
		for (int x = 0; x < SIZE; x++)
		{
			System.out.println(sorted[x]);
		}
	}

	public static int[] radixSort(int[] array)
	{
		int size = array.length;
		int it = 0;
		while(it < 4)
		{
			array = bucketsToList(listToBuckets(array, it), size);
			it++;
		}
		return array;
		
	}
	
	public static ArrayList<LinkedList<Integer>> listToBuckets(int[] array, int it)
	{
		ArrayList<LinkedList<Integer>> buckets = new ArrayList<LinkedList<Integer>>();
		for (int x = 0; x < 10; x++)
		{
			buckets.add(new LinkedList<Integer>());
		}
		for (int x = 0; x < array.length; x ++)
		{
			int digit = ((int) (array[x] / Math.pow(10, it)) % 10);
			buckets.get(digit).add(array[x]);
		}
		return buckets;
		
	}
	public static int[] bucketsToList(ArrayList<LinkedList<Integer>> buckets, int size)
	{
		int[] sorted = new int[size];
		int index = 0;
		for (LinkedList<Integer> list : buckets)
		{
			for(Integer value : list)
			{
				sorted[index] = value;
				index++;
			}
		}
		return sorted;
	}
}