package ProgrammingProject1;

public class Main {
	
	public static void main(String[] args) {
		
		CDLinkedList list = new CDLinkedList();
		
		list.append("7 Rings", "Ariana Grande", 1, 1.99);
		list.append("God's Plan", "Drake", 2, 1.99);
		list.append("How Far I'll Go", "Moana", 3, 1.99);
		list.append("Burnin Up", "Jonas Brothers", 4, 1.99);
		list.append("I'm Yours", "Jason Mraz", 5, 1.99);
		list.append("Mistletoe", "Justin Bieber", 6, 1.99);
		
		System.out.println(list);
		
		list.delete(2);
		
		list.insert("Year 3000", "Jonas Brothers", 10, 1.49, 3);
		
		System.out.println();
		
		System.out.println(list);

		
		System.out.println("Amount of songs: " + list.length());
		
	}

}
