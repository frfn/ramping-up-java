package InterviewQuestions_2DArraysMatrixProblems;

public class Grade {

    public static void main(String[] args) {

        int[][] studentGrades = {
                {10, 8, 7, 9, 9},
                {7, 7, 9, 10, 10},
                {10, 8, 9, 3, 9},
                {2, 10, 10, 10, 10}
        };

        StudentGrade sg = new StudentGrade(studentGrades);
        System.out.println("Student Average " + sg.getStudentAvg(2));
        System.out.println("Student Best Grade: " + sg.getMaxGrade(2));
        System.out.println("Class Average: " + sg.getClassAverage(1));
        System.out.println("Class Best Grade: " + sg.getClassMaxGrade(1));

    }

    public static class StudentGrade {
        int[][] matrix;

        public StudentGrade(int[][] matrix){
            this.matrix = matrix;
        }

        public float getStudentAvg(int row){
            float studentAvg = 0;
            int[] studentGrades = matrix[row];
            for(float val: studentGrades) studentAvg += val;
            return studentAvg / studentGrades.length;
        }

        public float getMaxGrade(int row){
            float maxGrade = 0;
            int[] studentGrades = matrix[row];
            for(float val: studentGrades) maxGrade = val > maxGrade ? val : maxGrade;
            return maxGrade;
        }

        public float getClassAverage(int column){
            float classAverage = 0;
            for(int i = 0; i<matrix.length; i++){
                classAverage += matrix[i][column];
            }
            return classAverage / matrix.length;
        }

        public float getClassMaxGrade(int column){
            float maxGrade = 0;
            for(int i = 0; i<matrix.length; i++){
                maxGrade = matrix[i][column] > maxGrade ? matrix[i][column] : maxGrade;
            }
            return maxGrade;
        }
    }

}
