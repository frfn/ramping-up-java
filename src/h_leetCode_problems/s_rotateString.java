package h_leetCode_problems;

public class s_rotateString {

    public static void main(String[] args) {

        System.out.println(rotate("abcde", "bcdea"));

    }

    public static boolean rotate(String A, String B) {
        System.out.println(A+A);
        if(A.equals(B)) return true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < A.length(); i++) {
            sb.append(A.substring(i));
            if(i > 0) {
                sb.append(A.substring(0, i));
            }
            if(sb.toString().equals(B)) return true;
            sb.setLength(0);
        }
        return false;
    }
}
