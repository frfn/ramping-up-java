package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zs_beautifulBinaryString {

    public static void main(String[] args) {
        System.out.println(beautifulBinaryString("0101010"));
    }

    public static int beautifulBinaryString(String b) {
        final String notBeautiful = "010";

        int count = 0;

        for(int i = 0; i <= b.length() - notBeautiful.length(); ) {

            String currentValues = b.substring(i, i+3);

            if(currentValues.equals(notBeautiful)) {
                count++;
                i += 3;
            }
            else {
                i++;
            }
        }


        return count;
    }

}
