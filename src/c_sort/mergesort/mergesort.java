package c_sort.mergesort;

public class mergesort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 8, 9, 2};
        mergeSort(arr);

        for(int num: arr) System.out.print(num + ", ");
    }

    // 5 3 1 8 9 2
    // middle = 6 / 2 = 3
    // left[3] | right[6-3] = right[3]
    // left[] = { 5, 3, 1 }
    // right[] { 8, 9, 2 }

    // middle = 3 / 2 = 1.5 = 1
    // left[1] | right[3-1] = right[2]
    // left[] = { 5 }
    // right[] = { 3 , 1 }

    // finish a call in the call stack since left length == 1
    // continue to mergeSort(right);
    // arr = { 3, 1 }
    // left[] = { 3 }
    // right[] = { 1 }
    // merge( {3,1} , {3} , {1} ) == 1 3
    // finish a call in the call stack
    // arr = { 5, 1, 3 }
    // merge( {5, 1, 3}, {5}, {1, 3} ) == 1 3 5

    // move on to right branch!!

    public static void mergeSort(int[] arr) {
        if(arr.length == 1) {
            return;
        }

        int middle = arr.length / 2;
        int[] left = new int[middle];
        int[] right = new int[arr.length - middle];

        {
            // for left
            for(int i = 0; i < left.length; i++) {
                left[i] = arr[i];
            }
        }

        {
            // for right
            for(int i = 0; i < right.length; i++) {
                right[i] = arr[i + middle];
            }
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] MERGED, int[] L, int[] R) {
        int i,j,k;
        i=j=k=0;
        while(i < L.length && j < R.length) {
            if(L[i] < R[j]) {
                MERGED[k++] = L[i++];
            }
            else {
                MERGED[k++] = R[j++];
            }
        }
        while (i < L.length) {
            MERGED[k++] = L[i++];
        }
        while (j < R.length) {
            MERGED[k++] = R[j++];
        }
    }
}