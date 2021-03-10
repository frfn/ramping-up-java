package lockedBankAccount;

/**
 * 
 * @author Flexer
 * 
 * interfaces and abstract classes are later talked upon later in the chapter
 *  - coded as well
 *
 */

public interface Lockable {

	public void setKey(int key);
	public void lock(int key);
	public void unlock(int key);
	public boolean locked();
	
}
