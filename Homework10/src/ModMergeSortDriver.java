/**
 * ModMergeSortDriver.java : A driver class that tests the methods of ModMergeSort
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class ModMergeSortDriver
{
	/**
	 * main() method: Writes the unsorted numbers to the all.txt file,
	 * runs a simple test of sort() (and merge()), and calls modMerge(10, true) 
	 * @param args unused
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		ModMergeSort mms = new ModMergeSort();
		System.out.println("Currently ModMergeSorting...");
		mms.modMerge(10, true);
		mms.display();
		System.out.println("Finished!");
	}
}