package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.*; // LOTS OF DEBUGGING.

public class zx_cutTheSticks {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(2);
        list.add(2);
        list.add(8);

        for(int length : cutTheSticks(list)) System.out.println(length);

    }

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        List<Integer> numOfSticks = new ArrayList<>();

        // whats the min? 2

        // 5 4 4 2 2 8

        // 2 2 4 4 5 8 -- sorted

        // 0 0 2 2 3 6

        // 0 0 0 0 1 4

        // 0 0 0 0 0 3

        // ----

        // 6 5 4 1 1 4

        // 1 1 4 4 5 6 -- sorted

        // 0 0 3 3 5 6

        // 0 0 0 0 2 3

        // 0 0 0 0 0 1

        Collections.sort(arr); // log * n

        int count = 0;

        System.out.println();

        for(int i = 0; i < arr.size(); i++) { // 2 2 4 4 5 8

            if(arr.get(i) == 0) continue; // moving up through deleted sticks

            int shortestStick = arr.get(i); // 2

            for(int j = i; j < arr.size(); j++) {
                if(arr.get(j) != 0) {
                    count++;
                    arr.set(j, arr.get(j) - shortestStick); // this is the cool part!  using the .set to modify value IN the list!
                }
            }

            numOfSticks.add(count);
            count = 0;

        }

        return numOfSticks;

    }

}
