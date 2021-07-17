package i_otherInterviewQuestionResources.crackingTheCodingInterview.readingQuestion;

import java.util.HashMap;

public class a_findPermutationInString {

    public static void main(String[] args) {
        System.out.println(findingPermutation("abbc", "cbabadcbbabbcbabaabccbabc"));
    }

    public static int findingPermutation(String a, String b) {
        if(a.length() == 0 || b.length() == 0) return 0; // if one of them are empty return 0

        int count = 0; // does it have permutation in length?

        // logic: store string a in hashmap to be used for comparison of letters
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> tempMap;

        for(char letter : a.toCharArray()) {
            int freq = map.getOrDefault(letter, 0);
            map.put(letter, freq + 1);
        }


        for(int i = 0; i < b.length(); i++) {

            // this is how you create a copy of a hashmap
            tempMap = new HashMap<>(map);

            if(i + a.length() > b.length()) break;

            for(int j = i; j < i + a.length(); j++) {

                if(tempMap.containsKey(b.charAt(j))) {
                    tempMap.put(b.charAt(j), tempMap.get(b.charAt(j)) - 1);
                    if (tempMap.get(b.charAt(j)) < 0) break;
                }
            }

            // why abs value? ... because I got screwed over with one being -1, and one as 1, so add those up = 0 ... not the value we expect!
            int freqInStringB = 0;
            for(int value: tempMap.values()) {
                freqInStringB += Math.abs(value);
            }

            if(freqInStringB == 0) count++;

        }

        return count;
    }

}
