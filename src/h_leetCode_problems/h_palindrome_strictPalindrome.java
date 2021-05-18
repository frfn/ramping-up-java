package h_leetCode_problems;

public class h_palindrome_strictPalindrome {

    public static void main(String[] args) {
        System.out.println(strictPalindrome("A man, a plan, a canal: Panama"));
    }

    // uses Regular Expression
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

    /*

    Easy to understand explanation:

    1. grab the starting index and last index of string

    2. while start less than or equal to end
        - if character is NOT a letter or digit at start, then start++
        - if character is NOT a letter or digit at end, then end--
        - if character from start is not the same as character from end, return false

    3. you still have to move pointer if the characters ARE a letter or digit
        - start++
        - end--

    4. return true

    */

    // uses Character.isLetterOrDigit()
    public static boolean strictPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            while (start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
