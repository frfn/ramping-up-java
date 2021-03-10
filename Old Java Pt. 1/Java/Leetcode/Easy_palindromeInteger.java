package Leetcode;

public class Easy_palindromeInteger {

    public static void main(String[] args){

        System.out.println(palindrome(10201));

    }

    public static boolean palindrome(int number){
        Easy_reverseInteger obj = new Easy_reverseInteger();
        int rev = obj.reverse(number);
        System.out.println(rev);

        return number == rev ? true : false;
    }

}
