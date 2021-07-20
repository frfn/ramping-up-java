package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zzd_halloweenSale {

    public static void main(String[] args) {
        System.out.println(howManyGames(100,9,1,180));
    }

    public static int howManyGames(int p, int d, int m, int s) {
        /*
        "p" = dollars

        first game = "p"
        every game after is "d" less than the previous one
        continues until the game is less than or equal to "m"

        "s" our wallet :)

        How many games can you buy?

        20 subtract 3 till number becomes equals to or less than "m", than the rest will be "m"

        add from the beginning to end...
         */

        // 20 17 14 11 8 6 ...

        if(p > s) return 0;

        int runningSum = 0;
        int count = 0;

        while(runningSum < s) {
            if(p <= m) {
                if(runningSum + m > s) {
                    break;
                }
                runningSum += m;
            }

            else {
                if(runningSum + (p - d) > s) {
                    break;
                }
                runningSum += p;
                p -= d;
            }

            count++;
        }

        return count;

    }

}
