package g_hackerRank_problems.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class w_betweenTwoSets {

    /*
    - multiples of array A
    - factors of array B

    1. find common multiples of A ( Least Common Multiple => LCM )

    2. find the greatest common divisor of B ( Greatest Common Divisor => GCD )

    This makes sense after trying to make sense of it.

    This was difficult.

    https://www.youtube.com/watch?v=-c_V4fQ2mKU
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;

        // Get LCM of all elements of A
        int lcm = a.get(0);
        for (Integer integer : a) {
            lcm = getLCM(lcm, integer); // first value because that will be probably the least common multiple
        }

        // Get GCD of all elements of B
        int gcd = b.get(0);
        for (Integer integer : b) {
            gcd = getGCD(gcd, integer);
        }

        // Count multiples of lcm that divide the gcd
        int multiple = 0;
        while (multiple <= gcd) {
            multiple += lcm;

            if (gcd % multiple == 0)
                result++;
        }

        return result;
    }

    // All these are math equations ... so ... umm, you don't need to optimize or learn this.
    public static int getLCM(int num1, int num2) {
        if (num1 == 0 || num2 == 0)
            return 0;
        else {
            int gcd = getGCD(num1, num2);
            return Math.abs(num1 * num2) / gcd;
        }
    }

    public static int getGCD(int num1, int num2) { // 24 | 32
        if(num2 == 0) { // once it becomes it divisible, you found the GCD
            return num1;
        }
        return getGCD(num2, num1 % num2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        System.out.print("Enter numbers to consider: ");
        int numbersToConsider = Integer.parseInt(br.readLine().trim());

        System.out.print("Enter numbers that will be considered: ");
        int numbersThatAreConsidered = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < numbersToConsider; i++) {
            a.add(Integer.parseInt(br.readLine().trim()));
        }

        for(int i = 0; i < numbersThatAreConsidered; i++) {
            b.add(Integer.parseInt(br.readLine().trim()));
        }

        br.close();


        System.out.println(getTotalX(a, b));

    }

}
