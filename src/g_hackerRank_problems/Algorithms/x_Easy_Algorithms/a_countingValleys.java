package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class a_countingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys("UUDDDUUDDUU"));
        /*
          /\
        -/  \  /\  /-
             \/  \/

        = UUDDDUUDDUU = 2 valleys
         */

    }
    public static int countingValleys(String path) {
        if(path.length() == 0) return 0;

        int valleys = 0;
        int seaLevel = 0;

        for(char letter: path.toCharArray()){
            if(letter == 'U') seaLevel++;
            if(letter == 'D'){
                // the important part of the logic, only when sea level is 0, and going down is when it is a valley
                if(seaLevel == 0) valleys++;
                seaLevel--;
            }
        }
        return valleys;
    }
}
