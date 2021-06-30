package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zw_appendAndDelete {

    public static void main(String[] args) {
        System.out.println(appendAndDelete("xxxxx", "xxxxxxx", 4));
    }

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int index = 0;

        while(index < s.length() && index < t.length()) {
            if(s.charAt(index) != t.charAt(index)) break;
            index++; // 1
        }

        int delete = s.length() - index;
        int append = t.length() - index; // 7 - 5 = 2

        if(delete == 0 && append == 0) {
            return "Yes";
        }
        else if(k - append > t.length() || delete + append == k ) {
            return "Yes";
        }
        else if(delete == 0) {
            String answer = "";

            if(k <= 2 || k % append != 0) {
                return "No";
            }
            else if (s.length() + k > t.length()) {
                return "Yes";
            }


            return answer;

        }
        else {
            return "No";
        }
    }

}
