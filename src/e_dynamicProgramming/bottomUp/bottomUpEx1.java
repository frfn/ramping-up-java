package e_dynamicProgramming.bottomUp;

public class bottomUpEx1 {

    public static void main(String[] args) {
        System.out.println(fibonacciBottomUpApproach(6));
    }

    public static int fibonacciBottomUpApproach(int num) {
        //  0  1  2  3  4  5  6  - index
        // [0, 1, 1, 2, 3, 5, 8] - values
        //  1  2  3  4  5  6  7  - array length
        if(num == 0) {
            return 0;
        }

        if(num <= 2) {
            return 1;
        }

        // with this approach, take into account that we will be on the EXACT NUMBER
        // if num == 6
        // new int[6+1] = 7
        // [0, 1, 1, 2, 3, 5, 8]
        int[] fibonacci = new int[num + 1];
        fibonacci[1] = 1;
        fibonacci[2] = 1;

        // length = 7
        for(int i = 3; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        return fibonacci[num];
    }

}
