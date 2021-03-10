package InterviewQuestions_ArrayProblems;

public class StockPrice {

    public static void main(String[] args) {

        long[] arr = {0, 1, 2, 3, 4, 5};

        System.out.println(maxProfit(arr));

    }

    public static long maxProfit(long[] prices){
        if(prices == null || prices.length < 5){
            return 0;
        }

        final int STEPS = 5;

        long maxProf = 0,
             lowestValue = prices[0];

        for(int i=0; i<prices.length; i++){
            if(i + STEPS == prices.length){
                return maxProf;
            }

            lowestValue = prices[i] < lowestValue ? prices[i] : lowestValue;
            maxProf = prices[i + STEPS] - lowestValue > maxProf ? prices[i + STEPS] - lowestValue : maxProf;

        }

        return maxProf;

    }

}
