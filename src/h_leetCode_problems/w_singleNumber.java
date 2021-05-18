package h_leetCode_problems;

import java.util.HashSet;

public class w_singleNumber {

    public static void main(String[] args) {
        System.out.println(singleNum(new int[] {4,1,2,1,2}));
    }

    public static int singleNum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for(int num: set){
            return num;
        }
        return 0;
    }

}
