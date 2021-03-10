package Sorting_Algorithms;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 8, 9, 7, 5, 6, 4, 2, 1, 3};
        quickSort(arr);

        for(int num: arr){
            System.out.print(num + ", ");
        }
    }
    private static void helper(int[] arr, int start, int end){
        if(start <= end){
            int pi = partition(arr, start, end);
            helper(arr, start, pi-1);
            helper(arr, pi+1, end);
        }
    }
    public static void quickSort(int[] arr){
        helper(arr, 0, arr.length-1);
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     * Hotspots:
     *
     * pivot = arr[end]; pi = start;
     * i = start ; i <= end ; i++
     * arr[i] < pivot ; swap ; pi++;
     */
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int pi = start;
        for(int i=start; i<=end; i++){
            if(arr[i] < pivot){
                swap(arr, i, pi);
                pi++;
            }
        }
        /**
         * swap pi with end, return pi
         */
        swap(arr, pi, end);
        return pi;
    }
}
