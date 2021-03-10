package Searching_Algorithms;

import java.util.ArrayList;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 9, 10, 13, 14, 16, 17, 19, 20, 23, 25, 30};
//        int[] arr = {1, 2, 4, 6, 7, 8, 9, 10, 11, 13, 14, 15, 26, 46, 78, 99};
//        int[] arr2 = {1, 3, 4, 6, 12, 13, 14, 26, 34, 78, 99};
//
//        ArrayList list = new ArrayList();
//
//        final int SIZE = arr.length < arr2.length ? arr.length : arr2.length;
//
//        for(int i = 0; i < SIZE; i++){
//            if(binarySearch(arr, arr2[i])){
//                list.add(arr2[i]);
//            }
//        }
//
//        System.out.println(list.toString());

        boolean val = binarySearch(arr, 4);
        System.out.println(val);
    }

    public static boolean binarySearch(int[] arr, int val){
        int left = 0,
            right = arr.length-1;

        while(left <= right){
            int middle = (left + right) / 2;
            if(arr[middle] == val){
                return true;
            }
            else if(arr[middle] < val){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        return false;
    }
}
