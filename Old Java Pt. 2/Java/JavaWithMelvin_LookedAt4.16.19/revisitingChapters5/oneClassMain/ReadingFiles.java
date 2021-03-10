package oneClassMain;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadingFiles {

	static String url;
	
	public static void main(String[] args) throws IOException {
		
		Scanner fileScan = new Scanner(new File("revisitingChapters5/oneClassMain/HelloWorld"));
		///Users/flexer/Desktop/Java/JavaWithMelvin/ ... NOT NEEDED!!
		
		while(fileScan.hasNext()) {
			url = fileScan.nextLine();
			
			System.out.println(url);
			
			/*
			 * Manipulation!
			 * 
			Scanner urlScan = new Scanner(url);
			urlScan.useDelimiter("/");
			
			//scanner will scan the whole content
			
			
			while(urlScan.hasNext()) { //if urlScan has tokens true, else false
				
				System.out.print("    " + urlScan.next());
				System.out.println();
				
			}
			 */
			
		}
		
	}
	
}
