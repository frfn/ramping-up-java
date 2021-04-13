package c_sort.z_selectionsort_expensiveTimeAndCost;

public class selectionsort {

    public static void main(String[] args) {
        for(int num: selectionSort(new int[] {5,4,3,2,1})) {
            System.out.print(num+ ",");
        }
    }

    public static int[] selectionSort(int[] arr) {
        // selects the minimum index and swaps it!

        // 8 2 4 1 3 2 4 1
        // 1 2 4 1 3 2 4 8
        // 1 1 4 2 3 2 4 8
        // 1 1 2 2 3 4 4 8
        for(int i = 0; i < arr.length; i++) {
            int min_index = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            // if min_index DOES NOT change, we want it to since it spots a more lesser value, then don't do anything!
            if(min_index != i) {
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

}
