package InterviewQuestions_HashMapProblems;

// hashmap<string, ArrayList<String>> map

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class findWords {


    public static void main(String[] args) throws IOException {

        HashMap<String, ArrayList<String>> map = (HashMap) sameWord("/Users/flexer/Desktop/IntelliJ/Java/InterviewQuestions_HashMapProblems/txtFile.txt",
                                                                           "/Users/flexer/Desktop/IntelliJ/Java/InterviewQuestions_HashMapProblems/file.txt");

        for(Map.Entry pair: map.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        System.out.println();
        // finding out which words are common in files.
        System.out.println("Finding common words...");
        for(Map.Entry pair: map.entrySet()){
           ArrayList<String> value = (ArrayList<String>) pair.getValue();
           if(value.size() > 1){
               System.out.println(pair.getKey() + " : " + pair.getValue());
           }
        }
    }

    public static Map<String, ArrayList<String>> sameWord(String... path) throws IOException {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String pathName: path) {
            File file = new File(pathName);
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                ArrayList<String> list = new ArrayList<>();
                String str = scan.next();

                // list already has value?
                if(map.get(str) != null){
                    // get the current list, add on to it. Put in map.
                    ArrayList<String> otherFile = map.get(str);
                    otherFile.add(pathName);
                    map.put(str, otherFile);
                }
                // list sees value first time?
                else {
                    list.add(pathName);
                    map.put(str, list);
                }

            }
        }
        return map;
    }

}
