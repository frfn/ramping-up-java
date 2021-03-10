package DataStructureList;

/**
 * 
 * @author Flexer
 *
 * @param <X> - just means, ANY value! 
 */

public interface ListInterface<X> {

	public void add(X data);
	public X delete();
	public int size();
	public void insert(X data, int position);
	public X removeAt(int position);
	public X find(X data);
	public X get(int position);
	
}
