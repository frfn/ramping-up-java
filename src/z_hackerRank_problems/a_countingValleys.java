package z_hackerRank_problems;

public class a_countingValleys {

    public static void main(String[] args) {

        System.out.println(countingValleys(8, "UDDDUDUU"));

    }

    public static int countingValleys(int steps, String path) {

        int seaLevel = 0;
        int valleys = 0;

        for(int i = 0; i < steps; i++) {
            // seaLevel goes up
            if(path.charAt(i) == 'U') {
                seaLevel++;

            // seaLevel goes down
            } else if(path.charAt(i) == 'D') {
                // before we go down, we check to see if it's a valley, 0 == the indicator that says we're at sea level
                if(seaLevel == 0) {
                    valleys++;
                }
                seaLevel--;
            }


        }

        return valleys;

    }

}
