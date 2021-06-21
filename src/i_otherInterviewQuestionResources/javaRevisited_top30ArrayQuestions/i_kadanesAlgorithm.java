package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.ArrayList;
import java.util.List;

public class i_kadanesAlgorithm {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(1);
        list.add(-3);
        list.add(4);
        list.add(-1);
        list.add(2);
        list.add(1);
        list.add(-5);
        list.add(4);

        System.out.println(kadanesAlg(list));

    }

    public static int kadanesAlg(List<Integer> list) {

        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;

        for(int num: list) {
            runningSum = Math.max(num, runningSum + num);
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;

    }

}
