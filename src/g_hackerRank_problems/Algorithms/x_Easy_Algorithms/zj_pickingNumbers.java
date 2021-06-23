package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class zj_pickingNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();
        // 4 6 5 3 3 1 , 6 numbers
        for(int i = 0; i < 6; i++) {
            l.add(scan.nextInt());
        }
        System.out.println(pN2(l));


    }

    // O ( n ^ 2 * log n)
    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a); // log n
        int longestSubArray = 0;
        int count = 0;

        for(int i = 0; i < a.size(); i++) {

            for(int j = i + 1; j < a.size(); j++) {

                if(Math.abs(a.get(i) - a.get(j)) <= 1) {
                    count++;
                    longestSubArray = Math.max(longestSubArray, count);
                }
            }
            count = 0;
        }

        return longestSubArray + 1;
    }

    public static int pN2(List<Integer> a) {
        // An array of zeroes
        int[] frequency = new int[100 + 1];

        // Fill array so that the value at each index corresponds to the number of occurrences of that integer
        for (Integer integer : a) {
            frequency[integer]++;
        }

        // Determine which pair of adjacent integers has the highest number of occurrences
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            int count = frequency[i] + frequency[i - 1];
            if (count > max) {
                max = count;
            }
        }

        return max;
    }


}
