package chapter5;

import java.util.Scanner;
import java.io.*;

public class ReadingAFile {
	
	static String url;
	//static so we can use it in the main
	
	public static void main(String[] args) throws IOException {
		
		Scanner fileScan = new Scanner(new File("/Users/flexer/Desktop/Java/JavaWithMelvin/testingsForMeToDo/chapter5/printMe.txt"));
		//You can NOT create file scanners without throwing a type of exception
		
		while(fileScan.hasNext()) { //.hasNext returns a boolean value
									//if file has tokens/string object = true
									//else 							   = false
			
			url = fileScan.nextLine();
			
			//url will have the content
			
			System.out.println("Dumping memory content: " + url);
			
			Scanner urlScan = new Scanner(url);
			urlScan.useDelimiter("/");
			
			//scanner will scan the whole content
			
			
			while(urlScan.hasNext()) { //if urlScan has tokens true, else false
				
				System.out.print("    " + urlScan.next());
				System.out.println();
				
			}
			
		}
		
		
		
	}

}
