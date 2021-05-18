package g_hackerRank_problems;

public class e_jumpingOnClouds {
     public static void main(String[] args){
         System.out.println(jumpingOnClouds(new int[] {0, 1, 1, 0, 0, 1, 1, 0}));
     }
     public static int jumpingOnClouds(int[] c) {
         int count = -1;

         // this was an elegant solution | we found how to 'skip' a number in the array by doing i++ in the 'if' condition
         for (int i = 0; i < c.length; i++, count++) {
             if (i<c.length-2 && c[i+2]==0) i++; // skips the 1 | length-2 so that it accounts for the out of bounds, since i+2 in the second condition
         }
        return count;
     }
}
