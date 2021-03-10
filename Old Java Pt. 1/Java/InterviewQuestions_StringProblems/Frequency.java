package InterviewQuestions_StringProblems;

public class Frequency {

    public static void main(String[] args) {
        String freq = alterString("abbbcccdeff");
        System.out.println(freq);
    }

    public static String alterString(String string){
        if(string.length() == 1){
            return string;
        }

        // aaabbbbcdd == a3b4cd2

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < string.length()-1; i++){
            if(string.charAt(i) == string.charAt(i+1)){
                count++;
            }
            else{

                if(count > 1){
                    sb.append(string.charAt(i) + Integer.toString(count));
                }
                else {
                    sb.append(string.charAt(i));
                }
                count = 1;
            }
        }
        if(count > 1){
            sb.append(string.charAt(string.length()-1) + Integer.toString(count));
        }
        else {
            sb.append(string.charAt(string.length())-1);
        }
        return sb.toString();
    }

}
