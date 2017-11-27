import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * ModMergeSort.java : A class that contains all the methods necessary
 * to do a modified mergeSort on Comparable data
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class ModMergeSort<E extends Comparable<E>>
{
	
	/**
	 * 0-arg constructor to write 9001 random numbers into the "all.txt" file.
	 * Just gets things ready for the other methods.
	 * 
	 */
	public ModMergeSort()
	{
		try
		{
			FileOutputStream  afos = new FileOutputStream("src/all.txt");
			ObjectOutputStream aoos = new ObjectOutputStream(afos);
			for (int x = 0; x < 9001; x++)
			{
				aoos.writeObject( new Integer((int) (Math.random()*10000)));
			}
			aoos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
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
	public void modMerge(int size, boolean first)
	{
		ArrayList<E[]> listsl = new ArrayList<E[]>();
		ArrayList<E[]> listsr = new ArrayList<E[]>();
		try
		{
			FileInputStream fis = new FileInputStream("src/all.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			int count = 0;
			boolean found = true;
			while(found)
			{
				E[] list = getArray(size, ois);
				if (list.length < 1)
				{
					found = false;
				}
				else if (count % 2 == 0)
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
			for (E[] list : listsl)
			{
				E[] temp = sort(list);
				for (int x = 0; x < list.length; x++)
				{
					list[x] = temp[x];
					//System.out.print(list[x] + ", ");
				}
				//System.out.println();
			}
			for (E[] list : listsr)
			{
				E[] temp = sort(list);
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
			FileOutputStream  lfos = new FileOutputStream("src/left.txt");
			ObjectOutputStream loos = new ObjectOutputStream(lfos);
			FileOutputStream  rfos = new FileOutputStream("src/right.txt");
			ObjectOutputStream roos = new ObjectOutputStream(rfos);
			for(int x = 0; x < listsl.size(); x++)
			{
				E[] temp = listsl.get(x);
				for (int y = 0; y < temp.length; y++)
				{
					loos.writeObject(temp[y]);
					//System.out.print(temp[y] + ", ");
				}
				//System.out.println();
			}
			for(int x = 0; x < listsr.size(); x++)
			{
				E[] temp = listsr.get(x);
				for (int y = 0; y < temp.length; y++)
				{
					roos.writeObject(temp[y]);
					//System.out.print(temp[y] + ", ");
				}
				//System.out.println();
			}
			loos.close();
			roos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			FileOutputStream  afos = new FileOutputStream("src/all.txt");
			ObjectOutputStream aoos = new ObjectOutputStream(afos);
			FileInputStream lfis = new FileInputStream("src/left.txt");
			ObjectInputStream lois = new ObjectInputStream(lfis);
			FileInputStream rfis = new FileInputStream("src/right.txt");
			ObjectInputStream rois = new ObjectInputStream(rfis);
			
			boolean end = false;
			while (! end)
			{
				E[] templ = getArray(size, lois);
				E[] tempr = getArray(size, rois);
				E[] merger;
				if (tempr.length != 0)
				{
					merger = merge(templ, tempr);
				}
				else
				{
					merger = templ;
					end = true;
				}
				
				for (int y = 0; y < merger.length; y++)
				{
					aoos.writeObject(merger[y]);
				}
			}
			aoos.close();
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
	 * Displays all of the sorted numbers in order to the user.
	 * 
	 */
	public void display()
	{
		try
		{
			FileInputStream fis = new FileInputStream("src/all.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Integer temp;
			do
			{
				temp = (Integer) ois.readObject();
				if (temp != null)
				{
					System.out.println(temp);
				}
			}
			while (temp != null);
			ois.close();
			
		}
		catch (EOFException e)
		{
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns an array of data of size "size" from a file being read by BufferedReader br
	 * 
	 * @param size The size of the desired array
	 * @param br The BufferedReader that the method will acquire the data from
	 * @return An array of length "size" that was made by the last "size" entries in br
	 */
	@SuppressWarnings("unchecked")
	public E[] getArray(int size, ObjectInputStream ois)
	{
		E[] list = (E[]) new Comparable [size];
		int end = -1;
		for (int x = 0; x < size; x++)
		{
			E temp = null;
			try
			{
				temp = (E) ois.readObject();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (EOFException e)
			{
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			if (temp != null)
			{
				list[x] = temp;
			}
			else
			{
				end = x;
				x = size;
			}
		}
		if (end != -1)
		{
			E[] copy = list.clone();
			list = (E[]) new Comparable[end];
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
	@SuppressWarnings("unchecked")
	public E[] sort(E[] table)
	{
		if (table.length > 1)
		{
			int half = table.length / 2;
			E[] left = (E[]) new Comparable[half];
			E[] right = (E[]) new Comparable[table.length - half];
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
	@SuppressWarnings("unchecked")
	public E[] merge(E[] left, E[] right)
	{
		E[] merger = (E[]) new Comparable[left.length + right.length];
		int li = 0;
		int ri = 0;
		int mi = 0;
		
		while (li < left.length && ri < right.length)
		{
			if (left[li].compareTo(right[ri]) < 0)
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