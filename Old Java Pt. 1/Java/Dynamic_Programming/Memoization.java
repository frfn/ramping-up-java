package Dynamic_Programming;

/**
 * To understand -- just draw the diagram :)
 */

public class Memoization {

    public static void main(String[] args) {

        int fibCount = 5;
        int[] memo = new int[fibCount + 1];  // memo always needs to be incremented by one

        System.out.println(fibValue(fibCount, memo));
    }

    public static int fibValue(int num, int[] memo){

        int value;
        if(memo[num] != 0){
            return memo[num];
        }

        if(num <= 2){
            value = 1;
        }
        else{
            value = fibValue(num-1, memo) + fibValue(num-2, memo);
            memo[num] = value;
            return value;
        }

        return value;
    }

}
