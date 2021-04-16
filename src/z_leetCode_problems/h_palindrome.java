package z_leetCode_problems;

public class h_palindrome {

    public static void main(String[] args) {
        System.out.println(strictPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String word) {
        if(word.length() == 0) return false;

        word = word.strip().replaceAll("[^a-zA-Z]", "").toLowerCase();

        for(int i = 0; i < word.length() / 2; i++) {
            if(word.charAt(i) != word.charAt(word.length() - i - 1 )) {
                return false;
            }
        }
        return true;
    }

    public static boolean strictPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            while(start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
