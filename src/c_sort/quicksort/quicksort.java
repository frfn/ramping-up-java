package c_sort.quicksort;

public class quicksort {

    /*
    Sorting Alg -

    Pivot   - an item that we use to compare            (BETWEEN PARTITION)
            - all elements left of pivot is LESS        (LEFT PARTITION)
            - all elements right of pivot is GREATER    (RIGHT PARTITION)



     */

    public static void main(String[] args) {
        int[] sortMe = {5,4,3,2,1};
        quicksort(sortMe, 0, sortMe.length-1);
        for(int num: sortMe) System.out.println(num);
    }

    public static int partition(int[] Array, int start, int end) {
        int pivot = Array[end]; // this will be the number to compare to

        int partitionIndex = start; // the pointer, moves up

        for (int i = start; i <= end; i++) {
            if (Array[i] < pivot) { // compares the pivot with the beginning of array
                int temp = Array[i];
                Array[i] = Array[partitionIndex];
                Array[partitionIndex] = temp;
                ++partitionIndex;
            }
        }

        int temp = Array[end]; // switch pivot to where the partition index will be
        Array[end] = Array[partitionIndex];
        Array[partitionIndex] = temp;
        return partitionIndex;
    }
    public static void quicksort(int[] Array, int start, int end) {
        if (start <= end) {
            int pi = partition(Array, start, end);

            quicksort(Array, start, pi-1);

            quicksort(Array, pi+1, end);


        }
    }
}
