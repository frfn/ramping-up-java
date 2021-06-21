package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zh_catsAndMouse {

    public static void main(String[] args) {
        System.out.println(catAndMouse(2,5,4));
    }

    public static String catAndMouse(int x, int y, int z) {
        /*
        x = cat a
        y = cat b
        z = mouse

        if cat a catches mouse PRINT , in this case return

        if cat b catches mouse return cat b

        if both reaches at the same time return mouce c
         */

        String result;

        int progessOfCatA = Math.abs(z - x);
        int progessOfCatB = Math.abs(z - y);

        if(progessOfCatA < progessOfCatB) {
            result = "Cat A";
        }
        else if(progessOfCatA == progessOfCatB) {
            result = "Mouse C";
        }
        else {
            result = "Cat B";
        }

        return result;
    }

}
