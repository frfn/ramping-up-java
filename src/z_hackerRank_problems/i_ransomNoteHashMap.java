package z_hackerRank_problems;

import java.util.HashMap;

// Good job!
public class i_ransomNoteHashMap {
    public static void main(String[] args) {
        String[] mag = new String[] {"two", "times", "three", "is", "not", "four"};
        String[] note = new String[] {"two", "times", "two", "is", "four"};
        checkMagazine(mag, note);
    }
    // must have all letters from mag to be a note
    public static void checkMagazine(String[] magazine, String[] note) {
        if(magazine.length == 0) System.out.println("No");
        HashMap<String, Integer> magMap = new HashMap<>();
        {
            for(String word: magazine) {
                if(magMap.containsKey(word)){
                    magMap.put(word, magMap.get(word) + 1);
                } else {
                    magMap.put(word, 1);
                }
            }
        }
        for(String word: note) {
            if(!magMap.containsKey(word)) {
                System.out.println("No");
                return; // ends and terminates method
            } else {
                magMap.put(word, magMap.get(word) - 1);
                if(magMap.get(word) == 0) magMap.remove(word);
            }
        }
        System.out.println("Yes");
    }
}
