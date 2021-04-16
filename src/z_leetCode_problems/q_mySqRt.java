package z_leetCode_problems;

public class q_mySqRt {

    // you're practically looking in a sorted list, you can use binary search!

    public static void main(String[] args) {
        System.out.println(binarySearch(69));
    }

    public static int binarySearch(int x) {
        if(x < 2) return x;

        int left = 2;
        int right = x / 2; // divide by two, kickstarting the logic as well as handling overflowed numbers!
        while(left <= right) {
            int middle = (left + right) / 2;

            long result = (long) middle * middle; // evaluation

            if(result > x) {
                right = middle - 1;
            }
            else if (result < x ){
                left = middle + 1;
            }
            else {
                return middle;
            }
        }
        return right; // at this point, right has been altered
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
