package Leetcode;

public class Easy_longestCommonPrefix {

    public static void main(String[] args) {
        String str = commonPrefix("aa", "a");
        System.out.println(str);
    }

    public static String commonPrefix(String... strs){
        if(strs == null || strs.length == 0){
            return "";
        }

        // very easy to understand. :)
        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);

            for(int j=1; j<strs.length; j++){

                // if strs[j].length and i are the same, the length of word is the same the prefix, that's it!
                // if at this letter, that c and charAt(i) is not the same, return

                // it does matter what goes first inside a conditional
                // if it sees that there is a different letter, then that's all they have in common.
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
