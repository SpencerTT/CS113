import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModMergeSort
{
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
		
		FileWriter lfw;
		FileWriter rfw;
		try
		{
			lfw = new FileWriter("src/left.txt");
			BufferedWriter lbw = new BufferedWriter(lfw);
			rfw = new FileWriter("src/right.txt");
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
			for (int x = 0; x < listsl.size(); x++)
			{
				int[] templ = listsl.get(x);
				int[] tempr;
				int[] merger;
				if (x < listsr.size())
				{
					tempr = listsr.get(x);
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