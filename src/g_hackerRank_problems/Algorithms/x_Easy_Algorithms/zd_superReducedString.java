package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zd_superReducedString {

    public static void main(String[] args) {
        System.out.println(superReducedString("baab"));
    }

    /*

    Super easy explanation

    start at index 1 to compare with previous value

    if they're the same character, substring

        - if in the beginning and substring(0, 0) --> this will remove the letter in front
            - then adds the rest of string

        - if in the middle this will add the letters from beginning to current index - 1 ( exclusive )
            - then adds the rest of string

     special feature: i = 0 --> next iteration it will be i = 1, then you can compare again!

     */

    public static String superReducedString(String str) {
        for (int i = 1; i < str.length(); i++) {

            System.out.println(str + ":" +str.length());

            if (str.charAt(i) == str.charAt(i-1)) {

                System.out.println(str.substring(i+1));

                      // current base         // adding the string in front of it
                str = str.substring(0, i-1) + str.substring(i+1);

                i = 0; // so that when the next for loop goes, it's 1
            }
        }

        if (str.length() == 0) {
            return "Empty String";
        } else {
            return str;
        }

    }

    // good attempt
    public static String superReducedString2(String s) {
        StringBuilder sb = new StringBuilder();

        int counter = 1;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                counter++;
            }
            else {
                if(counter % 2 != 0) {
                    sb.append(s.charAt(i - 1));
                }

                counter = 1;

            }
        }

        if(counter % 2 != 0) {
            sb.append(s.charAt(s.length() - 1));
        }

        // asserting they are true
        boolean sameValue = true;
        for(int i = 1; i < sb.length(); i++) {
            if(sb.charAt(i) != sb.charAt(i - 1)) sameValue = false;
        }

        return sameValue ? "Empty String" : sb.toString();
    }

}
