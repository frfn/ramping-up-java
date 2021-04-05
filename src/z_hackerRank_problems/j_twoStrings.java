package z_hackerRank_problems;

import java.util.HashMap;

public class j_twoStrings {

    public static void main(String[] args) {

    }

    // 2 for the for loop in the driver method, so iterate twice

    // hello
    // world

    // hi
    // world

    public static String twoStrings(String s1, String s2) {
        HashMap<Character, Integer> letterOccurrence = new HashMap<>();
        int commonLetters = 0;

        for(char c: s1.toCharArray()) {
            if(letterOccurrence.containsKey(c)) {
                letterOccurrence.put(c, letterOccurrence.get(c) + 1);
            }
            else{
                letterOccurrence.put(c, 1);
            }
        }

        for(char c: s2.toCharArray()) {
            if(letterOccurrence.containsKey(c)) {
                commonLetters++;
            }
        }

        return commonLetters > 0 ? "YES" : "NO";

    }

}
