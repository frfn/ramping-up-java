package h_leetCode_problems;
import java.util.ArrayList;
import java.util.List;

public class e_LongestCommonPrefix {


    public static void main(String[] args) {
        System.out.println(vScan(new String[] {"leetcode", "leetco", "leetcheetah"}));

        List<String> listOfSayings = new ArrayList<>();
        listOfSayings.add("The operator likes red");
        listOfSayings.add("The operator likes blue");
        listOfSayings.add("The operator likes green");

        System.out.println(cPW(listOfSayings));
    }

    /*

    Easy to understand explanation:

    1. We scan the first character of each letter.

    1a. Use the the first word as your base word.

    2. If we hit the length of a word that is the same as i, return

    3. if the character becomes different return,

    leetcode
    leetco
    leetcheetah

     */

    public static String commonPrefixWords(List<String> orders) {

        // filling in array -- just use get
        String[] ordersArray = new String[orders.size()];
        int index = 0;
        for(String order: orders) {
            ordersArray[index++] = order;
        }

        // Start logic here...
        String basePhrase = ordersArray[0]; // first sentence

        for(int i = 0; i < basePhrase.length(); i++) {

            char letter = basePhrase.charAt(i); // grab the letter

            for(int j = 1; j < ordersArray.length; j++) { // hypothetically starts at next word

                if(i == ordersArray[j].length() || letter != ordersArray[j].charAt(i)) {
                    return basePhrase.substring(0, i);
                }

            }

        }

        return basePhrase;
    }

    public static String cPW(List<String> orders) {

        // Start logic here...
        String basePhrase = orders.get(0); // first sentence

        for(int i = 0; i < basePhrase.length(); i++) {

            char letter = basePhrase.charAt(i); // grab the letter

            for(int j = 1; j < orders.size(); j++) { // starts at next word

                if(i == orders.get(j).length() || letter != orders.get(j).charAt(i)) {
                    return basePhrase.substring(0, i);
                }

            }

        }

        return basePhrase;
    }

    public static String vScan(String[] words){
        String base = words[0];
        int i,j; i=j=0;

        while(i < base.length()) {
            char c = base.charAt(i);

            while(j < words.length) {
                if(words[j].length() == i || words[j].charAt(i) != c) return base.substring(0, i);
                j++;
            }

            j = 0; // restarting the index for j! I debugged and saw that J was stuck at 3 for the example.
            i++;   // continues because we go through the first word!
        }
        return base;
    }

    public static String commonPrefix(String[] words) {

        String baseWord = words[0];

        for(int i = 0; i < baseWord.length(); i++) {

            char letter = baseWord.charAt(i);

            for(int j = 1; j < words.length; j++) {
                // remember that in an OR expression that if the first statement is true, the second statement will not be evaluated!
                if(i == words[j].length() || words[j].charAt(i) != letter) {
                    return baseWord.substring(0, i);
                }
            }

        }
        return baseWord;
    }

}
