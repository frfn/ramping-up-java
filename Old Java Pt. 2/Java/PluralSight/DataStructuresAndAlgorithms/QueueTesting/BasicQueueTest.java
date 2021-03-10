package QueueTesting;
import DataStructureQueue.BasicQueue;
public class BasicQueueTest {
	
	static BasicQueue<Couples> listOfCouples = new BasicQueue<Couples>();
	
	public static void main(String[] args) {
		BasicQueueTest app = new BasicQueueTest();
		app.runList();
		
		System.out.println(listOfCouples);
		
		//listOfCouples.dequeue();
		
		System.out.println(listOfCouples);
		
		Couples access = listOfCouples.access(0);
		System.out.println(access);
	}
	
	public void runList() {
		loadList();
	}
	
	public void loadList() {
		Couples defaultCouples = new Couples();
		Couples couple1 = new Couples("Flexer", "Nicole");
		Couples couple2 = new Couples("Hanah", "Andrew");
		
		listOfCouples.enqueue(defaultCouples);
		listOfCouples.enqueue(couple1);
		listOfCouples.enqueue(couple2);
	}

	/**
	 * 
	 * @author Flexer
	 *
	 * Couples class inside Main class
	 */
	public class Couples {
		
		private String name1, name2;
		
		public Couples() {
			this("N/A", "N/A");
		}
		
		public Couples(String name1, String name2) {
			this.name1 = name1;
			this.name2 = name2;
		}
		
		public String toString() {
			return "Couples: " + name1 + ":" + name2 + "\n";
	
		}
		
	}
	
}

	