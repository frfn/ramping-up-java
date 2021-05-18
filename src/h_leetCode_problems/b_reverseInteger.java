package h_leetCode_problems;

public class b_reverseInteger {

    public static void main(String[] args){
        System.out.println(reverse(534));
    }

    /*

    Easy to understand explanation:

    by doing % 10, you are grabbing the last number ( the remainder! )

    by doing / 10, you are deleting the last number ( popping! )

    rev * 10 + pop, this algorithm sets up the previous number so it can be "ahead"
    543 --> 3 --> 30 + 4 = 34

    3 is "ahead" of 4.

     */

    public static int reverse(int x){
            int rev = 0;
            while (x != 0) {
                int pop = x % 10; // grabs the last number

                x /= 10; // alters the x

                /* these are just checks for overflows ... do you need it for interview.. no. */
                if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

                rev = rev * 10 + pop; // gives a base for number to be added!
            }
            return rev;
    }

}
