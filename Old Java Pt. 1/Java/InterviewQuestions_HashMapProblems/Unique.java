package InterviewQuestions_HashMapProblems;

import java.util.HashMap;

public class Unique {

    public static void main(String[] args) {
        System.out.println(isUnique("AbC"));
    }

    public static boolean isUnique(String str){
        if(str.charAt(0) == str.charAt(1)){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            Integer count = map.get(str.charAt(i));
            int newCount = count == null ? 1 : count + 1;
            map.put(str.charAt(i), newCount);
        }
        for(HashMap.Entry<Character, Integer> entry: map.entrySet()){
            int count = (int)entry.getValue();

            return count > 1 ? false : true;
        }
        return true;
    }
}
