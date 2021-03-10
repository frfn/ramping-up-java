package interviewQuestions_CommonElements;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Using_BinarySearch_Set_HashMap_ForLoop {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 9, 10, 13, 14, 16, 17, 19, 20, 23, 25, 30};
        int[] arr2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 21, 22, 23, 24, 30};

        int[] ce = ceMap(arr, arr2);
        for(int val : ce){
            if(val != 0){
                System.out.print(val + ", ");
            }
        }

    }

    /**
     * Did not implement for loop, Big O(n^2) solution.
     */

    public static boolean binarySearch(int[] arr, int data){
        int left = 0,
                right = arr.length-1;

        while(left <= right){
            // PEMDAS so DO NOT do (left + (right-left)) / 2 ..... smh.
            int middle = left + (right-left) / 2;

            if(arr[middle] == data){
                return true;
            }
            else if(arr[middle] < data){
                left = middle + 1;
            }
            else if(arr[middle] > data) {
                right = middle - 1;
            }
        }
        return false;
    }

    public static int[] commonElements(int[] arr, int[] arr2){

        // bigger size of the two just in case indexOutOfBounds
        final int SIZE = arr.length > arr2.length ? arr.length : arr2.length;
        int[] common = new int[SIZE];

        int count = 0;
        for(int val: arr){
            if(binarySearch(arr2, val)){
                common[count++] = val;
            }
        }

        return common;

    }

    public static int[] ceSet(int[] arr, int[] arr2){

        final int SIZE = arr.length > arr2.length ? arr.length : arr2.length;
        int[] common = new int[SIZE];

        HashSet<Integer> set = new HashSet();
        for(int val: arr){
            set.add(val);
        }
        int count = 0;
        for(int val: arr2){
            if(set.contains(val)){
                common[count++] = val;
            }
        }

        return common;
    }

    public static int[] ceMap(int[] arr, int[] arr2){
        final int SIZE = arr.length > arr2.length ? arr.length : arr2.length;
        int[] common = new int[SIZE];

        HashMap map = new HashMap();

        for(int i = 0; i < SIZE; i++){
            // second value will be value index, can be 0, tbh, map.put(arr[i], i);
            map.put(arr[i], 0);
        }

        int count = 0;
        for(int val: arr2){
            if(map.containsKey(val)){
                common[count++] = val;
            }
        }
        return common;
    }
}
