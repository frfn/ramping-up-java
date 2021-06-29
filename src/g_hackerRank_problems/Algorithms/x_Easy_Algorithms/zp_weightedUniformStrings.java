package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.*;

public class zp_weightedUniformStrings {

    public static void main(String[] args) {
        List<Integer> queries = new ArrayList<>();
        queries.add(1);
        queries.add(7);
        queries.add(5);
        queries.add(4);
        queries.add(15);

        String s = "abbcccdddd";


        for(String string : weightedUniformStrings(s, queries)) {
            System.out.println(string);
        }
    }

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {

        List<String> list = new ArrayList<>();

        HashMap<Character, Integer> abc = new HashMap<>();
        int value = 1;
        for(int i = 97; i <= 122; i++) {
            abc.put((char) i, value++);
        }

        // going into the string , first step grab the values of uniform!
        HashSet<Integer> values = new HashSet<>();
        int counter = 1;

        // aab
        for(int i = 0; i < s.length() - 1; i++) {

            values.add(abc.get(s.charAt(i)) * counter); // 1

            if(s.charAt(i) == s.charAt(i+1)) {
                counter++;
            }
            else {
                counter = 1;
            }

        }

        values.add(abc.get(s.charAt(s.length() - 1)) * counter); // since off by one!

        for(int query: queries) {
            if(values.contains(query)) {
                list.add("YES");
            }
            else {
                list.add("NO");
            }
        }


        return list;


        /*
         for(Map.Entry<Character, Integer> keypair: abc.entrySet()) {
            System.out.println(keypair.getKey() + " : " + keypair.getValue());
         }

        int sum = 0;
        for(char c : s.toCharArray()) {
            sum += abc.getOrDefault(c, 0);
        }

        for(int v: values) System.out.println(v);
         */
    }



}
