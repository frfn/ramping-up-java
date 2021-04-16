package z_leetCode_problems;

/*
    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    return  3 4 5
    0 1 1 2 3 5 8
 */


public class r_stairCase {

    public static void main(String[] args) {
        int stairTop = 6;
        int[] memo = new int[stairTop + 1];
        // System.out.println(stairCaseMemo(memo, stairTop));

        System.out.println(stairCaseBottomUp(5));
    }

    public static int stairCaseMemo(int[] memo, int n) {
        if(n <= 2) return n;
        if(memo[n] != 0) return memo[n];

        int fibValue = stairCaseMemo(memo, n-1) + stairCaseMemo(memo, n-2);
        memo[n] = fibValue;
        return fibValue;
    }

    public static int stairCaseBottomUp(int n) {
        if(n <= 2) return n;

        int[] bottomUp = new int[n+1];
        bottomUp[1] = 1;
        bottomUp[2] = 1;

        for(int i = 3; i < bottomUp.length; i++) {
            bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
        }

        return bottomUp[n];
    }


}
