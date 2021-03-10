package Leetcode;

public class Easy_plusOne {

    public static void main(String[] args) {
        int[] number = plusOne(new int[] {4, 3, 0, 9});
        for(int val : number)
            System.out.println(val + " ");
    }


    public static int[] plusOne(int[] number){
        if(number.length == 0 || number == null){
            throw new IllegalArgumentException("Error");
        }

        for(int i = number.length-1; i>=0; i--){
            if(number[i] < 9){
                number[i]++;
                return number;
            }

            number[i] = 0;
        }

        return new int[] {1};
    }

}
