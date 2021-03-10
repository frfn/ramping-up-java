package InterviewQuestions_ArrayProblems;

public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        reverse(arr);

        for(int num: arr){
            System.out.println(num);
        }

    }

    public static void reverse(int[] arr){
        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

}
