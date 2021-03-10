package QueueTesting;
import DataStructureQueue.ListQueue;

public class ListStackTesting {

	static ListQueue<Couples> list = new ListQueue<Couples>();


	public static void main(String[] args) {
		
	
		
		ListStackTesting app = new ListStackTesting();
		app.loadList();
	
		System.out.println(list);
		
	}
	
	public void loadList() {
		Couples defaultCouples = new Couples();
		Couples couple1 = new Couples("Flexer", "Nicole");
		Couples couple2 = new Couples("Hanah", "Andrew");
		Couples newA = new Couples("Flex", "Cole");
		Couples newB = new Couples("Cole", "Flex");
		Couples newC = new Couples("Flexy", "Coley");
		Couples newD = new Couples("Flex1", "Cole2");
		
		list.enqueue(defaultCouples);
		list.enqueue(couple1);
		list.enqueue(couple2);
		list.enqueue(newA);
		list.enqueue(newB);
		list.enqueue(newC);
		list.enqueue(newD);
		
		System.out.println(list.contains(newD));
		System.out.println(list.access(2));  // let's FUCKING GO!
	}
	
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
			return "Couples: " + name1 + ":" + name2 + " | ";
		
		}
		
	}
	
}
