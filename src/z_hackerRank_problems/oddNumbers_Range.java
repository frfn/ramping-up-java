package z_hackerRank_problems;

import java.util.ArrayList;
import java.util.List;

public class oddNumbers_Range {

    public static void main(String[] args) {
        List<Integer> list = oddNumbers(2, 19);
        System.out.println(list);
    }
    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r; i++){
            if(i % 2 != 0){
                list.add(i);
            }
        }
        return list;
    }

}
