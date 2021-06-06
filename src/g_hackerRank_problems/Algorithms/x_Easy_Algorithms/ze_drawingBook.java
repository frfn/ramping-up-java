package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class ze_drawingBook {

    public static void main(String[] args) {
        System.out.println(pageCount2(5, 4));
    }

    public static int pageCount(int n, int p) {
        // IS NOT correct, it DOES pass some test cases

        int counterFront = 0, counterBack = 0;

        for(int i = 1; i < n; i += 2) {
            if(p <= i) break;
            counterFront++;
        }

        // 1 23 45 67 ...

        for(int i = n; i >= 1; i -= 2) {
            if(p >= i || p == i - 1) break;
            counterBack++;
        }

        return Math.min(counterBack, counterFront);

    }

    public static int pageCount2(int n, int p) {

        int totalPageTurn = n / 2;
        int pageFront = p / 2;
        int backFront = totalPageTurn - pageFront;

        return Math.min(pageFront, backFront);

    }

}
