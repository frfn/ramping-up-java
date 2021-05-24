package g_hackerRank_problems.Data_Structures.b_Medium_Data_Structures.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a_sparseArrays {

    public static void main(String[] args) {

    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        List<Integer> freq = new ArrayList<>();

        HashMap<String, Integer> container = new HashMap<>();
        for(String string: strings) {
            int count = container.getOrDefault(string, 0);
            container.put(string, count+1);
        }

        for(String query: queries) {
            if(container.containsKey(query)) {
                freq.add(container.get(query));
            }
            else {
                freq.add(0);
            }
        }

        return freq;
    }

}
