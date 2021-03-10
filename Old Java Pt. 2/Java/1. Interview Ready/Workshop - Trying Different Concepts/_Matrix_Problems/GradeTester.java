package _Matrix_Problems;

import java.util.Scanner;

public class GradeTester {
	
	public static void main(String[] args) {
		int[][] matrix = new int[4][5];
			
//			{
//				{10, 3, 4, 6, 10},
//				{3, 6, 10, 4, 10},
//				{10, 4, 7, 6, 5},
//				{10, 20, 10, 5, 3}
//		};
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println("Enter for grades for student " + i + ": ");
				matrix[i][j] = scan.nextInt();
			}
		}
		
		scan.close();
		
		// Note: For displaying purposes -- uses for each
		for(int[] row: matrix) {
			for(int value: row) {
				System.out.print(value + ", ");
			}
			System.out.println("\n");
		}
		
		// Created school object that takes in a 2D array
		Grade school = new Grade(matrix);
		
		// Testing out the methods
		// Note: Methods are NOT safe guarded, if there are special cases, may fail.
		System.out.println("Class Average for class 0: " + school.calClassAvg(0));
		System.out.println("Student Average for student 1: " + school.calStudentAvg(1));
		System.out.println("Class Max for class 2: " + school.maxClassGrade(2));
		System.out.println("Student Max for student 3: " + school.maxStudentGrade(3));
		
	}

}
