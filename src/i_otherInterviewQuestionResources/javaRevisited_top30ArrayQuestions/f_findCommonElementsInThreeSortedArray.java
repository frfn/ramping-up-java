package i_otherInterviewQuestionResources.javaRevisited_top30ArrayQuestions;

import java.util.*;

public class f_findCommonElementsInThreeSortedArray {

    public static void main(String[] args) {
        // for three arrays
        int[] input1 = new int[] {1, 5, 10, 20, 40, 80};
        int[] input2 = new int[] {6, 7, 10, 10, 20, 80, 100};
        int[] input3 = new int[] {3, 4, 10, 10, 15, 20, 30, 70, 80, 120};

        // for two arrays
        int[] lcInput1 = new int[] {4,9,5};
        int[] lcInput2 = new int[] {9,4,9,8,4};

        for(int num: commonElementsInThreeArraysEfficient(input1,input2,input3)) {
            System.out.println(num);
        }
    }

    // easier to understand now that you rested... woo hoo. Victory!
    public static List<Integer> commonElementsInThreeArraysEfficient(int[] a, int[] b, int[] c) {
        if(a.length == 0 || b.length == 0 || c.length == 0) return new ArrayList<>();

        List<Integer> commonElements = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        while(i < a.length && j < b.length && k < c.length) {
            if(a[i] == b[j] && b[j] == c[k]){
                commonElements.add(a[i]);
                i++;
                j++;
                k++;
            }

            else if(a[i] < b[j]) {
                i++;
            }

            else if(b[j] < c[k]) {
                j++;
            }

            else k++;
        }
        return commonElements;
    }


    // LC -- For Binary Search ... it is only 32.48% FASTER THAN MOST
    // three arrays
    public static int[] commonElements(int[] a, int[] b, int[] c) {

        // using set to keep things strictly no dupes!
        Set<Integer> commonElement = new HashSet<>();
        for(int num: a) {
            // uses binary search to see if elements are in the other arrays
            if(bs(b, num) && bs(c, num)) commonElement.add(num);
        }

        // adding to int[] since data is coming from Set!
        int[] common = new int[commonElement.size()];
        int index = 0;
        for(int num : commonElement) common[index] = num;

        return common;

    }
    // two arrays -- same logic as above method!
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
