package h_leetCode_problems;

public class v_addBinary {

    /*

     Similar logic to Add to Lists!!

     11         1010
      1 +       1011 +
    ---        -----
    100        10101

    1111
     111
    ----
    10110

     */

    public static void main(String[] args) {
        System.out.println(addBin("1010", "1011"));
    }

    public static String addBin(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexForA = a.length()-1, indexForB = b.length()-1, carry = 0;
        while(indexForA >= 0 || indexForB >= 0) {
            // this logic just adds to the sum!
            int sum = carry;
            if(indexForA >= 0) sum += Integer.parseInt(String.valueOf(a.charAt(indexForA--)));
            if(indexForB >= 0) sum += Integer.parseInt(String.valueOf(b.charAt(indexForB--)));

            // this logic is what I have to study...
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        int i,j, carry;
        i = a.length()-1;
        j = b.length()-1;
        carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(j >= 0) sum += b.charAt(j--) - '0'; // this does the same thing as above!
            if(i >= 0) sum += a.charAt(i--) - '0';
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
