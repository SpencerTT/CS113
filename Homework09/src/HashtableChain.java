import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class HashtableChain<K, V> extends AbstractMap<K, V> implements KWHashMap<K, V>
{
	private LinkedList<Entry<K, V>>[] table;
	private int numKeys;
	
	private static int START_CAPACITY = 101;
	private static double LOAD_THRESHOLD = 3.0;
	
	@SuppressWarnings("unchecked")
	public HashtableChain()
	{
		table = new LinkedList[START_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public HashtableChain(int start, double load)
	{
		START_CAPACITY = start;
		LOAD_THRESHOLD = load;
		table = new LinkedList[START_CAPACITY];
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < table.length; x++)
		{
			if (table[x] != null)
			{
				for(Entry<K, V> pair : table[x])
				{
					sb.append(pair.toString() + "\n");
				}
			}
		}
		return sb.toString();
	}
	
	public int size()
	{
		return table.length;
	}
	public boolean isEmpty()
	{
		return (numKeys == 0);
	}
	public V get(Object key)
	{
		int index = key.hashCode() % table.length;
		if (index < 0)
		{
			index += table.length;
		}
		if (table[index] == null)
		{
			return null;
		}
		else
		{
			for(Entry<K, V> pair : table[index])
			{
				if (pair.getKey().equals(key))
				{
					return pair.getValue();
				}
			}
		}
		return null;
	}
	public V put(K key, V value)
	{
		int index = key.hashCode() % table.length;
		if (index < 0)
		{
			index += table.length;
		}
		if (table[index] == null)
		{
			table[index] = new LinkedList<Entry<K, V>>();
		}
		for(Entry<K, V> pair : table[index])
		{
			if (pair.getKey().equals(key))
			{
				V old = pair.getValue();
				pair.setValue(value);
				return old;
			}
		}
		table[index].add(new Entry<K, V>(key, value));
		numKeys++;
		if  ((1.0*numKeys/table.length) > LOAD_THRESHOLD)
		{
			rehash();
		}
		return null;
	}
	public V remove(Object key)
	{
		int index = key.hashCode() % table.length;
		if (index < 0)
		{
			index += table.length;
		}
		if (table[index] == null)
		{
			return null;
		}
		for(Entry<K, V> pair : table[index])
		{
			if (pair.getKey().equals(key))
			{
				table[index].remove(pair);
				numKeys--;
				if (table[index].isEmpty())
				{
					table[index] = null;
				}
				return pair.getValue();
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void rehash()
	{
		System.out.println("Rehashing at " + numKeys + " keys... length: " + table.length);
		LinkedList<Entry<K, V>>[] copy = new LinkedList[table.length];
		System.arraycopy(table, 0, copy, 0, table.length);
		numKeys = 0;
		table = new LinkedList[table.length * 2 + 1];
		for(int x = 0; x < copy.length; x++)
		{
			if (copy[x] != null)
			{
				for(Entry<K, V> pair : copy[x])
				{
					put(pair.getKey(), pair.getValue());
				}
			}
		}
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet()
	{
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