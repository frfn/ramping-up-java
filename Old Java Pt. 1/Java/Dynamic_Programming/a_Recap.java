package Dynamic_Programming;

public class a_Recap {

    public static void main(String[] args) {

    }

    public static int bottomUp(int num){
        if(num <= 2){
            return 1;
        }

        int[] arr = new int[num+1];
        arr[1] = 1; arr[2] = 1;
        for(int i = 3; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[num];

    }

    public static int memoize(int num, int[] memo){
        int value;
        if(memo[num] != 0){
            return memo[num];
        }
        if(num <= 2){
            value = 1;
        }
        else{
            value = memoize(num-1, memo) + memoize(num-2, memo);
            memo[num] = value;
        }
        return value;
    }

}
