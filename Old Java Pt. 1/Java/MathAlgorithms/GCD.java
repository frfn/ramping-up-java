package MathAlgorithms;

public class GCD {

    public static void main(String[] args) {
        System.out.println(gcd(10, 45));
    }

    public static int gcd(int num, int num2) {
        return num2 > 0 ? gcd(num2, num % num2) : num;
    }

}
