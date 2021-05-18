package e_2D;

import java.util.Arrays;
import java.util.Scanner;

// similar to List<List<Integer>> :)
public class iterateThrough2DArray {

    public static void main(String[] args) {
        final int ROW_SIZE = 3;
        final int COLUMN_SIZE = 3;

        int[][] twoDee = new int[ROW_SIZE][COLUMN_SIZE];
        System.out.println(twoDee.length);

        Scanner s = new Scanner(System.in);

        for(int row = 0; row < twoDee.length; row++) {
            for(int indexInRow = 0; indexInRow < twoDee[row].length; indexInRow++) {
                System.out.println("You're in row " + row + ", you're at index " + indexInRow + ", enter value!");
                twoDee[row][indexInRow] = s.nextInt();
            }
        }

        for(int[] row: twoDee){
            System.out.println(Arrays.toString(row));
        }
    }
}
