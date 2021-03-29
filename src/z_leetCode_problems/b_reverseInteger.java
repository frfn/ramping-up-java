package z_leetCode_problems;

public class b_reverseInteger {

    public static void main(String[] args){
        System.out.println(reverse(534));
    }

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
