package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class zu_sequenceEquation {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);


        for(int num : permutationEquationV2(list)) System.out.println(num);
    }

    public static List<Integer> permutationEquationV2(List<Integer> p) {
        List<Integer> list = new ArrayList<>();

        List<Integer> newListWith1Index = new ArrayList<>();
        newListWith1Index.add(0);

        for(int x = 1; x <= p.size(); x++) {
            newListWith1Index.add(x, p.get(x-1));
        }

        for(int x = 1; x <= p.size(); x++) {

            int inner = newListWith1Index.indexOf(x);

            int outer = newListWith1Index.indexOf(inner);

            list.add(outer);
        }


       return list;
    }

    public static List<Integer> permutationEquation(List<Integer> p) {
        List<Integer> list = new ArrayList<>();

        List<Integer> newListWith1Index = new ArrayList<>();

        newListWith1Index.add(0);
        newListWith1Index.addAll(p);

        for(int x = 1; x <= 50; x++) {

            for(int i = 0; i < newListWith1Index.size(); i++) {
                // 0 1 2 3 4 5
                // 0 5 2 1 3 4

                int pN;
                int ppN;

                if(x == newListWith1Index.get(i)) {
                    pN = i;

                    for(int j = 0; j < newListWith1Index.size(); j++) {
                        if(pN == newListWith1Index.get(j)) {
                            ppN = j;

                            list.add(ppN);
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }

}
