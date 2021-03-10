package Leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Easy_validParenthesis {

    public static void main(String[] args){
        System.out.println(isValidHashMap("Hi all {P}"));
    }

    // utilizes comparison last element on stack, best answer, OVERALL.
    public static boolean arePairs(char o, char c){
        if (o == '[' && c == ']') return true;
        else if (o == '{' && c == '}') return true;
        else if (o == '(' && c == ')') return true;
        else return false;
    }
    public static boolean isValid(String s){
        if(s == null) return false;
        if(s.equals("")) return true;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')'){
                if(stack.empty() || !arePairs(stack.lastElement(), s.charAt(i))){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.empty() ? true : false;
    }

    // uses the keys for ), }, ] and values are (, {, [
    /*
        How it works:
        1. pushes the opening characters
        2. if closing character appears
            - compare if value is an opening character, pop, if not, false
            - false if empty
        3. After all is done, if stack is empty, true.
     */
    public static boolean isValidHashMap(String s){
        HashMap<Character,Character> maps=new HashMap<Character,Character>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(maps.containsKey(c)){
                if(stack.empty()||stack.pop()!=maps.get(c))return false;
            }
            else
                stack.push(c);
        }
        return stack.empty();
    }

    // the best answer IF expression being passed are all opening and closing characters
    /*
        How it works:
        1. If sees an opening character, push the closing character
        2.
     */
    public static boolean is_Valid(String s) {
        Stack<Character> stack = new Stack<Character>();

        // Hot Spot: I didn't even know...
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');  // push in closing character to stack
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');

            /*
             how does it know WHEN to pop?
             ... goes through each else if clause, if it sees ), ], } then do operation.
             */

            // pop() runs, if closing character is not equals to current character, return false
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


}
