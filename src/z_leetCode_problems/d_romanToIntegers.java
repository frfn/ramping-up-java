package z_leetCode_problems;
import java.util.HashMap;

public class d_romanToIntegers {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCVI")); // 1996
    }
    public static int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int result = 0;
        result += roman.get(s.charAt(0));
        // compares the value upfront
        for (int i = 1; i < s.length(); ++i) {
            if (roman.get(s.charAt(i - 1)) < roman.get(s.charAt(i))) {
                result -= roman.get(s.charAt(i - 1));  // subtract what was added in the last loop (because the last value is used to subtract from the current one)
                result += roman.get(s.charAt(i)) - roman.get(s.charAt(i - 1));  // subtract value of last roman numeral from the current one, then add ro result
            } else {
                result += roman.get(s.charAt(i));   // just add value of current roman numeral to result (previous roman numeral doesn't affect this one)
            }
        }
        return result;
    }
}