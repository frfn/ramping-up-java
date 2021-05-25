package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.*;

public class f_findCommonElementsInThreeSortedArray {

    public static void main(String[] args) {
        int[] input1 = new int[] {1, 5, 10, 20, 40, 80};
        int[] input2 = new int[] {6, 7, 10, 10, 20, 80, 100};
        int[] input3 = new int[] {3, 4, 10, 10, 15, 20, 30, 70, 80, 120};

        // for(int num: commonElements(input3, input2, input1)) System.out.println(num);

        int[] lcInput1 = new int[] {4,9,5};
        int[] lcInput2 = new int[] {9,4,9,8,4};

        for(int num: intersection(lcInput1, lcInput2)) {
            System.out.println(num);
        }


    }

    // iterative will be the fastest! search that up and code it up!
    // on geeksforgeeks


    // LC -- For Binary Search ... it is only 32.48% FASTER THAN MOST
    // three arrays
    public static int[] commonElements(int[] a, int[] b, int[] c) {
        Set<Integer> cE = new HashSet<>();
        for(int num: a) {
            if(bs(b, num) && bs(c, num)) cE.add(num);
        }

        int[] common = new int[cE.size()];
        int index = 0;
        for(int num : cE) common[index] = num;

        return common;

    }
    // two arrays
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> cE = new HashSet<>();
        for(int num: nums1) {
            if(bs(nums2, num)) cE.add(num);
        }
        int[] common = new int[cE.size()];
        int index = 0;
        for(int num : cE) common[index++] = num;

        return common;
    }
    // binary search function
    private static boolean bs(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(arr[middle] == target) return true;
            else if(arr[middle] < target) left = middle + 1;
            else right = middle - 1;
        }
        return false;
    }
}
