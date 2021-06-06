package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.ArrayList;
import java.util.List;

public class h_findTopTwoNumsInList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(3);
        list.add(9);
        list.add(6);
        list.add(7);
        list.add(3);
        list.add(9);


        for(int nums: topTwoForLoop(list)) System.out.println(nums);
    }

    public static List<Integer> topTwoForLoop(List<Integer> nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        // 10,3,9,6,7,3,9

        for(int num: nums) {
            // if number is greater than top max, max2 gets max1, max1 = num!
            if(num > max1) {
                max2 = max1;
                max1 = num;
            }

            // if number is greater than max2, then max2 == num!
            else if (num > max2) {
                max2 = num;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(max1); list.add(max2);
        return list;

    }

    public static List<Integer> topTwo(List<Integer> nums) {
        int[] firstMax = findMax(nums);
        nums.remove(firstMax[1]);
        int[] secondMax = findMax(nums);

        nums.clear();
        nums.add(firstMax[0]);
        nums.add(secondMax[0]);

        return nums;
    }
    private static int[] findMax(List<Integer> nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int index = 0;
        for(int num: nums) {
            if(num > max) {
                maxIndex = index;
                max = num;
            }

            index++;

        }
        return new int[] {max, maxIndex};
    }

}
