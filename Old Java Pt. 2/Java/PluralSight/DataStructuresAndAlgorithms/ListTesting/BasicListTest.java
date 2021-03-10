package ListTesting;
import DataStructureList.BasicList;
public class BasicListTest {

	public static void main(String[] args) {
		
		CD cd1 = new CD("Title", "Artist", 0, 0);
		CD cd2 = new CD("Title", "Artist", 1, 1);
		CD cd3 = new CD("Title", "Artist", 2, 2);
		CD cd4 = new CD("Title", "Artist", 3, 3);
		CD cd5 = new CD("Title", "Artist", 4, 4);
		
		BasicList list = new BasicList();
		
		list.add(cd1);
		list.add(cd2);
		list.add(cd3);
		list.add(cd4);
		list.add(cd5);
		
		/*
		 * list.add(5); list.add(1); list.add(2); list.add(6); list.add(3); list.add(5);
		 * list.add(2); list.add(6);
		 */
		
		System.out.println(list);
		
		System.out.println(list.size());
		
		System.out.println(list.find(cd2));
		
		System.out.println(list.get(4));
		//System.out.println(list.size2());
		
		//list.test();
		
	}
	
}
