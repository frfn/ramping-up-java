package z_leetCode_problems;

public class g_maxPrice {

    // Main
    public static void main(String[] args) {
        System.out.println(bestPriceToSell(new int[] {7,1,5,3,6,4}));
    }

    // best price if wait to sell
    public static int bestPriceToSell(int[] prices) {
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int price: prices) {
            min = Math.min(price, min); // price < min ? price : min;
            profit = Math.max(price - min, profit); // price - min > profit ? price - min : profit;
        }
        return profit;
    }

    // best price to multi sell
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int min = prices[0];
        int totalProfit = 0;

        for(int price: prices) {
            min = Math.min(price, min);

            if(price > min) {
                int profitPrice = price - min;
                totalProfit += profitPrice;
                min = price;
            }
        }
        return totalProfit;
    }
    /*
    same as above!
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }
    }
    */
}
