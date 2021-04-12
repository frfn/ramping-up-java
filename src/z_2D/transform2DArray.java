package z_2D;

import java.util.Arrays;

public class transform2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };

        /*
            {1, 2, 3, 4} temp
            {1, 2, 3, 4}
            {0, 0, 0, 0}
            {0, 0, 0, 0}

            {1, 1, 1, 1}, matrix
            {2, 2, 2, 2},
            {3, 3, 3, 3},
            {4, 4, 4, 4}

            [1][3] for temp
            [3][1] for matrix
         */

        int[][] transformed = transform(matrix);

        for(int[] row: transformed) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] transform(int[][] matrix) {
        int[][] transformed = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                transformed[i][j] = matrix[j][i];
            }
        }
        return transformed;
    }

}
