public interface Vector<T>{
	
	public int size();

	public void add(T elem);

	public boolean remove(T elem);

	public void remove(int loc);

	public T get(int loc);

	public boolean contains(T elem);

	public int indexOf(T elem);
}