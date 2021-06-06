package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zc_strongPassword {

    public static void main(String[] args) {
        System.out.println(minimumNumber(7, "Ab1"));
    }

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        /*
        Its length is at least .
        It contains at least one digit.
        It contains at least one lowercase English character.
        It contains at least one uppercase English character.
        It contains at least one special character. The special characters are: !@#$%^&*()-+

        numbers = "0123456789"
        lower_case = "abcdefghijklmnopqrstuvwxyz"
        upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        special_characters = "!@#$%^&*()-+"
        */

        boolean numbers = false, lowerCase = false, upperCase = false, symbol = false;
        int count = 0;

        // flexer

        for(char c: password.toCharArray()) {
            if(Character.isLowerCase(c)) lowerCase = true;
            if(Character.isUpperCase(c)) upperCase = true;
            if(Character.isDigit(c)) numbers = true;
            if(!Character.isLetterOrDigit(c)) symbol = true;
        }

        if(!lowerCase) count++;
        if(!upperCase) count++;
        if(!symbol) count++;
        if(!numbers) count++;



        if(count + password.length() > 6) {
            return count;
        }
        else return 6 - password.length();
    }

}
