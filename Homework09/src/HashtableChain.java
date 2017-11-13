import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
/**
 * HashTableChain.java : A class that defines the logic for a HashtableChain implementation of a hashmap.
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public class HashtableChain<K, V> extends AbstractMap<K, V> implements KWHashMap<K, V>
{
	private LinkedList<Entry<K, V>>[] table;
	private int numKeys;
	
	private int START_CAPACITY = 101;
	private double LOAD_THRESHOLD = 3.0;
	
	/**
	 * 0-arg default constructor
	 */
	@SuppressWarnings("unchecked")
	public HashtableChain()
	{
		table = new LinkedList[START_CAPACITY];
	}
	
	/**
	 * 2-arg custom constructor to change important values
	 * 
	 * @param start The value of the new START_CAPACITY
	 * @param load The value of the new LOAD_THRESHOLD
	 */
	@SuppressWarnings("unchecked")
	public HashtableChain(int start, double load)
	{
		START_CAPACITY = start;
		LOAD_THRESHOLD = load;
		table = new LinkedList[START_CAPACITY];
	}
	
	/**
	 * A String representation of a HashtableChain
	 * 
	 * @return A String representation of a HashtableChain
	 */
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
	
	/**
	 * The current length of the table
	 * 
	 * @return The length of the table
	 */
	public int size()
	{
		return table.length;
	}
	
	/**
	 * Returns true if empty, false if not
	 * 
	 * @return true if empty, false if not
	 */
	public boolean isEmpty()
	{
		return (numKeys == 0);
	}
	/**
	 * Gets the value of the given key
	 * 
	 * @param key The key to use to look for the value
	 * @return The value of the given key, or null if not found
	 */
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
	/**
	 * Place the key value pair into the table (or give the pair a new value if found)
	 * 
	 * @param key The key of the pair
	 * @param value The value of the pair
	 * @return The old value of the key-value pair
	 */
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
	/**
	 * Remove a key-value pair by searching for key
	 * 
	 * @param key The key to be deleted
	 * @return The value of the key-value pair that was deleted
	 */
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
	
	/**
	 * Re-make the table 2x+1 size and put all the pairs back into it
	 */
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
	/**
	 * Get a new EntrySet to work with
	 * 
	 * @return A new EntrySet
	 */
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet()
	{
		return new EntrySet();
	}
	
	/** Inner class to implement the set view. */
	private class EntrySet extends java.util.AbstractSet<Map.Entry<K, V>>
	{
		/** Return the size of the set. */
		@Override
		public int size()
		{
			return numKeys;
		}
		/** Return an iterator over the set. */
		@Override
		public Iterator<Map.Entry<K, V>> iterator()
		{
			return new SetIterator();
		}
	}
	
	/** Inner class to implement the set iterator. */
	private class SetIterator implements Iterator<Map.Entry<K, V>>
	{
		int index = 0;
		Iterator<Entry<K, V>> localIterator = null;
		
		/**
		 * Checks to see whether there is another available value
		 * 
		 * @return True if there is something left, false if not
		 */
		@Override
		public boolean hasNext()
		{
			if (localIterator != null)
			{
				if (localIterator.hasNext())
				{
					return true;
				}
				else
				{
					localIterator = null;
					index++;
				}
			}
			while (index < table.length && table[index] == null)
			{
				index++;
			}
			if (index == table.length)
			{
				return false;
			}
			localIterator = table[index].iterator();
			return localIterator.hasNext();
		}
		/**
		 * Returns the next available value in iteration
		 * 
		 * @return A Map.Entry<K, V> that is next in iteration
		 */
		@Override
		public Map.Entry<K, V> next()
		{
			if (localIterator != null)
			{
				if (localIterator.hasNext())
				{
					return localIterator.next();
				}
				else
				{
					localIterator = null;
					index++;
				}
			}
			while (index < table.length && table[index] == null)
			{
				index++;
			}
			if (index == table.length)
			{
				return null;
			}
			else
			{
				localIterator = table[index].iterator();
				return localIterator.next();
			}
		}
		/**
		 * Removes the last-traversed item in iteration
		 * Pre-condition: next() must have been called at least 1 time
		 * since start or after last remove()
		 */
		@Override
		public void remove()
		{
			if (localIterator != null)
			{
				localIterator.remove();
				numKeys--;
			}
		}
	}
	
	/**
	 * HashTableChain.java : A class that stores the basic data for a key-value pair
	 * 
	 * @author Spencer Thompson
	 * @version 1.0
	 *
	 */
	@SuppressWarnings("hiding")
	private class Entry<K, V> implements Map.Entry<K, V>
	{
		private K key;
		private V value;
		
		/**
		 * 2-arg constructor to establish both variables
		 * 
		 * @param key The key for this key-value pair
		 * @param value The value for this key-value pair
		 */
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		/**
		 * Returns the key of the key-value pair
		 * 
		 * @return The key of the key-value pair
		 */
		public K getKey()
		{
			return key;
		}
		/**
		 * Returns the value of the key-value pair
		 * 
		 * @return The value of the key-value pair
		 */
		public V getValue()
		{
			return value;
		}
		/**
		 * Sets a new value for the key-value pair
		 * @return The old value from the key-value pair
		 */
		public V setValue(V value)
		{
			V old = getValue();
			this.value = value;
			return old;
		}
		
		/**
		 * A String representation of an Entry
		 * 
		 * @return The String representation of an Entry
		 */
		public String toString()
		{
			return key.toString() + " = " + value.toString();
		}
	}
}