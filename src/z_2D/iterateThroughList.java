package z_2D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Object[] also supports iterators() so you can use the forEach loop!

public class iterateThroughList {

    public static void main(String[] args) {

        // there is an iterator() somewhere ... i don't know how to use it ... but it's there
        // with DS, they support iterators!

        // There all types of LinkedList() ... if you used an ArrayList() ... more example ready ... you're just iterating through, lets say String[], or int[], etc.
        LinkedList<List<String>> wordsCollection = new LinkedList<>();
        List<List<String>> sentenceCollection = new LinkedList<>();
        Queue<List<String>> lineCollection = new LinkedList<>();

        List<String> words = new ArrayList<>();

        words.add("test1");
        words.add("test2");
        words.add("test3");
        words.add("test4");
        words.add("test5");

        List<String> flex = new ArrayList<>();

        flex.add("flex1");
        flex.add("flex2");
        flex.add("flex3");
        flex.add("flex4");
        flex.add("flex5");

        List<String> cole = new ArrayList<>();

        cole.add("cole1");
        cole.add("cole2");
        cole.add("cole3");
        cole.add("cole4");
        cole.add("cole5");

        wordsCollection.add(words);
        wordsCollection.add(flex);
        wordsCollection.add(cole);

        lineCollection.add(words);
        lineCollection.add(flex);
        lineCollection.add(cole);

        sentenceCollection.add(words);
        sentenceCollection.add(flex);
        sentenceCollection.add(cole);

        for(List<String> row: wordsCollection) {
            System.out.println(row);
        }

        System.out.println();

        for(List<String> row: lineCollection) {
            System.out.println(row);
        }

        System.out.println();

        for(List<String> row: sentenceCollection) {
            for(String itemInRow: row) {
                if(itemInRow.contains("flex")) {
                    System.out.print(itemInRow + ", ");
                }
            }
        }

    }

}


