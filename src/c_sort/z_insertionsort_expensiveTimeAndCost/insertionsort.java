package c_sort.z_insertionsort_expensiveTimeAndCost;

public class insertionsort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertionSort(arr);
        for(int num: arr) {
            System.out.print(num+",");
        }
    }

    public static void insertionSort(int[] arr) {
        // starts at index 1 and loops forward
        // 2nd loop, loops BACKWARDS and compares, if j+1 < j, then swap!
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j+1] < arr[j]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
                else {
                    break;
                }
            }
        }
    }

}
