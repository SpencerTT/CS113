import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * HashTableOpen.java : Wasn't supposed to make it, but did 1/2 of it anyways, LOL.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class HashtableOpen<K, V> extends AbstractMap<K, V> implements KWHashMap<K, V>
{
	private Entry<K, V>[] table;
	private int START_CAPACITY = 101;
	private double LOAD_THRESHOLD = .75;
	private int numKeys;
	private int numDeletes;
	private final Entry<K, V> DELETED = new Entry<K, V>(null, null);

	@SuppressWarnings("unchecked")
	public HashtableOpen()
	{
		table = new Entry[START_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public HashtableOpen(int start, double load)
	{
		START_CAPACITY = start;
		LOAD_THRESHOLD = load;
		table = new Entry[START_CAPACITY];
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < table.length; x++)
		{
			if (table[x] != null && table[x] != DELETED)
			{
					sb.append(table[x].toString() + "\n");
			}
		}
		return sb.toString();
	}
	
	/**
	 * The current number of key-value pairs
	 * 
	 * @return The number of key-value pairs
	 */
	public int size()
	{
		return numKeys;
	}
	public boolean isEmpty()
	{
		return (numKeys == 0);
	}
	
	private int find(Object key)
	{
		int index = key.hashCode() % table.length;
		if (index < 0)
		{
			index += table.length;
		}
		while (table[index] != null && key != table[index].getKey())
		{
			index++;
			if (index >= table.length)
			{
				index = 0;
			}
		}
		return index;
	}
	
	public V get(Object key)
	{
		int index = find(key);
		if (table[index].getKey().equals(key))
		{
			return table[index].getValue();
		}
		else
		{
			return null;
		}
	}
	
	public V put(K key, V value)
	{
		int index = find(key);
		if (table[index] == null)
		{
			table[index] = new Entry<K, V>(key, value);
			numKeys++;
			if (1.0*(numKeys+numDeletes)/table.length > LOAD_THRESHOLD)
			{
				rehash();
			}
			return null;
		}
		else
		{
			V old = table[index].getValue();
			table[index].setValue(value);
			return old;
		}
	}
	
	public V remove(Object key)
	{
		int index = find(key);
		if (table[index] == null)
		{
			return null;
		}
		else
		{
			V old = table[index].getValue();
			table[index] = DELETED;
			numKeys--;
			numDeletes++;
			return old;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void rehash()
	{
		System.out.println("Rehashing at " + (numKeys+numDeletes) + " filled... length: " + table.length);
		Entry<K, V>[] copy = new Entry[table.length];
		System.arraycopy(table, 0, copy, 0, table.length);
		numKeys = 0;
		numDeletes = 0;
		table = new Entry[table.length * 2 + 1];
		for (int x = 0; x < copy.length; x++)
		{
			if (copy[x] != null && copy[x] != DELETED)
			{
				put(copy[x].getKey(), copy[x].getValue());
			}
		}
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("hiding")
	private class Entry<K, V> implements Map.Entry<K, V>
	{
		private K key;
		private V value;
		
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		public K getKey()
		{
			return key;
		}
		public V getValue()
		{
			return value;
		}
		public V setValue(V value)
		{
			V old = getValue();
			this.value = value;
			return old;
		}
		
		public String toString()
		{
			return key.toString() + " = " + value.toString();
		}
	}
}