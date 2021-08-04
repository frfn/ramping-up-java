package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zzh_fairRations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();
        System.out.println("Enter nums: ");
        for(int i = 0; i < 940; i++) {
            l.add(scan.nextInt());
        }
        System.out.println(fairRations(l));
    }

    public static String fairRations(List<Integer> B) {
        // * 2 the amount of times
        int counter = 0;

        if(B.size() == 2 &&
                ((B.get(0) % 2 != 0 && B.get(1) % 2 == 0) ||
                        (B.get(1) % 2 == 0 && B.get(0) % 2 != 0))) {
            return "NO";
        }

        for(int i = 0; i < B.size() - 1; i++) {

            if(B.get(i) % 2 != 0) {
                counter++;
                B.set(i, B.get(i) + 1);
                B.set(i+1, B.get(i+1) + 1);
            }

            if(i == B.size()-2 &&
                    ((B.get(B.size()-1) % 2 != 0 && B.get(B.size()-2) % 2 == 0) ||
                            (B.get(B.size()-2) % 2 != 0 && B.get(B.size()-1) % 2 == 0))) {
                return "NO";
            }

        }
        return Integer.toString(counter * 2);
    }

}
