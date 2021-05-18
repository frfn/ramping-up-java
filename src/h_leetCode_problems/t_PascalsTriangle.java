package h_leetCode_problems;

import java.util.ArrayList;
import java.util.List;

public class t_PascalsTriangle {

    public static void main(String[] args) {
        for(List<Integer> list: generate(3)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> generate(int k) {
        List<List<Integer>> list = new ArrayList<>();

        if(k == 0) {
            return list;
        }

        list.add(new ArrayList<>());
        list.get(0).add(1);

        for(int row = 1; row < k; row++) {
            List<Integer> newRow = new ArrayList<>();
            List<Integer> prevRow = list.get(row - 1); // we only use prevRow if row > 1


            // since we always start with 1
            newRow.add(1);
            for(int i = 1; i < row; i++) {
                newRow.add(prevRow.get(i-1) + prevRow.get(i));
            }
            newRow.add(1);

            // since we always end with 1
            list.add(newRow);
        }
        return list;
    }

}
