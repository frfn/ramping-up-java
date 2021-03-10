package Toast_Interview;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("F. Le X, e... LF"));
    }

    public static boolean isPalindrome(String string){
        if(string == null){
            return false;
        }
        String filtered = string.replaceAll("[^a-zA-Z]+", "").toLowerCase();
        final int SIZE = filtered.length();
        System.out.println(filtered);
        for(int i = 0; i < SIZE / 2; i++){
            if(filtered.charAt(i) != filtered.charAt(SIZE - i - 1)){
                return false;
            }
        }
        return true;
    }

}
