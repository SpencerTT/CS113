import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 * HeapDriver.java : A driver class that tests the methods of HashtableChain and it's inner classes.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class HashtableDriver
{
	public static void main(String[] args)
	{
		//HashtableOpen (Not necessary)
		//HashtableOpen<Integer, Integer> open = new HashtableOpen<Integer,Integer>(4, .70);
		//smallTest(open);
		
		//HashtableChain
		HashtableChain<Integer, Integer> chain = new HashtableChain<Integer,Integer>(4, .70);
		smallTest(chain);
		chain = new HashtableChain<Integer, Integer>();
		bigTest(chain);
		chain = new HashtableChain<Integer, Integer>();
		stressTest(chain);
	}
	
	/**
	 * A method to test out data and functionality on a small scale
	 * 
	 * @param map The AbstractMap where the data resides (AbstractMap so I could use HashtableOpen as well if needed...)
	 */
	public static void smallTest(AbstractMap<Integer, Integer> map)
	{
		map.put(0, 0);
		System.out.println("Get 0: " + map.get(0));
		map.put(4, 4);
		System.out.println("Full map: \n" + map.toString());
		map.put(2, 2);
		System.out.println("Full map: \n" + map.toString());
		map.remove(0);
		System.out.println("After remove 0: \n" + map.toString());
		map.put(2, 4);
		System.out.println("Full map after change 2: \n" + map.toString());
		AbstractSet<Entry<Integer, Integer>> set = (AbstractSet<Entry<Integer, Integer>>) map.entrySet();
		System.out.println("Set size: " + set.size());
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		System.out.println("First item in set: " + it.next());
		it.remove();
		System.out.println("Full map after deletion of 2\n" + map.toString());
	}
	/**
	 * A method to test out data and functionality on a large scale
	 * 
	 * @param map The AbstractMap where the data resides (AbstractMap so I could use HashtableOpen as well if needed...)
	 */
	public static void bigTest(AbstractMap<Integer, Integer> map)
	{
		for(int x = 0; x < 1000; x += 3)
		{
			map.put(x, x);
		}
		System.out.println(map.toString());
		
		for(int x = 3; x < 667; x += 3)
		{
			map.remove(x);
		}
		
		AbstractSet<Entry<Integer, Integer>> set = (AbstractSet<Entry<Integer, Integer>>) map.entrySet();
		System.out.println("Set size: " + set.size());
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		while(it.hasNext())
		{
			it.next();
			it.remove();
		}
		System.out.println("After total Removal: Set size: " + set.size());
		System.out.println("Full map: \n" + map.toString());
	}
	
	public static void stressTest(AbstractMap<Integer, Integer> map)
	{
		for(int x = 0; x < 100000; x++)
		{
			map.put((int) (Math.random()*320000), (int) (Math.random()*320000));
		}
		AbstractSet<Entry<Integer, Integer>> set = (AbstractSet<Entry<Integer, Integer>>) map.entrySet();
		System.out.println("Set size: " + set.size());
		System.out.print("Stare deep into hell? (y/n): ");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		if (choice.equals("y"))
		{
			System.out.println(map.toString());
		}
	}
}