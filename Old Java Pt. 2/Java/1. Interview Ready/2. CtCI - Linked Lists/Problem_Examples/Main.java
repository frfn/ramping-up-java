package Problem_Examples;

public class Main {
	
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(10);
		ll.add(4);
		

		System.out.println(ll + " : " + ll.length);
		
		//Node newHead = ll.mergesort(ll.head);
		//ll.setHead(newHead);
		
		System.out.println();
		
		ll.partition(4);
		
		//System.out.println(ll + " : " + ll.length);
		
	}

}
