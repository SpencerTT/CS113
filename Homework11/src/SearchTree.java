/**
 * SearchTree.java : An interface that sets up the necessary methods for a SearchTree
 * 
 * @author Spencer Thompson
 * @version 1.0
 *
 */
public interface SearchTree<E>
{
	/**
	 * Tries to add object to the tree
	 * 
	 * @param object the item to add to the tree
	 * @return true if added, false if not
	 */
	public boolean add(E object);
	/**
	 * Determines if object is in the tree
	 * 
	 * @param object the item to check for
	 * @return true if find(object) != null
	 */
	public boolean contains(E object);
	/**
	 * Finds the object in the tree and returns it if found, null if not
	 * 
	 * @param object the item to search for in the tree
	 * @return object if found, null if not found
	 */
	public E find(E object);
	/**
	 * Tries to delete object from the tree
	 * 
	 * @param object the item to delete
	 * @return object if found, null if not found
	 */
	public E delete(E object);
	/**
	 * Returns delete(object) != null
	 * 
	 * @param object the item to remove
	 * @return delete(object) != null
	 */
	public boolean remove(E object);
}