package f_recursion.examples;

// First step, think of base case.

public class RecursionExamples {

    public static void main(String[] args) {
        Factorial example = new Factorial(4);
        System.out.println(example.getValue());

    }
}

class Factorial {

    private final int value;

    public Factorial(int num) {
         value = factorial(num);
    }

    public int getValue() { return value; }

    public static int factorial(int num) {
        if(num == 1) return 1;
//        System.out.println("Current Parameter: "+num);

        int val = num * factorial(num-1);

//        System.out.println("Current Value: "+val);

        return val;
    }
}
