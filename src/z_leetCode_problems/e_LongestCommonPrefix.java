package z_leetCode_problems;

public class e_LongestCommonPrefix {


    public static void main(String[] args) {
        System.out.println(commonPrefix(new String[] {"leetcode", "leetco", "leetcheetah"}));
    }

    // [ leetcode,
    //   leetco,
    //   leetcheetah ] = leetc

    public static String commonPrefix(String[] words) {
        for(int i = 0; i < words[0].length(); i++) {
            char letter = words[0].charAt(i);

            for(int j = 1; j < words.length; j++) {
                // remember that in an OR exression that if the first statement is true, the second statement will not be evaluated!
                if(i == words[j].length() || words[j].charAt(i) != letter) {
                    return words[0].substring(0, i);
                }
            }

        }
        return words[0];
    }

}
