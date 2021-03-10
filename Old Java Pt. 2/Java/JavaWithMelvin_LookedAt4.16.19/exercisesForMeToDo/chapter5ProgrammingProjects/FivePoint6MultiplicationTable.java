package chapter5ProgrammingProjects;

//use for, for loop – create a multiplication table

//		1	2	3	...
//		2	4	6	...	
//		3	6	9	...

public class FivePoint6MultiplicationTable {
	
	static int horizontal = 12;
	static int vertical = 12;
	static int multiply;
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= vertical; i++) {
			
			for(int j = 1; j <= horizontal; j++) {
				
				multiply = i * j;
				System.out.print(multiply + "\t");
				
			}
		
			System.out.println();
			
			
		}
		
		
		
	}

}
