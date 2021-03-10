package InterviewQuestions_HashMapProblems;

import java.util.HashMap;

public class twoSum {

    public static void main(String[] args) {

        int[] list = {1, 1, 7, 4, 7, 5, 9, 2, 12, 3, 1};

        int[] pairs = sum(list, 19);

        for(int val: pairs) {
            System.out.println("Index: " + val);
        }

    }

    public static int[] sum(int[] list, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<list.length; i++){
            int difference = target - list[i];

            if(map.containsKey(difference)){
                //map.get(difference) = the index of the other value | i = current index
                return new int[] {map.get(difference), i};
            }

            map.put(list[i], i);
        }

        return new int[] {0, 0};

    }
}
