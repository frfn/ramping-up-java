package z_leetCode_problems;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


public class f_validParenthesis {

    public static void main(String[] args) {
        // System.out.println(validParenthesis("abcdef(gh)jk[lmno(p)]qrst{}vwxy[z]"));
        System.out.println(validParenthesis("([](){})"));
    }

    public static boolean validParenthesis(String str) {
        if(str == null || str.isEmpty()) {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            // if any of these symbols come up, push on to stack.

            /*
            First go around.
             if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
             */
            if(map.containsKey(c)) {
                stack.push(c);
            }
            else {
                // if stack contains )]} in the beginning, it will be false!
                // OR
                // ] != ) true -> return false, [)])
                // ] != ] false -> pop
                if(stack.isEmpty() || map.get(stack.peek()) != c) {
                    return false;
                }

                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}

/*
HashSet<Character> alphabet = new HashSet<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');

         // if any letters, skip iteration
            if(alphabet.contains(c)) {
                continue;
            }
 */
