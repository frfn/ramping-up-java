package Leetcode;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Easy_twoSum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        int[] pair = sum(arr, 8);

        for(int val: pair){
            System.out.println(val);
        }

    }

    // 1, 2, 3, 4, 5   ,  6
    public static int[] sum(int[] array, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < array.length; i++){
            int difference = target - array[i];
            if(map.containsKey(difference)){
                return new int[] {map.get(difference), i};
            }
            map.put(array[i], i);
        }
        throw new NoSuchElementException("No elements can be found");
    }
}
