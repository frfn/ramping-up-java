package _Matrix_Problems;

public class Traverse {
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{10, 3, 4, 6, 10},
				{3, 6, 10, 4, 10},
				{10, 4, 7, 6, 5},
				{10, 20, 10, 5, 3}
		};
		
		for(int[] row: matrix) {
			for(int value: row) {
				System.out.print(value + ", ");
			}
			System.out.println();
		}
		
	}

}
