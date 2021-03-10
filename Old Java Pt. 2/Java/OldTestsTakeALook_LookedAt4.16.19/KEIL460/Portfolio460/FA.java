package Portfolio460;
import java.util.Stack;


public class FA {

    public static void main(String[] args) {
     
        
        System.out.println("Test for objective 2.1a");
        System.out.println("-----------------------");
        System.out.println("Testing 10101: " + finiteAutomata("10101"));
        System.out.println("Testing 101: " + finiteAutomata("101"));
        System.out.println("Testing 011110: " + finiteAutomata("011110"));
        System.out.println("Testing 011111110: " + finiteAutomata("011111110"));
        
        System.out.println();
        
        System.out.println("Test for objective 3.1c");
        System.out.println("-----------------------");
        readLanguage("1*011010");
        
    }
    
    public static boolean finiteAutomata(String string){
        // Objective 2.1a - 2
        // "This FA accepts(returns true) strings that start with 0, 
        // end with 0, and have only 1's inbetween"
        
        
        if(string.charAt(0) != '0'){    // If first digit is not 0
            return false;
        }
        if(string.charAt(string.length() - 1) != '0'){ //If last digit is not 0
            return false;
        }
        
        for(int i = 1; i < string.length()-1; i++){ //if middle digits are not 1
            
            if(string.charAt(i) != '1'){
                return false;
            }
        }
        
        return true; // if string passes all criteria

    }
    
    public static void readLanguage(String s) {
        // For Objective 3.1c
        // So this method takes a regular expression and prints what it would
        // look like. For the sake of readability we assume kleene star only
        // iterates 5 times
        
        // This is super simple and does not handle () or | operators.
        
        Stack<Character> tstack = new Stack();
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i < s.length(); i++){
            
            tstack.push(s.charAt(i));
           
        }
        for(int i = 0; i < s.length(); i++){
            stack.push(tstack.pop());
        }
        
        
        char digit = ' ';
        char nextDigit = ' ';
        
        while(!stack.empty()){
            
            if(nextDigit != '*'){
                
                digit = nextDigit;
                if(!stack.empty()){
                    nextDigit = stack.pop();
                }
            } else {
                
                digit = stack.pop();
                if(!stack.empty()){
                    nextDigit = stack.pop();
                }
            }
            
            if(nextDigit == '*'){
                for(int i = 0; i <= 5; i++){
                    System.out.print(digit);
                }
                continue;
            } else {
                System.out.print(digit);
            }
            
            
            
            
            
            if(stack.empty()){
                System.out.print(nextDigit);
            }
            
            
        }

        
    }
    
}
