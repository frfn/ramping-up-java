package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zq_viralAdvertising {

    public static void main(String[] args) {
        System.out.println(viralAdvertising(5));
    }

    public static int viralAdvertising(int n) {int cumulatitve = 0;
        int people = 5;

        for(int i = 0; i < n; i++) {
            int likes = people / 2;
            cumulatitve += likes;
            people = likes * 3;
        }
        return cumulatitve;

    }

}
