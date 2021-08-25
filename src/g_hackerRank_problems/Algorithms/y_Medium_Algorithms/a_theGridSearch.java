package g_hackerRank_problems.Algorithms.y_Medium_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class a_theGridSearch {

    public static void main(String[] args) {

        List<String> G = new ArrayList<>();

        G.add("400453592126560");
        G.add("114213133098692");
        G.add("474386082879648");
        G.add("522356951189169");
        G.add("887109450487496");
        G.add("252802633388782");
        G.add("502771484966748");
        G.add("075975207693780");
        G.add("511799789562806");
        G.add("404007454272504");
        G.add("549043809916080");
        G.add("962410809534811");
        G.add("445893523733475");
        G.add("768705303214174");
        G.add("650629270887160");

        List<String> P = new ArrayList<>();

        P.add("400");
        P.add("904");

        System.out.println(gridSearch(G, P));

    }

    public static String gridSearch(List<String> G, List<String> P) {

        String patternInGrid;

        // no way around a two for loop approach for a 2D array problem
        for(int i = 0; i < G.size(); i++) {
            for(int j = 0; j < G.get(i).length(); j++) {
                if(G.get(i).charAt(j) == P.get(0).charAt(0)) {
                    if(isThere(G,P,i,j)) {
                        patternInGrid = "YES";
                        return patternInGrid;
                    }
                }
            }
        }

        return "NO";
    }

    public static boolean isThere(List<String> G, List<String> P, int i, int j) {
        boolean match = false;

        // if this loop finished ... match == true
        // don't get overwhelmed with the stuff here
        // they're just i's and j's!
        // we are now looking at P!
        for(int P_i = 0; P_i < P.size(); P_i++) {
            // if any of these if statements are false, return false right away
            for(int P_j = 0; P_j < P.get(P_i).length(); P_j++) {

                // boundary check | if over, return false
                if(i + P_i < G.size() && j + P_j < G.get(i).length()) {

                    // letter check | if not the same, return false
                    if(P.get(P_i).charAt(P_j) == G.get(i + P_i).charAt(j + P_j)) {
                        match = true;
                    } else {
                        return false; // letter check
                    }
                }
                else {
                    return false; // boundary check
                }
            }
        }
        return match;
    }

}
