import static org.junit.Assert.*;

import java.util.ListIterator;

import org.junit.Test;

public class ListIteratorTest
{

	@Test
	public void test()
	{
		ThompsonList<String> tl = new ThompsonList<String>();
		tl.add("Albert");
		tl.add("Bobby");
		tl.add("Curtis");
		tl.addFront("Danny");
		tl.addFront("Ernist");
		assertEquals(5, tl.size());
		
		System.out.println("The initial list:");
		System.out.println(tl.toString());
		
		//Begin ListIterator Tests
		
		ListIterator<String> it = tl.listIterator();
		//Walk-through forwards and backwards
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		while (it.hasPrevious())
		{
			System.out.println(it.previous());
		}
		//Remove from the middle
		System.out.println(it.next());
		System.out.println(it.next());
		it.remove();
		assertEquals(4, tl.size());
		System.out.println("Ernist is previous:");
		assertEquals("Ernist", it.previous());
		System.out.println(tl.toString());
		//Remove from the head
		it.remove();
		assertEquals(3, tl.size());
		System.out.println(it.next());
		System.out.println(tl.toString());
		//Remove from the tail
		while (it.hasNext())
		{
			it.next();
		}
		it.remove();
		assertEquals(2, tl.size());
		System.out.println("Bobby is previous:");
		assertEquals("Bobby", it.previous());
		System.out.println(tl.toString());
		//Add to the list and show list
		it.add("Herp");
		assertEquals(3, tl.size());
		System.out.println(tl.toString());
		//Add to the list a second time from same index and show list
		it.add("Derp");
		assertEquals(4, tl.size());
		System.out.println(tl.toString());
		//Add to the list from the tail
		System.out.println(it.next());
		it.add("Khan");
		assertEquals(5, tl.size());
		System.out.println(tl.toString());
		//Add to the list from head
		System.out.println(it.previous());
		while (it.hasPrevious())
		{
			it.previous();
		}
		it.add("Pikachu");
		assertEquals(6, tl.size());
		System.out.println(tl.toString());
		System.out.println("Pikachu is previous:");
		assertEquals("Pikachu", it.previous());
		it.set("Gary");
		System.out.println("Pikachu is now Gary:");
		System.out.println(tl.toString());
	}
}