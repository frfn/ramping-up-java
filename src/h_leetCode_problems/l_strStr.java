package h_leetCode_problems;

// if needle ( the string ) is in haystack ( the string )
// is "ll" is in "hello"
public class l_strStr {

    public static void main(String[] args) {

        System.out.println(strStr("aaaaa", "bba"));

    }

    /*

    Easy to understand explanation

    1. base case should be understood, if empty or haystack is needle return 0

    2. in a for loop, by comparing the substring(i, i + needle.length()) .equals (needle)
        - you can find what index you will start on, and return that

     */

    public static int strStr(String haystack, String needle) {
        if (needle.equals("") || needle.length() == 0 || haystack.equals(needle)) {
            return 0;
        }
//        if(haystack.contains(needle)) {
            for(int i = 0; i < haystack.length(); i++ ) {
                if(i + needle.length() > haystack.length()) return -1;

                if(haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
//            }
        }
        return -1;
    }

}
