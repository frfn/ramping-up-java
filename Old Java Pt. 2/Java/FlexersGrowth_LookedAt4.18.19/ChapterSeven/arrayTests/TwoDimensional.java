package arrayTests;

public class TwoDimensional {
	
	public static void main(String[] args) {
		
		int multTable[][] = new int[4][5];
		
		System.out.println("Length of array: " + multTable.length); // length of array is 4, it is the rows
		
		
		
		/*
		 Row         -----     Column
		  ||					  ||
		  ||	|				  || ||
		  ||	|				  || || ||
		  ||	|				  ------------>
		  ||    V
		*/
		
		
		for(int row=1; row <multTable.length; row++) {
			
			//go through the 4 arrays
			
			for(int col=1; col < multTable[row].length; col++) {
				
				//through the 4 arrays, go through each array (it has 5 spaces in each array)
				
				multTable[row][col] = row * col;
				
				//this also fills HORIZONTALLY not vertically
				
				/**
				 * This makes sense!
				 * 
				 * [row][col] = row * col
				 * 
				 * at row 0, col 0 = 0 .... not a good example lol.
				 * 
				 * but row 2, col 1 = 2
				 * 	   row 3, col 1 = 3
				 * 	   row 4, col 1 = 4
				 * 
				 * 	   row 2, col 1 = 2
				 * 	   row 2, col 2 = 4
				 * 	   row 2, col 3 = 6
				 */
				
			}
			
		}
		
		for(int row=1; row <multTable.length; row++) {
			
			for(int col=1; col < multTable[row].length; col++) {
				
				System.out.print(multTable[row][col] + "\t");
				
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 1; i < 12; i++) {
			for(int j = 1; j < 12; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println();
		}
		
	}

}
