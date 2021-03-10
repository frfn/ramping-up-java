package Testings;

/*
 * Greedy Algorithm
 * 
 * What We Learned
	This one's a good example of the greedy ↴ approach in action. Greedy approaches are great because they're fast (usually just one pass through the input). But they don't work for every problem.

	How do you know if a problem will lend itself to a greedy approach? Best bet is to try it out and see if it works. Trying out a greedy approach should be one of the first ways you try to break down a new question.
	
	To try it on a new problem, start by asking yourself:
	
	"Suppose we could come up with the answer in one pass through the input, by simply updating the 'best answer so far' as we went. What additional values would we need to keep updated as we looked at each item in our input, in order to be able to update the 'best answer so far' in constant time?"
	
	In this case:
	
	The "best answer so far" is, of course, the max profit that we can get based on the prices we've seen so far.
	
	The "additional value" is the minimum price we've seen so far. If we keep that updated, we can use it to calculate the new max profit so far in constant time. The max profit is the larger of:
	
	The previous max profit
	The max profit we can get by selling now (the current price minus the minimum price seen so far)
	Try applying this greedy methodology to future questions.
	
	  public static int getMaxProfit(int[] stockPrices) {

    if (stockPrices.length < 2) {
        throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
    }

	    // we'll greedily update minPrice and maxProfit, so we initialize
	    // them to the first price and the first possible profit
    int minPrice = stockPrices[0];
    int maxProfit = stockPrices[1] - stockPrices[0];

	    // start at the second (index 1) time
	    // we can't sell at the first time, since we must buy first,
	    // and we can't buy and sell at the same time!
	    // if we started at index 0, we'd try to buy *and* sell at time 0.
	    // this would give a profit of 0, which is a problem if our
	    // maxProfit is supposed to be *negative*--we'd return 0.
    for (int i = 1; i < stockPrices.length; i++) {
        int currentPrice = stockPrices[i];

	        // see what our profit would be if we bought at the
	        // min price and sold at the current price
        int potentialProfit = currentPrice - minPrice;

        	// update maxProfit if we can do better
        maxProfit = Math.max(maxProfit, potentialProfit);

        	// update minPrice so it's always
        	// the lowest price we've seen so far
        minPrice = Math.min(minPrice, currentPrice);
    }

    return maxProfit;
	}
 */

public class maxProfit {
	
	public static void main(String[] args) {
    int[] arr = {10,7,5,8,11,9};
    
    int num = getMax(arr);
    
    System.out.println(num);
		
		
	}
	
	//greedy 1
	public static int getMax(int[] arr) {
		
		int minPrice, maxProfit;
		minPrice = arr[0];  // first number
		maxProfit = 0;  // no value yet
		
		for (int currentPrice : arr) {
			
			minPrice = Math.min(minPrice, currentPrice);  // KEEPING the smallest value, having it here will ALWAYS keep the potential positive because it compares it to each other and 
			// not subtract first.
			
			int potentialProfit = currentPrice - minPrice;  // CURRENT PRICE will 
			
			
			maxProfit = Math.max(maxProfit, potentialProfit);
		}
		
		return maxProfit;
		
	}
	
	// greedy 2
	public static int getMax2(int[] arr) {
		if(arr.length < 2) {
			throw new IllegalArgumentException("One element or less in array");
		}
		
		int minPrice, maxProfit;
		minPrice = arr[0];  // first number
		maxProfit = arr[1] - arr[2];  // first sell
		
		for (int currentPrice : arr) {
			
	
			
			int potentialProfit = currentPrice - minPrice;  // CURRENT PRICE will 
			
			
			maxProfit = Math.max(maxProfit, potentialProfit);
			
			minPrice = Math.min(minPrice, currentPrice);  // KEEPING the smallest value 
			
			// by moving the minPrice at the bottom, you can receive negative values
		}
		
		return maxProfit;
		
	}
	
}
