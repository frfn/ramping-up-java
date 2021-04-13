package c_sort.z_bubblesort_expensiveTimeAndCost;

public class bubblesort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        bubblesortMethod(arr);
        for(int num: arr) {
            System.out.print(num + ", ");
        }
    }

    public static void bubblesortMethod(int[] arr) {
        // bubble sort sorts by arr[i+1] < arr[i] swap --> until end of loop. It will do that UNTIL no swaps are needed

        // 6 3 3 4 2 1 4
        // 3 3 4 2 1 4 6
        // 3 3 2 1 4 4 6
        // 3 2 1 3 4 4 6
        // 2 1 3 3 4 4 6
        // 1 2 3 3 4 4 6

        // slow!

        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < arr.length-1; i++) {
                if(arr[i+1] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
