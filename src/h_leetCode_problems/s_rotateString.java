package h_leetCode_problems;

public class s_rotateString {

    public static void main(String[] args) {

        System.out.println(rotate("abcde", "bcdea"));

    }

    public static boolean rotateString(String A, String B) {
        if(A.equals(B)) return true;
        if(A.length() != B.length()) return false;
        return (A+A).contains(B);
    }


    public static boolean rotate(String A, String B) {
        // base case
        if(A.equals(B)) return true;
        if(A.length() != B.length()) return false;

        // sb
        StringBuilder sb = new StringBuilder();

        // iterate
        for(int i = 0; i < A.length(); i++) {

            // adds from current index to last
            sb.append(A.substring(i));

            if(i > 0) {
                // adds from beginning to current index
                sb.append(A.substring(0, i));
            }

            // compares to B
            if(sb.toString().equals(B)) return true;

            // reset sb
            sb.setLength(0);

        }
        return false;
    }
}
