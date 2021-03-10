package Toast_Interview;

public class a_Recap {

    public static void main(String[] args) {
        long val = maxProfit(new long[]{1, 1, 1, 1, 2, 3, 1, 3, 3, 4, 5, 6, 5, 4, 10});
        System.out.println("Profit check, should be 9: " + val);

        String palindromeString = "  f..  .. L .. e ..  !@#$%^ e // .. l. f";
        System.out.println(isPalindrome(palindromeString));
    }

    public static long maxProfit(long[] prices){
        if(prices.length == 0 || prices == null) return 0;
        final int STEPS = 5;
        long minValue = prices != null ? prices[0] : 0,
                profit = 0;

        for(int i=0; i<prices.length; i++){
            if(i + STEPS == prices.length){
                return profit;
            }

            minValue = prices[i] < minValue ? prices[i] : minValue;
            profit = prices[i + STEPS] - minValue > profit ? prices[i + STEPS] - minValue : profit;
        }
        return profit;
    }

    public static boolean isPalindrome(String s){
        if(s == null) return false;
        if(s.length() == 0) return true;

        String filter = s.replaceAll("[^a-zA-Z]+", "").toLowerCase();

        for(int i=0; i<filter.length() / 2; i++){
            if(filter.charAt(i) != filter.charAt(filter.length() - 1 -i)){
                return false;
            }
        }

        return true;
    }

}
