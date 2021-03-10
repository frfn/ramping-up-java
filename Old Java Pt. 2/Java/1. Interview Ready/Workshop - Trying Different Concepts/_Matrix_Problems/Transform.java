package _Matrix_Problems;

public class Transform {
	
	public static void main(String[] args) {
		
		int[][] mat = {
				{1, 1, 1, 1},
				{2, 2, 2, 2},
				{3, 3, 3, 3},
		};
		
		for(int[] row: mat) {
			for(int val: row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		int[][] t = transpose(mat);
		
		System.out.println();
		
		for(int i=0; i<4;i++) {
			
			for(int j=0; j<3; j++) {
				
				System.out.print(t[i][j] + " ");
				
			}
			System.out.println();
		
		}
		
	}
	
	public static int[][] transpose(int[][] matrix){
		
		int[][] temp = new int[4][3];
		
		for(int i=0;i<4;i++){    
			for(int j=0;j<3;j++){    
				temp[i][j] = matrix[j][i];
			}    
		}   
		
		return temp;
		
		
	}
	
}
