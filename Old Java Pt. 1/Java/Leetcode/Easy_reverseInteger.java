package Leetcode;

public class Easy_reverseInteger {

    public static void main(String[] args) {
        int num = reverse(123);
        System.out.println(num);

        /*
         It does work with 0s, the algorithm multiples by 10. :)
         So 1, 1*10= 10  <-- and finishes it off.
         */
    }

    public static int reverse(int number){
        int lastDigit = 0,
                reverse = 0,
                check = 0;

        while(number != 0){
            lastDigit = number % 10;
            check = (reverse * 10) + lastDigit;

            // handles overflow
            if((check - lastDigit) / 10 != reverse){
                return 0;
            }
            reverse = check;
            number /= 10;
        }
        return reverse;
    }

}
