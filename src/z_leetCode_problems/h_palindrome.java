package z_leetCode_problems;

public class h_palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("flexer"));
    }

    public static boolean isPalindrome(String word) {
        if(word.length() == 0) return false;

        word = word.strip().replaceAll("[^a-zA-Z]+", "").toLowerCase();

        for(int i = 0; i < word.length() / 2; i++) {
            if(word.charAt(i) != word.charAt(word.length() - i - 1 )) {
                return false;
            }
        }
        return true;
    }
}
