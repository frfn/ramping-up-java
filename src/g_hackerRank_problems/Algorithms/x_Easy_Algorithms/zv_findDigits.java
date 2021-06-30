package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zv_findDigits {

    public static void main(String[] args) {
        System.out.println(findDigits(1012));
    }

    public static int findDigits(int n) {

        int count = 0;
        final int compareThis = n;

        // 1012

        while(n != 0) {
            int lastDigit = n % 10; // 2


            if(lastDigit != 0 && compareThis % lastDigit == 0) count++;
            n /= 10;
        }

        return count;

    }

}
