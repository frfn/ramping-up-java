package Leetcode;

public class Easy_MergeSortedArray {

    public static void main(String[] args) {
        int[] num1 = {1, 3, 7, 0, 0 ,0, 0};
        int[] num2 = {2, 3, 5, 6};

        merge(num1, 3, num2, 4);

        for(int val : num1){
            System.out.print(val + " ");
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int first = m-1;
        int second = n - 1;
        while (first >= 0 && second >= 0) {
            if (nums1[first] <= nums2[second]) {
                nums1[index--] = nums2[second--];
            } else {
                nums1[index--] = nums1[first--];
            }
        }
        while (second >= 0) {
            nums1[index--] = nums2[second--];
        }

    // we do not do the first array because it already sorted AS WELL AS that's the array we're putting stuff into!
    }

}
