package InterviewQuestions_StringProblems;

public class Permutation {

    public static void main(String[] args) {
        permute("ABC");
    }

    public static void permute(String string){
        permute(string, 0, string.length()-1);
    }

    private static void permute(String string, int leftIndex, int rightIndex){
        if(leftIndex == rightIndex){
            System.out.println(string);
        }
        else{
            for(int i = leftIndex; i<=rightIndex; i++){
                string = swap(string, leftIndex, i);
                permute(string, leftIndex+1, rightIndex);
                string = swap(string, leftIndex, i);
            }
        }
    }

    private static String swap(String string, int i, int j){
        char[] arr = string.toCharArray();

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return String.valueOf(arr);
    }

}
