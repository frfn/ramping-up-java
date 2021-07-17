package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zzc_minimumDistances {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(3); l.add(2);l.add(1); l.add(2);l.add(3);
        System.out.println(minDistances(l));

    }

    public static int minDistances(List<Integer> a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < a.size(); i++) {
            if(map.containsKey(a.get(i))) {

                int getValue = a.get(i);
                int getMapValue = map.get(getValue);

                int num = Math.abs(getMapValue - i);
                min = Math.min(num, min );

            }
            else {
                map.put(a.get(i), i);
            }


        }

        if(min == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return min;
        }

    }


    public static int minimumDistances(List<Integer> a) {
        int min = Integer.MAX_VALUE;
        /*
            find the min distance between two of SAME value

           v | 3 2 1 2 3
           i | 0 1 2 3 4

            3 - 1 = 2 return 2...
         */
        for(int i = 0; i < a.size(); i++) {

            for(int j = i + 1; j < a.size(); j++) {

                // if they're equal, add the distance
                if(a.get(i).equals(a.get(j))) {
                    min = Math.min(Math.abs(j - i), min);
                    break;
                }

            }

        }

        if(min != Integer.MAX_VALUE) {
            return min;
        }
        else {
            return -1;
        }

    }

}
