package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class y_subArrayDivision {

    public static void main(String[] args) {
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(1);
        b.add(3);
        b.add(2);

        System.out.println(birthday(b, 3, 2));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;

        // O(n^2)

        for(int i = 0; i < s.size(); i++) {

            if(i + m > s.size()) break;

            int runningSum = 0;

            for(int j = i; j < i + m; j++) { // i = 4 --> j < 6
                runningSum += s.get(j);

                if(j == i + m - 1 && runningSum == d) count++; // it must be a pair, you cannot JUST have one bar.
            }

        }
        return count;
    }




}
