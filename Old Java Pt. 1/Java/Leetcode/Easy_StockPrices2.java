package Leetcode;

/**
 * THIS DOES NOT FOLLOW THE MINIMA , MAXIMA APPROACH
 *
 * this is a greedy algorithm that does NOT account for minima and maxProfit.
 * this is short term advances while long term uses Richard and I's code.
 *
 * Different Problem by all means.
 */


public class Easy_StockPrices2 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices){
        if(prices == null){ return 0; }
        if(prices.length == 1) { return 0; }

        final int SIZE = prices != null ? prices.length : 0;

        int minValue = SIZE == 0 ? 0 : prices[0],
                profit = 0,
                totalProfit = 0;

        for(int i=0; i<SIZE; i++){
            minValue = Math.min(prices[i], minValue);
            profit = Math.max(prices[i]-minValue, profit);

            // Added new steps, keep track of totalProfit
            if(profit > 0){
                totalProfit += profit;
                minValue = prices[i];
                profit = 0;
            }
        }
        return totalProfit;
    }

    public static int maxProfit2(int[] prices){
        if(prices == null){ return 0; }
        if(prices.length == 1) { return 0; }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;

    }

}
