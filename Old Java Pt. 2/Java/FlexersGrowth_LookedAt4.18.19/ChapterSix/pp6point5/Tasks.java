package pp6point5;

public class Tasks implements Priority {
	
	/**
	 * This class teaches us what "static" does:
	 * 	- In this case, it refers for ALL objects.
	 *  - If static variable increases, it affects all the
	 *    other objects as well.
	 */
	
	public String task;
	public static int firstPriorityID = 0;
	public int firstPriority;
	
	
	public Tasks(String str) {
		
		task = str;
		
		firstPriority = firstPriorityID++;
	}

	public void setPriority(int arg) {
		firstPriority = arg;
	}

	public int getPriority() {
		return firstPriority;
	}

	public String toString() {
		return task + ":" + firstPriority;
	}
}
