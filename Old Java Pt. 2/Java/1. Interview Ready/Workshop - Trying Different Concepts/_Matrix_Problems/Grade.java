package _Matrix_Problems;

public class Grade {
	
	// this is a field, a 2D array, called studentGrade
	int[][] studentGrade; 
	
	public Grade(int[][] matrix) {
		studentGrade = matrix;
	}
	
	// returns avg for student
	public float calStudentAvg(int row) {
		float studentAvg = 0;
		int[] studentGrades = studentGrade[row];
		for(int val: studentGrades) studentAvg += val;
		return studentAvg / studentGrades.length;
	}
	
	// returns max grade for student
	public int maxStudentGrade(int row) {
		int maxGrade = 0;
		int[] studentGrades = studentGrade[row];
		for(int val: studentGrades) {
			if(val > maxGrade) maxGrade = val;
		}
		return maxGrade;
	}
	
	// returns the class avg
	public float calClassAvg(int column) {
		float classAverage = 0;
		for(int i = 0; i < studentGrade.length; i++) {
			classAverage += studentGrade[i][column];
		}
		return classAverage / studentGrade.length;
	}
	
	// returns the max grade for certain class
	public int maxClassGrade(int column) {
		int maxClass = 0;
		for(int i = 0; i < studentGrade.length; i++) {
			if(studentGrade[i][column] > maxClass) {
				maxClass = studentGrade[i][column];
			}
		}
		return maxClass;
	}
}
