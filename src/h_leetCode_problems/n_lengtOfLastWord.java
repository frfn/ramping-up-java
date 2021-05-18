package h_leetCode_problems;

public class n_lengtOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWordWithoutSplitNoSymbols("Hello World !! "));
    }

    public static int lengthOfLastWord(String s) {
        String[] words = s.strip().split(" ");
        String word = words[words.length - 1];
        return word.length();
    }

    /*

    Easy to understand explanation

    1. start at the end of the string

    2. lettersCount++ until you hit a ' '

    3. return lettersCount

     */

    public static int lengthOfLastWordwithoutSplit(String s) {
        String sFiltered = s.strip();
        int lettersCount = 0;
        for(int i = sFiltered.length()-1; i >= 0; i--, lettersCount++) {
            if(sFiltered.charAt(i) == ' ') {
                return lettersCount;
            }
        }
        return lettersCount;
    }

     /*

    Easy to understand explanation

    This takes into account the symbols or non characters to be skipped!

    1. Same as above

    2. while Character is NOT letter or digit, i--, move the loop back!

     */

    public static int lengthOfLastWordWithoutSplitNoSymbols(String s) {
        // String sFiltered = s.strip(); // this MUST happen.
        int lettersCount = 0;
        int lastCharacter = s.length() - 1;

        // this is the s.strip() for the END :)
        while(lastCharacter > -1 && !Character.isLetterOrDigit(s.charAt(lastCharacter))) {
            lastCharacter--; // this is how you get 'skip' over symbols
        }

        for(int i = lastCharacter; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                return lettersCount;
            }

            lettersCount++;
        }
        return lettersCount;
    }

}
