package Sorting_Algorithms;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 6, 4, 3, 2, 1, 10, 3, 2, 4};

        for(int val: arr){
            System.out.print(val + ", ");
        }

        System.out.println();
        ms(arr);
        System.out.println();

        for(int val: arr){
            System.out.print(val + ", ");
        }

    }
    public static void merge(int[] A, int[] L, int[] R){
        int i, j, k;
        i=j=k=0;
        while(i < L.length && j < R.length){
            if(L[i] < R[j]){
                A[k++] = L[i++];
            }
            else{
                A[k++] = R[j++];
            }
        }
        while(i < L.length){
            A[k++] = L[i++];
        }
        while(j < R.length){
            A[k++] = R[j++];
        }
    }
    public static void ms(int[] arr){
        if(arr.length == 1){
            return;
        }
        int middle = arr.length / 2;  // 9 / 2 = 4,  [4]  [4+1] = [5] or [9-4=5]
        int[] left = new int[middle]; int[] right = new int[arr.length - middle];
        for(int i=0; i<middle; i++){
            left[i] = arr[i];
        }
        for(int i=0; i<arr.length-middle; i++){
            right[i] = arr[i+middle];
        }
        ms(left);
        ms(right);
        merge(arr, left, right);
    }
}
