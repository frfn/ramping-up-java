package Toast_Interview;

public class StockPrices {
    public static void main(String[] args){
        long[] arr = {5, 3, 4, 6, 8, 10, 14, 13, 12, 9, 13, 15, 16, 18, 20};
        System.out.print(maxProfit(arr));
    }
    public static long maxProfit(long[] prices){

        final int SIZE = prices == null ? 0 : prices.length,
                  STEPS = 5;
        long maxProfit = 0,
             minima = SIZE == 0 ? 0 : prices[0];
        for (int i = 0; i < SIZE; i++) {

            if(i + STEPS == SIZE){
                return maxProfit;
            }
            // the minima will be 3 and be compared FIRST w/ 14. (14-3 = 11), 3 is now the minima, it will only change if prices[i] is SMALLER
            minima = prices[i] < minima ? prices[i] : minima;
            maxProfit = prices[i + STEPS] - minima > maxProfit ? prices[i + STEPS] - minima : maxProfit;

            /**
             * Richard's approach
             * for (int i=STEPS; i<prices.length; i++){
             *     minima = Math.min(prices[i - STEPS], minima);
             *     maxProfit = Math.max(prices[i] - minima, maxProfit);
             * }
             */
        }
        return maxProfit;
    }
}
