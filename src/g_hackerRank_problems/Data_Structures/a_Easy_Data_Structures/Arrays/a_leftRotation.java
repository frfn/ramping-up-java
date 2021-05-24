package g_hackerRank_problems.Data_Structures.a_Easy_Data_Structures.Arrays;

import java.util.ArrayList;
import java.util.List;

public class a_leftRotation {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        for(int num: rotateLeft(2, nums)) System.out.print(num + ", ");
    }

    public static List<Integer> rotateLeft(int n, List<Integer> nums) {
        int index = 0;

        List<Integer> rotated = new ArrayList<>();

        // 2
        // 1 2 3 4 5
        // 3 4 5 1 2

        for(int num: nums) {
            if(index >= n) {
                rotated.add(num);
            }
            index++;
        }

        index = 0;

        for(int num: nums) {
            if(index < n) {
                rotated.add(num);
            }
            index++;
        }


        return rotated;

    }

}
