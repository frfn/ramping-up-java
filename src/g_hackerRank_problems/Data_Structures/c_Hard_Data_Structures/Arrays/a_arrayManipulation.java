package g_hackerRank_problems.Data_Structures.c_Hard_Data_Structures.Arrays;

import java.util.ArrayList;
import java.util.List;

public class a_arrayManipulation {

    public static void main(String[] args) {

        List<Integer> r1 = new ArrayList<>(); r1.add(1); r1.add(5); r1.add(3);
        List<Integer> r2 = new ArrayList<>(); r2.add(4); r2.add(8); r2.add(7);
        List<Integer> r3 = new ArrayList<>(); r3.add(6); r3.add(9); r3.add(1);

        List<List<Integer>> queries = new ArrayList<>(); queries.add(r1); queries.add(r2); queries.add(r3);

        long maxValue = arrayManipulation(10, queries);

        System.out.println(maxValue);

    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long[] arr = new long[n + 1];

        long maxValue = Long.MIN_VALUE;

        for(List<Integer> query: queries) {

            long start = query.get(0);
            long end = query.get(1);
            long value = query.get(2);

            for(long i = start; i <= end; i++) {
                arr[(int) i] += value;
                maxValue = Math.max(arr[(int) i], maxValue);
            }

        }
        return maxValue;
    }

}
