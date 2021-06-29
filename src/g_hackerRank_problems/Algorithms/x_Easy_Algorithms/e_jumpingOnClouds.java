package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class e_jumpingOnClouds {
     public static void main(String[] args){
         System.out.println(jumpV2(new int[] {0,0,0,1,0,0}));
     }

    public static int jumpV2(int[] clouds) {

        int count = 0;

        for(int i = 0; i < clouds.length; i++, count++) {
            if(i < clouds.length - 2 && clouds[i+2] == 0) {
                i++;
            }
        }

        return count - 1;

    }

     public static int jumpingOnClouds(int[] c) {
         int count = -1;

         // this was an elegant solution | we found how to 'skip' a number in the array by doing i++ in the 'if' condition
         for (int i = 0; i < c.length; i++, count++) {

             if (i<c.length-2 && c[i+2]==0) {
                 i++; // skips the 1 | length-2 so that it accounts for the out of bounds, since i+2 in the second condition

             }

         }
        return count;
     }


}
