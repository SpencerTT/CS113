import java.util.AbstractMap;

public class HashtableDriver
{
	public static void main(String[] args)
	{
		//HashtableOpen
		HashtableOpen<Integer, Integer> open = new HashtableOpen<Integer,Integer>(4, .70);
		basicTest(open);
		//HashtableChain
		HashtableChain<Integer, Integer> chain = new HashtableChain<Integer,Integer>(4, .70);
		basicTest(chain);
	}
	
	public static void basicTest(AbstractMap<Integer, Integer> map)
	{
		map.put(0, 0);
		System.out.println(map.get(0));
		map.put(5, 5);
		System.out.println(map.toString());
		map.put(2, 2);
		System.out.println(map.toString());
		map.remove(0);
		System.out.println(map.toString());
	}
}