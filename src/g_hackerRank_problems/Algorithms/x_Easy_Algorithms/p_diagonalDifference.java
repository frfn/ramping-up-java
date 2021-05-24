package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class p_diagonalDifference {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        List<Integer> two = new ArrayList<>();
        two.add(4);
        two.add(5);
        two.add(6);

        List<Integer> three = new ArrayList<>();
        three.add(9);
        three.add(8);
        three.add(9);

        list.add(one);
        list.add(two);
        list.add(three);

        System.out.println("Answer: "+diagonalDifference(list));



    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int[][] matrix = new int[arr.size()][arr.size()];
        int i, j; i=j=0;

        // seems like this is the best way to fill a matrix
        for(List<Integer> row : arr) {
            for(int item : row) {
                matrix[i][j] = item;
                j++;
            }
            j = 0;
            i++;
        }

        int firstValue = 0;
        int secondValue = 0;

        // this is so elegant, this is what I tried to aim for, though I did it, it was very rough.
        for(int index = 0; index < matrix.length; index++) {
            firstValue += matrix[index][index]; // [0][0] [1][1] [2][2]
            secondValue += matrix[index][matrix[index].length - 1 - index]; // [0][2] [1][1] [2][0]
        }

        return Math.abs(firstValue - secondValue);
    }
}
