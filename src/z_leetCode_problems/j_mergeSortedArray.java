package z_leetCode_problems;

public class j_mergeSortedArray {

    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1; // start is at this length
        int l, r;
        l=m-1; // off by one
        r=n-1; // off by one
        while(l != -1 && r != -1) { // go until -1
            if (nums1[l] >= nums2[r]) {
                nums1[index--] = nums1[l--];
            } else {
                nums1[index--] = nums2[r--];
            }
        }
        // for any remainder in the arrays
        while(l != -1) {
            nums1[index--] = nums1[l--];
        }
        while(r != -1) {
            nums1[index--] = nums2[r--];
        }
    }

}
