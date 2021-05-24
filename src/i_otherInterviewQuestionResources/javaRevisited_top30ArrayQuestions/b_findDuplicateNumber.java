package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.Arrays;

public class b_findDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(findDupe(new int[] {0,3,1,2,3}, 3));
    }

    public static int findDupe(int[] arr, int totalCount) {

        int expectedValue = totalCount * ((totalCount + 1) / 2);
        int actualValue = Arrays.stream(arr).sum();

        return actualValue - expectedValue;

    }

}
