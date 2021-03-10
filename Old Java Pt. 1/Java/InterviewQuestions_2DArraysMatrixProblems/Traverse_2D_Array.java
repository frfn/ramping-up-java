package InterviewQuestions_2DArraysMatrixProblems;

public class Traverse_2D_Array {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {2, 4, 6, 8, 10},
                {3, 6, 9, 12, 15}
        };

        print(matrix);

    }
    public static void print(int[][] matrix){
        if(matrix == null){
            System.out.println("Not matrix");
        }
        else {
            for(int[] row: matrix){
                for(int value: row){
                    System.out.print(value + ", ");
                }
                System.out.println();
            }
        }

    }
}
