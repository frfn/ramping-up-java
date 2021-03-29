package z_leetCode_problems;

public class c_palindromeInteger {

    public static void main(String[]args){
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0 || x % 10 == 0 && x != 0) return false; // by having this condition, raises from 69% to 99%!
        int rev = 0;
        int originalX = x;

        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }

        return rev == originalX;

    }

}
