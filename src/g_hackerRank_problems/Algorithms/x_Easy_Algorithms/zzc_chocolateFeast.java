package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zzc_chocolateFeast {

    public static void main(String[] args) {
        System.out.println(chocolateFeast(10,2,5));
    }

    public static int chocolateFeast(int n, int c, int m) {

        int remainderOfWrapper = 0;
        int totalBarsEaten = 0;
        int totalBars = n / c; // 5

        while(totalBars > 0) {
            totalBarsEaten += totalBars; // 5
            remainderOfWrapper += totalBars; // 5

            totalBars = remainderOfWrapper / m; // 2
            remainderOfWrapper = remainderOfWrapper % m; // 1
        }

        return totalBarsEaten;

    }

}
