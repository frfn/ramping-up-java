package _Array_Problems;

public class StockPrices {
	
	public static void main(String[] args) {
		
		long[] arr = {12, 10, 7, 8, 6, 10, 12, 13};
		
		long val = maxProfit(arr);
		System.out.println(val);
		
		long val2 = maxProfit2(arr);
		System.out.println(val2);
		
	}

	/* Richard's way */
	public static long maxProfit(long[] prices) {
		
		final int MIN_DIFFERENCE = 5,
				  PRICES_SIZE = prices == null ? 0 : prices.length;
		
		long minima = PRICES_SIZE == 0 ? 0 : prices[0],
			 maxProfit = 0;
		
		// [10, 9, 1, 2, 12, 7]
		for(int i = MIN_DIFFERENCE; i < PRICES_SIZE; i++) {
			// this is how it increments, starts at prices[0]
			minima = Math.min(minima, prices[i - MIN_DIFFERENCE]); // returns the lowest value of the two
			
			// this is the calculation, returns the highest price 
			maxProfit = Math.max(maxProfit, prices[i] - minima); // returns the highest value of the two
		}
		
		
		return maxProfit;
	}
	
	public static long maxProfit2(long[] prices) {
		
		final int NUM_OF_STEPS = 5,
				  PRICES_SIZE = prices == null ? 0 : prices.length;
		
		
		long minima = PRICES_SIZE == 0 ? 0 : prices[0],
			 maxProfit = 0;
		
		for(int i = 0; i < prices.length; i++) {
			
			if(i + NUM_OF_STEPS == prices.length) {
				return maxProfit;
			}
			
			minima = prices[i] < minima ? prices[i] : minima;
			
			maxProfit = maxProfit < prices[i + NUM_OF_STEPS] - minima ? prices[i + NUM_OF_STEPS] - minima : maxProfit;
			
		}
		
		return maxProfit;
				  
		
		
	}

}
