package h_leetCode_problems;

public class u_checkIfTwoStringArraysAreEqual {

    public static void main(String[] args) {
        String[] word = {"a", "bc"};
        String[] word2 = {"abc"};
        String[] word3 = {"ab", "c"};

        System.out.println(equals(word, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String wordOne = String.join("", word1);
        String wordTwo = String.join("", word2);
        return wordOne.equals(wordTwo);
    }

    public static boolean equals(String[] word, String[] word2) {
        // ["a", "bc"]
        // ["a", "b", "c"]
        int pointer, pointer2, wordIndex, word2Index;
        pointer=pointer2=wordIndex=word2Index=0;

        // this condition is what I was looking for ...
        while(wordIndex < word.length && word2Index < word2.length) {
            if(word[wordIndex].charAt(pointer) != word2[word2Index].charAt(pointer2)) return false;

            // if the current string is at last letter, go to next word, and reset pointer
            if(pointer == word[wordIndex].length() - 1) {
                wordIndex++;
                pointer=0;
            } else {
                pointer++;
            }

            if(pointer2 == word2[word2Index].length() - 1) {
                word2Index++;
                pointer2=0;
            } else {
                pointer2++;
            }
        }
        return wordIndex == word.length && word2Index == word2.length;
    }

}
