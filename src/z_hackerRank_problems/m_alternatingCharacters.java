package z_hackerRank_problems;

public class m_alternatingCharacters {

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AABAABB"));
    }

    // AABAAB = 2

    // AAAA = 3

    // BBBBB = 4

    public static int alternatingCharacters(String s) {
        int counter = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                counter++;
            }
        }
        return counter;
    }

}
