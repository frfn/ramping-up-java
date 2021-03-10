package InterviewQuestions_ArrayProblems;

/*
    Efficiency -- Big O Notation

    two sum

    Write a program that allows for an integer array to be passed in and will then output all of the pairs that sum up to 10.

    Please provide a solution that allows for:

    1) output all pairs (includes duplicates and the reversed ordered pairs)
    2) output unique pairs only once (removes the duplicates but includes the reversed ordered pairs)
    3) output the same combo pair only once (removes the reversed ordered pairs).

    For example passing in [1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9] the following results should occur:

    1) output all pairs would output: [1,9], [1,9], [4,6], [4,6], [5,5], [5,5], [5,5], [5,5], [5,5], [5,5], [6,4], [6,4] [9,1] , [9,1]
    2) output unique pairs only once would output: [1,9], [4,6], [5,5], [6,4], [9,1]
    3) output the same combo pair only once would output: [1,9], [4,6], [5,5]   "
 *
 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RealInterviewQuestion {

    public static void main(String[] args) {
        int[] values = {1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9};

        printAllPairs(values, 10);

        System.out.println();

        printUniquePairs(values, 10);

        System.out.println();

        printStrictPairs(values, 10);

    }

    public static void printAllPairs(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(j==i){
                    continue;
                }
                if(arr[i] + arr[j] == target){
                    System.out.print("[" + arr[i] + ", " + arr[j] + "]" + ", ");
                }
            }
        }
    }

    public static void printUniquePairs(int[] arr, int target) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int val : arr) {
            set.add(val);
        }

        for (int val : set){
            int difference = target - val;

            if(set.contains(difference)){
                System.out.print("[" + val + ", " + difference + "]" + ", ");
            }
        }

    }

    // 1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9
    public static void printStrictPairs(int[] arr, int target){

        int left = 0,
                right = arr.length-1;

        while(left < right){

            int total = arr[left] + arr[right];

            if(total == target){
                System.out.print("[" + arr[left] + ", " + arr[right] + "]" + ", ");
                left++; right--;
            }

            else if(total < target){
                left++;
            }

            else {
                right--;
            }

        }

    }

}
