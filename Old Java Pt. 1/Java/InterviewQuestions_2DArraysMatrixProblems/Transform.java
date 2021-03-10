package InterviewQuestions_2DArraysMatrixProblems;

public class Transform {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };

        for(int[] row: matrix){
            for(int val: row){
                System.out.print(val + ", ");
            }
            System.out.println();
        }


        System.out.println("\n");
        int[][] transformed = transform(matrix);

        for(int[] row: transformed){
            for(int val: row){
                System.out.print(val + ", ");
            }
            System.out.println();
        }

    }

    /**
     *
     * @param matrix
     * @return
     *
     * For extra brownie points, code up where if length is OutOfBounds, move on!
     */
    public static int[][] transform(int[][] matrix){

        int[][] temp = new int[matrix[0].length][matrix.length];

        for(int i=0; i<temp[0].length; i++){
            for(int j=0; j<temp.length; j++){
                temp[i][j] = matrix[j][i];
                /**
                 * The way it works is amazing, [i][j] = [j][i], transforms with correct size
                 */
            }

        }
        return temp;
    }

}
