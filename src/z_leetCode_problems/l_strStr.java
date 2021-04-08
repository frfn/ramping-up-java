package z_leetCode_problems;

// if needle ( the string ) is in haystack ( the string )
// is "ll" is in "hello"
public class l_strStr {

    public static void main(String[] args) {

        System.out.println(strStr("hell", "ll"));

    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals("") || needle.length() == 0 || haystack.equals(needle)) {
            return 0;
        }
        if(haystack.contains(needle)) {
            int index;
            for(int i = 0; i < haystack.length(); i++ ) {
                if(haystack.substring(i, i + needle.length()).equals(needle)) {
                    index = i;
                    return index;
                }
            }
        }
        return -1;
    }

}
