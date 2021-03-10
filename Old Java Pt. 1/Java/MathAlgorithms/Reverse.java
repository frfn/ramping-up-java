package MathAlgorithms;

/*
    Does not handle negative numbers, look at second method and third method for overflow!
    It's nice to have one liners, but not readable. Even for me!

    Hot Spot:
    while (num != 0)
        lastDigit = num % 10;
        reverse = reverse * 10 + lastDigit;
        num /= 10;

    IF OVERFLOW:
    if ((newResult - tail) / 10 != result){
            { return 0; }
    }

 */

public class Reverse {

    public static void main(String[] args) {
        int reverse = reverse(-123);
        System.out.println(reverse);

//        int reverse2= Easy_reverseInteger(-123);
//        System.out.println(reverse2);
    }

    public static int reverseInt(int num){

        int lastDigit, reverse = 0;

        do{
            lastDigit = num % 10;  // breaks down the number for the last digit
            reverse = (reverse * 10) + lastDigit;  // reverse * 10 so that we can add last digit to the 'last' spot
            num = num / 10;  // breaks down the number with int division, truncating the decimal, giving us next value
        }while(num > 0);

        return reverse;
    }
    public static int reverseInteger(int num){
        int reverse = 0;

        while (num != 0) {
            reverse = (reverse * 10) + num % 10;
            num /= 10;
        }

        return reverse;
    }
    public static int reverse(int x) {
        int reverse = 0,
                lastDigit=0,
                check=0;

        while (x != 0){
            lastDigit = x % 10;  // gets last digit

            // we assigned here because we check if the answer, is supposed to be the answer
            // overflow changes the answer, so if its not the same, return 0;
            check = (reverse * 10) + lastDigit;

            // check if changed, reverse that equation above, and see if it still equals reverse!
            if((check - lastDigit) / 10 != reverse) {
                return 0;
            }

            // assign
            reverse = check;

            // next number
            x /= 10;
        }
        return reverse;
    }
}
