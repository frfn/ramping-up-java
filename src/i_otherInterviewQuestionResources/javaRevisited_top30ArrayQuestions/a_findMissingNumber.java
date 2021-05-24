package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.*;

public class a_findMissingNumber {

    public static void main(String[] args) {
        for(int missingNum : findMissNumbersUnsortedAndDuplicates(new int[] {8, 9, 3, 3, 1, 5, 7, 8, 1, 1, 1, 1}, 20)) {
            System.out.println(missingNum);
        }
    }

    // will work with only one number, sorted array
    public static int findMissingNumber(int[] arr, int num) {

        // instead of the for loop to add one by one, math way is:
        int expectedSum = num * ((num + 1) / 2);

        // using my JS knowledge, I know what this does, sum() is a form of reduce()
        int actualSum = Arrays.stream(arr).sum();

        return expectedSum - actualSum;
    }

    // will work with many missing numbers, sorted array
    public static List<Integer> findMissingNumbers(int[] list, int totalCount) {
        List<Integer> missingNums = new ArrayList<>();
        for(int i = 1; i < totalCount; i++) {
            if(!bs(list, i)) {
                missingNums.add(i);
            }
        }
        return missingNums;
    }
    private static boolean bs(int[] list, int target) {
        int left = 0, right = list.length - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(list[middle] == target) return true;
            else if(list[middle] < target) left  = middle + 1;
            else right = middle - 1;
        }
        return false;
    }

    public static List<Integer> findMissNumbersUnsortedAndDuplicates(int[] list, int totalCount) {
        List<Integer> missingNums = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num: list) set.add(num);

        for(int i = 1; i <= totalCount; i++) {
            if(!set.contains(i)) {
                missingNums.add(i);
            }
        }
        return missingNums;
    }


}
