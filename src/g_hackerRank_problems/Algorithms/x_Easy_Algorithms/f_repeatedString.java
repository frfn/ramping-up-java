package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.HashMap;

public class f_repeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedStringV2("bcaa", 15));
    }

    // first take on problem!
    public static long repeatedString(String s, long n) {

        // First take ... getting better!
        if(s.length() == 1 && s.charAt(0) == 'a') {
            return n;
        }

        // NO GOOD. this will give us a timeout error. | just grab the number , multiply by two, grab the remainder, and loop through that!
        StringBuilder sb = new StringBuilder();
        while(sb.length() <= n) {
            sb.append(s); // we're constructing the string, which is NO good. // will give us timeout error.
        }

        HashMap<Character, Long> occurrence = new HashMap<>();
        char[] letters = sb.toString().toCharArray();
        for(int i = 0; i < n; i++) {
            if(occurrence.containsKey(letters[i])) {
                occurrence.put(letters[i], occurrence.get(letters[i]) + 1);
            }
            else {
                occurrence.put(letters[i], 1L);
            }
        }

        return occurrence.containsKey('a') ? occurrence.get('a') : 0;
    }

    // final solution! Very optimized | patterns!
    public static long repeatedStringV2(String s, long n) {
        if(!s.contains("a")) return 0;
        if(s.contains("a") && s.length() == 1) return n; // if input is "a" , n=15, will return 15!

        // 1. solve for repeat & remainder | repeat is how many times the string can fit inside the given length | remainder is what will be left to REACH the given length
        char[] string = s.toCharArray();
        long repeat = n / s.length(); // aba aba aba a | 10 / 3 = 3
        long rem = n % s.length(); // aba aba aba a | 10 % 3 = 1
        long count = 0;

        // 2. initially how many 'a' is in the string?
        for(int i = 0; i < s.length(); i++) {
            if(string[i] == 'a') {
                count++;
            }
        }

        // 3. multiply that by the repeat
        count = count * repeat; // this is optimized!

        // 4. if any remainders are left, for example, a is the remainder.
        for(int i = 0; i < rem; i++) {
            if(string[i] == 'a') {
                count++;
            }
        }

        return count;
    }

}
