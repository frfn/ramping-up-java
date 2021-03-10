package InterviewQuestions_StringProblems;

import java.util.HashMap;

public class isPermutation {

    public static void main(String[] args) {
        System.out.println(isItPermutation("Flex", "xleF"));
    }

    public static boolean isItPermutation(String str, String str2){
        if(str.length() != str2.length()) { return false; }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            Integer count = map.get(str.charAt(i));
            int newCount = count == null ? 1 : count + 1;
            map.put(str.charAt(i), newCount);
        }

        // Decreases value of each keys till 0, remove when 0, if all are removed, return true.
        for(int i=0; i<str2.length(); i++){
            if(map.containsKey(str2.charAt(i))){
                map.put(str2.charAt(i), map.get(str2.charAt(i))-1);

                if(map.get(str2.charAt(i)) == 0){
                    map.remove(str2.charAt(i));
                }
            }
            else{
                return false;
            }
        }

        return true;

    }

}
