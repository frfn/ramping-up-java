package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class r_stairCasePrintPounds {

    public static void main(String[] args) {
        staircase(6);
    }

    public static void staircase(int n) {
        if(n == 0) return;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n - i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k <= i; k++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

}
