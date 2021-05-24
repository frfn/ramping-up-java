package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class u_aliceBobScore {

    public static List<Integer> score(List<Integer> a, List<Integer> b) {
        List<Integer> score = new ArrayList<>();

        int alice = 0;
        int bob = 0;

        int index = 0;

        while(index < a.size() && index < b.size()) {
            if(a.get(index) < b.get(index)) bob++;
            else if((a.get(index) > b.get(index))) alice++;

            index++;
        }
        score.add(alice);
        score.add(bob);

        return score;
    }


    public static void main(String[] args) {
        List<Integer> alice = new ArrayList<>();
        List<Integer> bob = new ArrayList<>();

        alice.add(5); alice.add(6); alice.add(7);
        bob.add(3); bob.add(6); bob.add(10);

        for(int score : score(alice, bob)) {
            System.out.println(score);
        }

    }

}
