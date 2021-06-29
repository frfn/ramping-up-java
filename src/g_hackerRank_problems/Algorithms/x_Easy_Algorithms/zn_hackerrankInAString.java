package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zn_hackerrankInAString {

    public static void main(String[] args) {
        System.out.println(hackerrankInString("hereiamstackerrank"));
    }

    public static String hackerrankInString(String s) {
        int index = 0;
        final String hr = "hackerrank";

        /*

        Explanation:

        by using an index, we can keep track of the letter that we MUST find

        Only INCREASE the index, IF we find the letter.

        That's it!

         */

        for(int i = 0; i < s.length(); i++) {
            if(hr.charAt(index) == s.charAt(i)) {
                index++;
            }
            if(index == hr.length() - 1) return "YES";
        }
        return "NO";
    }

}
