package g_hackerRank_problems.Easy;

import java.util.HashMap;

public class l_makingAnagrams {

    public static void main(String[] args) {
        System.out.println(creatingAnagrams("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }

    public static int creatingAnagrams(String word, String otherWord) {

        // hash map to keep the count of letters
        HashMap<Character, Integer> map = new HashMap<>();

        /*
        for( char ch: first.toCharArray() ) {
            int ct = count.containsKey(ch) ? count.get(ch) : 0;
            count.put(ch, (ct + 1));
        }

        for( char ch: second.toCharArray() ) {
            int ct = count.containsKey(ch) ? count.get(ch) : 0;
            count.put(ch, (ct - 1));
        }
         */

        // billion
        // hello

        /*
        map
        b: 1
        i: 2
        l: 2
        o: 1
        n: 1
        */

        // to 'cancel' out

        /*
        hello
        h: -1
        e: -1
        --
        b: 1
        i: 2
        l: 0
        o: 0
        n: 1

        so the zero's are the 'cancelled' out letters that WILL be the anagram
         */
        for(char letter: word.toCharArray()) {
            if(map.containsKey(letter)) {
                map.put(letter, map.get(letter) + 1);
            }
            else {
                map.put(letter, 1);
            }
        }

        System.out.println(map);

        // iterating through the other word
        // the logic here is that it subtracts so it can cancel out the other letters, if value is 0, those are the letters we want
        for(char letter: otherWord.toCharArray()) {
            if(map.containsKey(letter)) {
                map.put(letter, map.get(letter) - 1);
            }
            else {
                map.put(letter, -1); // does not matter, we will add with absolute value!
            }
        }

        System.out.println(map);

        int totalValue = 0;

        for(int value: map.values()) {
            totalValue += Math.abs(value);
        }

        // fcrxzwscanmligyxyvym
        // jxwtrhvujlmrpdoqbisbwhmgpmeoke


        return totalValue; // you're returning how many characters are being deleted

    }

}
