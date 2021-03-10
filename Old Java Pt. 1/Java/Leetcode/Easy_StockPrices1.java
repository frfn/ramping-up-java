package Leetcode;

public class Easy_StockPrices1 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7};
        long profit = maxProfit(prices);
        System.out.println(profit);
    }

    public static long maxProfit(int[] prices){
        if(prices == null){ return 0; }
        if(prices.length == 1) { return prices[0]; }

        final int SIZE = prices != null ? prices.length : 0;

        int minValue = SIZE == 0 ? 0 : prices[0],
            profit = 0;

        for(int i=0; i<SIZE; i++){
            minValue = Math.min(prices[i], minValue);
            profit = Math.max(prices[i]-minValue, profit);
        }
        return profit;
    }

}
