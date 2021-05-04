package z_hackerRank_problems;

import java.util.*;

public class o_luckBalance {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nk = scan.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] contests = new int[n][2]; // [row][col]
        for(int i = 0; i < n; i++) {
            String[] rowItems = scan.nextLine().split(" ");

            for(int j = 0; j < 2; j++) {
                int rowItem = Integer.parseInt(rowItems[j]);
                contests[i][j] = rowItem;
            }
        }
        int result = luckBalance(k, contests);
        System.out.println(result);
    }
    // k = the amount of contests she can lose
    // contests = the data
    public static int luckBalance(int k, int[][] contests) {
        List<Integer> importantContests = new ArrayList<>();
        int total = 0;
        /*
         6 3
         5 1
         2 1
         1 1
         8 1
         10 0
         5 0
         total = 31
         can NOT lose more than 3 important contests
         1 -> 2 -> 5 -> 8 -> null | when sorted

         */

        // Logic: add all | if the contest is important add it to the list
        //        sort the list -> this will give us the least value that we can fail on purposes
        //        contests.size() - k : explanation -> how many contests we can fail, if one, you must do size-k!
        //        total -= lose * 2 : explanation -> we have to subtract from the total, since we added we must subtract twice as to start at "zero"

        for (int[] contest : contests) {
            total += contest[0];

            // if important contest add to list
            if (contest[1] == 1) {
                importantContests.add(contest[0]);
                // [5], [2], [1], [8] -> null
            }
        }

        Collections.sort(importantContests); // [1], [2], [5], [8] -> null

        for (int i = 0; i < importantContests.size() - k; i++) {
            int lose = importantContests.get(i);
            total -= lose * 2;
        }
        return total;
    }
}
