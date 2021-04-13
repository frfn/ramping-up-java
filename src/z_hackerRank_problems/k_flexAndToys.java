package z_hackerRank_problems;

import java.util.Arrays;

public class k_flexAndToys {

    // the idea here is that sometimes greedy algorithms do not work, you must sort it
    public static void main(String[] args) {
        System.out.println(howManyToys(new int[] {3, 100, 3, 5, 1, 4, 40}, 60));
    }
    public static int howManyToys(int[] prices, int budget) {
        Arrays.sort(prices);
        int counter, runningSum;
        counter=runningSum=0;
        for(int price: prices) {
            if(runningSum + price <= budget){
                runningSum += price;
                counter++;
            }

        }
        return counter;
    }

}
