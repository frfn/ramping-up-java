package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.HashSet;
import java.util.Locale;

public class zo_pangrams {

    public static void main(String[] args) {

        // Test
        // int int_a = 97;
        // Character c_a = (char) int_a;

        System.out.println(pangram("abcdefghijklmnopqrstuvwxyz"));

    }

    // upgrade!
    public static String pangram(String s) {
        HashSet<Character> sSet = new HashSet<>();
        for(char letter: s.toCharArray()) {
            if(Character.isAlphabetic(letter)) {
                sSet.add(Character.toLowerCase(letter));
            }
        }

        return sSet.size() == 26 ? "pangram" : "not pangram";
    }

    public static String pangrams(String s) {
        HashSet<Character> abc = new HashSet<>();
        for(int i = 97; i <= 122; i++) {
            abc.add((char) i);
        }

        HashSet<Character> sSet = new HashSet<>();
        for(char letter: s.toLowerCase().toCharArray()) {
            sSet.add(letter);
        }

        for(char alphabet: abc) {
            if(!sSet.contains(alphabet)) return "not pangram";
        }

        return "pangram";
    }

}
