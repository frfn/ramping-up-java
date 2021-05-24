package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.HashMap;

public class d_findFirstUniqueCharacter {

    public static void main(String[] args) {
        System.out.println(firstUniqueCharacter("hello"));
    }

    public static char firstUniqueCharacter(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(char letter: s.toCharArray()) {
            int count = map.getOrDefault(letter, 0);
            map.put(letter, count + 1);
        }

        for(char letter: s.toCharArray()) {
            if(map.get(letter) == 1) return letter;
        }

        throw new IllegalArgumentException("No unique characters...");
    }

}
