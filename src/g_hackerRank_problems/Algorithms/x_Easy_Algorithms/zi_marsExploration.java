package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zi_marsExploration {

    public static void main(String[] args) {
        System.out.println(marsExploration("SOSSPSSQSSOR"));
    }

    public static int marsExploration(String s) {

        /*
        SOS

        we must count the letters that are altered

        SOSSOTTOS = 2

        SOS SOT TOS

        012 345 678

        0 % 3 = 0
        1 % 3 = 1
        2 % 3 = 2
        3 % 3 = 0
        4 % 3 = 1
        5 % 3 = 2
        6 % 3 = 0

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != SOS.charAt(i % 3)) count++;
        }

        ...


        */

        final String SOS = "SOS";
        int index = 0;
        int count = 0;

        // take away, instead of index, you can use modulo

        // char

        for(char letter: s.toCharArray()) {

            if(letter != SOS.charAt(index)) count++;

            index++;

            if(index == SOS.length()) index = 0;

        }

        return count;
    }

}
