package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class zzk_happyLadyBugs {

    public static void main(String[] args) {
        happyBugs("AABBC");
    }

    public static void happyBugs(String b) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: b.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        /* -- CHECK 1. -- */
        // sees string is happy with NO SPACES | "YYRBRB"
        if(!map.containsKey('_')) {
            /* sorting, if it has empty space */
            char[] letters = b.toCharArray();
            int occurrences = 1;
            for(int i = 0; i < b.length() - 1; i++) {
                boolean sameLetter = letters[i] == letters[i + 1];
                if(sameLetter) {
                    occurrences++;
                }
                if(!sameLetter) {
                    if(occurrences == 1) {
                        System.out.println("NO");
                        return;
                    }
                    occurrences = 1;
                }
            }
            if(map.get(letters[letters.length - 1]) == 1) {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            return;
        }
        // we distinguished if the String is a happy string


        /* -- CHECK 2. -- */
        // sees if there is 1 value..
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            // skip the _ char
            if(entry.getKey() == '_') {
                continue;
            }
            // if any of the letters are value of 1 ... it's false right away
            if (entry.getValue() == 1) {
                System.out.println("NO");
                return;
            }
        }

        /* -- CHECK 3. -- */
        // if it contains a space | sorting, if it has empty space
        boolean happy = true;
        if(map.containsKey('_')) {
            char[] letters = b.toCharArray();
            Arrays.sort(letters);
            int occurrences = 1;
            for(int i = 0; i < letters.length - 1; i++) {
                boolean sameLetter = letters[i] == letters[i + 1];
                if(sameLetter) {
                    occurrences++;
                }
                if(!sameLetter) {
                    if(occurrences == 1) {
                        happy = false;
                    }
                    occurrences = 1;
                }
            }
        }

        if(happy) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
