package z_leetCode_problems;

public class j_mergeSortedArray {

    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int l, r;
        l=m-1;
        r=n-1;
        while(l != -1 && r != -1) {
            if (nums1[l] >= nums2[r]) {
                nums1[index--] = nums1[l--];
            } else {
                nums1[index--] = nums2[r--];
            }
        }
        while(l != -1) {
            nums1[index--] = nums1[l--];
        }
        while(r != -1) {
            nums1[index--] = nums2[r--];
        }
    }

}
