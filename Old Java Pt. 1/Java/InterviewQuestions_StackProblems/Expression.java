package InterviewQuestions_StackProblems;
import java.util.Stack;
public class Expression {

    public static void main(String[] args) {
        boolean val = isEqual("{()}");
        System.out.println(val);
    }

    public static boolean arePair(char o, char c){
        if(o == '{' && c == '}') { return true; }
        else if(o == '[' && c == ']') { return true; }
        else if(o == '(' && c == ')') { return true; }
        return false;
    }

    public static boolean isEqual(String expression){
        Stack<Character> stack = new Stack();
        for (int i = 0; i < expression.length(); i++){
            // if it starts add with those symbols, add to stack
            if(expression.charAt(i) == '[' ||
                    expression.charAt(i) == '{' ||
                    expression.charAt(i) == '(') {

                stack.push(expression.charAt(i));
            }

            // if seen these current symbols, compare first, if not the same, false, else POP!
            else if(expression.charAt(i) == ']' ||
                    expression.charAt(i) == '}' ||
                    expression.charAt(i) == ')') {

                if(stack.empty() || !arePair(stack.lastElement(), expression.charAt(i))){
                    return false;
                }
                else{
                    stack.pop();
                }
            }

        }
        return (stack.empty()) ? true : false;
    }

}