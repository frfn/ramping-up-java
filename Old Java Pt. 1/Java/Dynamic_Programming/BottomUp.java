package Dynamic_Programming;

public class BottomUp {

    public static void main(String[] args) {
        System.out.println(fibValue(5));
    }

    public static int fibValue(int num){
        if(num <= 2){
            return 1;
        }

        int[] bottomUp = new int[num+1];
        bottomUp[1] = 1;
        bottomUp[2] = 1;
        for(int i = 3; i < bottomUp.length; i++){
            bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
        }

        return bottomUp[num];
    }

}
