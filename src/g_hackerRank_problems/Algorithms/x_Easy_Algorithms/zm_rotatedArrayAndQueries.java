package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

this was a little difficult.

Couldn't solve all the test cases. SMH.

https://www.hackerrank.com/challenges/circular-array-rotation/problem

 */

public class zm_rotatedArrayAndQueries {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            a.add(scan.nextInt());
        }

        List<Integer> queries = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            queries.add(scan.nextInt());
        }

        int k = 2;

        for(int num: circularArrayRotation(a, k, queries)) {
            System.out.print(num + ", ");
        }

    }

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {

        // index = 0 1 2
        // value = 3 4 5
        // rotated @ 2 = 4 5 3

        int index = 0;
        int[] rotated = new int[a.size()];

        if(k != 0) {
            for(int i = k; i < a.size(); i++) {
                rotated[index++] = a.get(i);
            }
        }
        for(int i = 0; i < k; i++) {
            rotated[index++] = a.get(i);
        }

        List<Integer> valuesToReturn = new ArrayList<>();

        for(int indexForQuery: queries) {
            valuesToReturn.add(rotated[indexForQuery]);
        }

        return valuesToReturn;

    }


}
