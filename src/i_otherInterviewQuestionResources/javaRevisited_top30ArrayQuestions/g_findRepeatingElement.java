package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class g_findRepeatingElement {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(6);

        System.out.println(elementThatDoesntRepeat(list));
    }

    public static int elementThatRepeats(List<Integer> nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        for(int num: nums) {
            if(map.get(num) > 1) {
                return num;
            }
        }

        throw new IllegalArgumentException("No repeating elements...");

    }

    public static int elementThatDoesntRepeat(List<Integer> nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        for(int num: nums) {
            if(map.get(num) == 1) {
                return num;
            }
        }

        throw new IllegalArgumentException("No repeating elements...");

    }



}
