public interface SearchTree<E>
{
	public boolean add(E object);
	public boolean contains(E object);
	public E find(E object);
	public E delete(E object);
	public boolean remove(E object);
}
