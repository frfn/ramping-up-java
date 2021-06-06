package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zf_caesarCipher {

    public static void main(String[] args) {
        System.out.println(caesarCipherASCII("aaa", 2));
    }

    // ascii
    public static String caesarCipherASCII(String s, int k)
    {
        char[] arr = s.toCharArray();

        k = k % 26;

        for(int i=0;i<arr.length;i++)
        {
            int num;
            int ch = arr[i]; // if number or symbol then skip

            // if capital letters
            // 65 = A ... 90 = Z
            if( ch >= 65 && ch <= 90 )
            {
                num = (int)arr[i] + k; // HERE is where the ciphering happens,
                if(num>90) num -= 26;  // if greater than Z, then subtract
                arr[i] = (char)num;
            }

            // if lowercase letters
            // 97 = a ... 122 = z
            else if( ch >= 97 && ch <= 122 )
            {
                num = (int)arr[i] + k;  // ciphering happens here
                if(num>122) num -= 26;  // if greater than z, then subtract
                arr[i] = (char)num;
            }
        }

        return String.valueOf(arr);
    }

    // mine works
    public static String caesarCipher(String s, int k) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int correctSize = k % alphabet.length();
        String cipheredAlphabet = newAlphabet(alphabet, correctSize);

        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {
            boolean space = Character.isSpaceChar(c);     // is space?
            boolean upperCase = Character.isUpperCase(c); // keep track if capital
            boolean symbol = !Character.isLetterOrDigit(c); // a symbol
            boolean number = Character.isDigit(c);
            char letter = Character.toLowerCase(c);       // lower cases the letters


            int indexOfLetter = alphabet.indexOf(letter);

            if(indexOfLetter == -1) {
                if(space) {
                    sb.append(" ");
                }
                else if(symbol) {
                    sb.append(c);
                }
                else if(number) {
                    sb.append(c);
                }
            }
            else if(upperCase) {
                sb.append(Character.toUpperCase(cipheredAlphabet.charAt(indexOfLetter)));
            } else {
                sb.append(cipheredAlphabet.charAt(indexOfLetter));
            }
        }
        return sb.toString();

    }

    public static String newAlphabet(String alphabet, int k) {
        return alphabet.substring(k) + alphabet.substring(0, k);
    }

}
