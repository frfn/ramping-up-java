package ReadingToConsole;
import java.io.*;
import java.util.*;

public class Reading {

	public static void main(String[] args) throws IOException {
		
		String str = "";
		
		File file = new File("text2");
		Scanner scan = new Scanner(file);
		
		
		while(scan.hasNext()) {
			str = scan.nextLine();
			//str = scan.next();  will only take the last token ( file. ) <-- output
		}
		
		System.out.println(str);
		
	}
	
}
