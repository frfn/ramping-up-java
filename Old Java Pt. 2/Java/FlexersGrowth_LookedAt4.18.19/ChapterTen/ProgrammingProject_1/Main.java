package ProgrammingProject_1;
import java.util.Scanner;
public class Main  {
	
	public static void main(String[] args) throws StringTooLongException {
		
		StringTooLongException e1 = new StringTooLongException("String length more than 7...");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter code: ");
		String code = scan.nextLine(); 
		int count = 0;
		
		while(!code.equals("DONE")){
		
			try {	
				if(code.length() > 5) {
					throw e1;
				}
				else {
					count++;
				}
			} catch(StringTooLongException s) {
			System.out.println("String too long, input again...");
			}
		
		//System.out.println("Code: " + code);
		
		System.out.print("Enter code: ");
		code = scan.nextLine(); 
		
		}//end of while
		
		System.out.println("Valid: " + count);
	}

}
