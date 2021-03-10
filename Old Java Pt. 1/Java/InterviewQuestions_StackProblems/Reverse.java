package InterviewQuestions_StackProblems;
import java.util.Stack;
public class Reverse {

    public static void main(String[] args) {
        String string = reverse("Flexer");
        System.out.println(string);
    }

    public static String reverse(String string){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < string.length(); i++){
            stack.push(string.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
