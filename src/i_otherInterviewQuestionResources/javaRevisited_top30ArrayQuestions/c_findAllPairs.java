package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class c_findAllPairs {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(-1);
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(3);
        list.add(4);

        for(List<Integer> pair: findAllPairs(list, 3)) {
            System.out.println(pair);
        }

    }

    // [ 3,-1,1,2,0,3,4 ]
    public static List<List<Integer>> findAllPairs(List<Integer> list, int target) {
        List<List<Integer>> pairs = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>(list);

        for(int num: list) {
            List<Integer> pair = new ArrayList<>();

            int complement = target - num;

            if(set.contains(complement)) {
                pair.add(num); pair.add(complement);

                set.remove(num);
                set.remove(complement);

                pairs.add(pair);
            }
        }

        return pairs;

    }

}
