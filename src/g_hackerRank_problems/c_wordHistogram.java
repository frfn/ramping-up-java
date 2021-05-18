package g_hackerRank_problems;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class c_wordHistogram {

    public static void main(String[] args) throws IOException {

        StringBuilder strBuilder = new StringBuilder();
        BufferedReader readFile;

        try {
              readFile = new BufferedReader(new FileReader("/Users/flexerfadrigalan/Documents/1. Code/Java/IntelliJ - Project 2021/src/z_hackerRank_problems/z_IOfile.txt"));
              String contentLine;
              while ((contentLine = readFile.readLine()) != null) {
                  strBuilder.append(contentLine).append(" ");
              }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        HashMap<String, Integer> words = histo(strBuilder.toString());

        for(Map.Entry<String, Integer> entry: words.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    public static void printHistogram(String words) {
        // String[] wordsSplit = words.replace("\n", " ").split(" ");

        HashMap<String, Integer> histogram = new HashMap<>();
        for(String word: words.strip().split(" ")) {
            if(!histogram.containsKey(word)){
                histogram.put(word, 1);
            }
            else {
                histogram.put(word, histogram.get(word) + 1);
            }
        }

        for(String word: histogram.keySet()){
            System.out.println(word + " : " + histogram.get(word));
        }

    }

    public static HashMap<String, Integer> histo(String exp) {
        if(exp.length() == 0) return null;

        HashMap<String, Integer> map = new HashMap<>();
        for(String word: exp.split(" ")) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }

        return map;
    }

}

/*
Code is buggy! As said in StackOverflow ... they're plugging in user input that will NOT terminate ... smh.
 // for the last line to end, I have to do \n!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();

        while(line != null) {
            System.out.println(line);
            line = br.readLine();

        }
 */