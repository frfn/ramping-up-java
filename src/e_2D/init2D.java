package e_2D;

import java.util.Arrays;

public class init2D {

    public static void main(String[] args) {
        for(int[] row: jaggedArray()) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] jaggedArray() {

        // What is matrix.length == 4

        // can I make jagged arrays , yes.

        // there are others ways to create jagged arrays :)

        int[][] matrix = new int[4][];
        matrix[0] = new int[10];
        matrix[1] = new int[8];
        matrix[2] = new int[6];
        matrix[3] = new int[10];


        System.out.println("Matrix length: " + matrix.length);

        return matrix;

    }

}
