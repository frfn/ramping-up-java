package g_hackerRank_problems.Easy;

import java.util.HashMap;

// Good job!
public class i_ransomNoteHashMap {
    public static void main(String[] args) {
        String[] mag = new String[] {"two", "times", "three", "is", "not", "four"};
        String[] note = new String[] {"two", "times", "is", "four"};
        wordFrequency(mag, note);
    }

    public static void wordFrequency(String[] magazine, String[] noteToBeCreated) {
        if(magazine.length == 0) System.out.println("No magazine words!");

        HashMap<String, Integer> collection = new HashMap<>();

        for(String word: magazine) {
            int count = collection.getOrDefault(word, 0); // collection.contains(word) ? collection.get(word) : 0;
            collection.put(word, count + 1);
        }

        for(String word: noteToBeCreated) {
            if(!collection.containsKey(word)) {
                System.out.println("Note not created!");
                return;
            } else {
                int count = collection.get(word) - 1;
                collection.put(word, count);

                if(count == 0) {
                    collection.remove(word);
                }
            }
        }
        System.out.println("Note created!");
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
