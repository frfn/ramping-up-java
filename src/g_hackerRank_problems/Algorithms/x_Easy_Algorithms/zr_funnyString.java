package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zr_funnyString {

    public static void main(String[] args) {
        System.out.println(funnyString("acxz"));
    }

    public static String funnyString(String s) {

        int[] sIntArray = new int[s.length() - 1];
        int indexS = 0;

        int[] rIntArray = new int[s.length() - 1];
        int indexR = 0;

        for(int i = 1; i < s.length(); i++) {
            sIntArray[indexS++] = Math.abs((int)s.charAt(i) - (int)s.charAt(i-1));
        }

        String reversed = reverseString(s);

        for(int i = 1; i < s.length(); i++) {
            rIntArray[indexR++] = Math.abs((int)reversed.charAt(i) - (int)reversed.charAt(i-1));
        }

        for(int i = 0; i < sIntArray.length; i++) {
            if(sIntArray[i] != rIntArray[i]) {
                return "Not Funny";
            }
        }

        return "Funny";
    }

    public static String reverseString(String s) {
        if(s.length() == 0) return "";
        char[] sCharArray = s.toCharArray();

        for(int i = 0; i < sCharArray.length / 2; i++) {
            char tempLetter = sCharArray[i];
            sCharArray[i] = sCharArray[sCharArray.length - 1 - i];
            sCharArray[sCharArray.length - 1 - i] = tempLetter;
        }

        StringBuilder sb = new StringBuilder();
        for(char letter: sCharArray) {
            sb.append(letter);
        }
        return sb.toString();

    }

}
