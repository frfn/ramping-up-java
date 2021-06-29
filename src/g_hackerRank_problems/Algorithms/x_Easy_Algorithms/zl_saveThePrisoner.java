package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zl_saveThePrisoner {

    public static void main(String[] args) {
        //352926151 380324688 94730870
        System.out.println(saveThePrisoner(3,7,3));
    }

    public static int saveThePrisoner(int n, int m, int s) {
        // sequential seats ... 0 , 1 , 2 , 3 , 4
        // n will be our max, once n is hit, restart to one

        int prisonerIndex = s;

        // n = 4
        // m = 6
        // s = 2
        // 0 1 2 3 4 5
        // 2 3 4 1 2 3

        for(int i = 1; i < m; i++) {
            if(prisonerIndex == n) {
                prisonerIndex = 1;
            } else {
                prisonerIndex++;
            }
        }

        return prisonerIndex;

        // return ((s - 1 + m - 1) % n) + 1; ==> this math equation is the same as the code above.
        // the s - 1 and m - 1 are there because the prisoner starts at Index 1, we start at 0.
        // More Math based.
    }

}
