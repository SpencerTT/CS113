import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * ModMergeSort.java : A driver class that contains and tests the methods of ModMergeSort
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class ModMergeSort
{
	/**
	 * main() method: Writes the unsorted numbers to the all.txt file,
	 * runs a simple test of sort() (and merge()), and calls modMerge(10, true) 
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		try
		{
			FileWriter fw = new FileWriter("src/all.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int x = 0; x < 9001; x++)
			{
				bw.write( (int) (Math.random()*10000) + "\n" );
			}
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Test: {5, 3, 6, 9, 8, 1, 7, 2, 4, 0} sorts to...");
		int[] test = {5, 3, 6, 9, 8, 1, 7, 2, 4, 0};
		int[] sorted = sort(test);
		for (int x = 0; x < sorted.length; x++)
		{
			System.out.print(sorted[x] + ", ");
		}
		System.out.println();
		
		System.out.println("Now the big test...");
		modMerge(10, true);
		System.out.println("Finished!");
	}
	
	/**
	 * Recursive method for breaking the thousands of numbers into workable chunks of data,
	 * sorting them if it's the first pass through the recursion,
	 * writing those sorted chunks into two files one at a time: left.txt and right.txt
	 * each left and right chunk are merged together to form a larger chunk that is written into all.txt,
	 * until all the values are back in all.txt.  This method is called recursively with (size*2, false)
	 * until the file is completely sorted (when there is no right side / the size exceeds the total numbers)
	 * 
	 * @param size The size of the arrays to work with
	 * @param first A boolean indicating if it is the first pass or not
	 */
	public static void modMerge(int size, boolean first)
	{
		ArrayList<int[]> listsl = new ArrayList<int[]>();
		ArrayList<int[]> listsr = new ArrayList<int[]>();
		FileReader fr = null;
		try
		{
			fr = new FileReader("src/all.txt");
			BufferedReader br = new BufferedReader(fr);
			int count = 0;
			while(br.ready())
			{
				int[] list = getArray(size, br);
				if (count % 2 == 0)
				{
					listsl.add(list);
				}
				else
				{
					listsr.add(list);
				}
				count++;
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//Sorting happens here
		if (first)
		{
			for (int[] list : listsl)
			{
				int[] temp = sort(list);
				for (int x = 0; x < list.length; x++)
				{
					list[x] = temp[x];
					//System.out.print(list[x] + ", ");
				}
				//System.out.println();
			}
			for (int[] list : listsr)
			{
				int[] temp = sort(list);
				for (int x = 0; x < list.length; x++)
				{
					list[x] = temp[x];
					//System.out.print(list[x] + ", ");
				}
				//System.out.println();
			}
		}

		try
		{
			FileWriter lfw = new FileWriter("src/left.txt");
			BufferedWriter lbw = new BufferedWriter(lfw);
			FileWriter rfw = new FileWriter("src/right.txt");
			BufferedWriter rbw = new BufferedWriter(rfw);
			for(int x = 0; x < listsl.size(); x++)
			{
				int[] temp = listsl.get(x);
				for (int y = 0; y < temp.length; y++)
				{
					lbw.write(temp[y] + "\n");
					//System.out.print(temp[y] + ", ");
				}
				//System.out.println();
			}
			for(int x = 0; x < listsr.size(); x++)
			{
				int[] temp = listsr.get(x);
				for (int y = 0; y < temp.length; y++)
				{
					rbw.write(temp[y] + "\n");
					//System.out.print(temp[y] + ", ");
				}
				//System.out.println();
			}
			lbw.close();
			rbw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			FileWriter fw = new FileWriter("src/all.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			FileReader lfr = new FileReader("src/left.txt");
			BufferedReader lbr = new BufferedReader(lfr);
			FileReader rfr = new FileReader("src/right.txt");
			BufferedReader rbr = new BufferedReader(rfr);
			while (lbr.ready())
			{
				int[] templ = getArray(size, lbr);
				int[] tempr;
				int[] merger;
				if (rbr.ready())
				{
					tempr = getArray(size, rbr);
					merger = merge(templ, tempr);
				}
				else
				{
					merger = templ;
				}
				
				for (int y = 0; y < merger.length; y++)
				{
					bw.write(merger[y] + "\n");
				}
			}
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		if (!listsr.isEmpty())
		{
			modMerge(size * 2, false);
		}
	}
	
	/**
	 * Returns an array of data of size "size" from a file being read by BufferedReader br
	 * 
	 * @param size The size of the desired array
	 * @param br The BufferedReader that the method will acquire the data from
	 * @return An array of length "size" that was made by the last "size" entries in br
	 */
	public static int[] getArray(int size, BufferedReader br)
	{
		int[] list = new int[size];
		int end = -1;
		for (int x = 0; x < size; x++)
		{
			int read = -1;
			try
			{
				String temp = br.readLine();
				if (temp != null)
				{
					read = Integer.parseInt(temp);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			if (read != -1)
			{
				list[x] = read;
			}
			else
			{
				end = x;
				x = size;
			}
		}
		if (end != -1)
		{
			int[] copy = list.clone();
			list = new int[end];
			for (int x = 0; x < list.length; x++)
			{
				list[x] = copy[x];
			}
		}
		return list;
	}
	
	/**
	 * Basic MergeSort logic for sorting the chunks of data on the first pass of modMerge
	 * 
	 * @param table The array to sort
	 * @return The sorted array
	 */
	public static int[] sort(int[] table)
	{
		if (table.length > 1)
		{
			int half = table.length / 2;
			int[] left = new int[half];
			int[] right = new int[table.length - half];
			for (int x = 0; x < half; x++)
			{
				left[x] = table[x];
			}
			for (int x = half; x < table.length; x++)
			{
				right[x-half] = table[x];
			}
			left = sort(left);
			right = sort(right);
			return merge(left, right);
		}
		else
		{
			return table;
		}
	}
	
	/**
	 * Basic merge logic used in sort and in modMerge to join two sorted arrays
	 * 
	 * @param left The left array to be merged
	 * @param right The right array to be merged
	 * @return A sorted array with all values of left and right
	 */
	public static int[] merge(int[] left, int[] right)
	{
		int[] merger = new int[left.length + right.length];
		int li = 0;
		int ri = 0;
		int mi = 0;
		
		while (li < left.length && ri < right.length)
		{
			if (left[li] <= right[ri])
			{
				merger[mi] = left[li];
				mi++;
				li++;
			}
			else
			{
				merger[mi] = right[ri];
				mi++;
				ri++;
			}
		}
		while(li < left.length)
		{
			merger[mi] = left[li];
			mi++;
			li++;
		}
		while(ri < right.length)
		{
			merger[mi] = right[ri];
			mi++;
			ri++;
		}
		return merger;
	}
}