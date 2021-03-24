package z_hackerRank_problems;

import java.util.HashMap;

public class wordHistogram {

    public static void main(String[] args){

    }

    public static void printHistogram(String words) {

        String[] wordsSplit = words.replace("\n", " ").split(" ");

        HashMap<String, Integer> histogram = new HashMap<>();

        for(String word: wordsSplit) {
            if(!histogram.containsKey(word)){
                histogram.put(word, 1);
            }
            else {
                histogram.put(word, histogram.get(word) + 1);
            }
        }

        for(String word: histogram.keySet()){
            System.out.println(word + " : " + histogram.get(word).toString());
        }

    }

}
