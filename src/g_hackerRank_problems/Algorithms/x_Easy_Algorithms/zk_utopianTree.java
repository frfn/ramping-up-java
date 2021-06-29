package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zk_utopianTree {

    public static void main(String[] args) {
        System.out.println(utopianTree(5));
    }

    public static int utopianTree(int n) {
        /*
            1, spring.
            Twice, summer
        */

        int height = 1;

        // 0 1 2 3 4 5
        // 1 2 3
        for(int i = 1; i <= n; i++) {
            if(i % 2 != 0) { // if not divisible by two
                height *= 2;
            }
            else {
                height++;
            }
        }

        return height;

    }

}
