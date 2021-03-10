package Leetcode;

public class Easy_SqRt_Binary_REVISIT {

    public static void main(String[] args) {
        int num = mySqrt(49);
        System.out.println(num);
    }

    public static int mySqrt(int x) {
        if(x < 2){
            return x;
        }

        long start = 0;
        long end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (int)start;
    }

}
