package z_leetCode_problems;

public class n_lengtOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWordwithoutSplit("a   "));
    }

    public static int lengthOfLastWord(String s) {
        String[] words = s.strip().split(" ");
        String word = words[words.length - 1];
        return word.length();
    }

    public static int lengthOfLastWordwithoutSplit(String s) {
        String sFiltered = s.strip();
        int lettersCount = 0;
        for(int i = sFiltered.length()-1; i >= 0; i--, lettersCount++) {
            if(sFiltered.charAt(i) == ' ') {
                break;
            }
        }
        return lettersCount;
    }

}
