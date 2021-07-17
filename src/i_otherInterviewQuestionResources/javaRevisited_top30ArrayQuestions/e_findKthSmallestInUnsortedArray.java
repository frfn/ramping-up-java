package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.Arrays;

public class e_findKthSmallestInUnsortedArray {

    // find the Kth smallest number in unsorted array
    public static void main(String[] args) {
        System.out.println(kthSmallestNumber(new int[] {4,2,9,1,3}, 2));
    }

    // This would be the "newb" answer ... as in there are other solutions!
    // the reason why im not doing it because it requires min heap / max heap / quickselect

    public static int kthSmallestNumber(int[] unsortedArr, int k) {
        if(k <= 0 || k > unsortedArr.length) return 0;
        Arrays.sort(unsortedArr);
        return unsortedArr[k-1];
    }

}
