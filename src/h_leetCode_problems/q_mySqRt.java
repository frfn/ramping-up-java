package h_leetCode_problems;

public class q_mySqRt {

    // you're looking in a sorted list, 1, 2, 3, 4, etc... you can use binary search!

    public static void main(String[] args) {
        System.out.println(binarySearch(25));
    }

    /*

    Easy to understand explanation!

    - I also made it easier to read! How it should be read :)

    1. Binary approach! Why? Counting from 1 to n is sorted!

    2. Left - 1 because we increase left to get out of while loop!

     */

    public static int binarySearch(int x) {
        if(x < 2) return x;

        int left = 2;
        int right = x / 2; // divide by two, kickstarting the logic as well as handling overflowed numbers!
        while(left <= right) {
            int middle = (left + right) / 2;

            long result = (long) middle * middle; // evaluation

            if(result == x) {
                return middle;
            }
            else if (result < x ){
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return left - 1; // left will be greater, that is expected!
    }

    public static int mySqRt(int x) {
            long counter = 1;

            while(counter <= x) {
                if(counter * counter > x) {
                    return (int)counter - 1;
                }
                counter++;
            }
            return (int)counter - 1;
    }

}
