package createReadWriteFile;
import java.io.*;

/**
 * 
 * @author Flexer
 *
 *
 * Checked exceptions!!
 *  - All this means is that it needs to be checked before runtime
 *  - The only unchecked exceptions are the runtime exceptions
 *    and any of their dependents (exception classes that are made from them!)
 */

public class NewFile {
	
	static File newFile = new File("new_text.txt");
	
	
	public static void main(String[] args) throws IOException{
		
		newFile.canRead(); newFile.canWrite(); newFile.canExecute();
	
			if(newFile.createNewFile()) {
				System.out.println("File is created...");
			}else {
				System.out.println("Already created...");
			}
			
			
		/**
		 * FileWriter
		 *  - Needs a file object
		 *  - Enabling file object to be used with Writer objects
		 *  - Important, boolean value at the end SIGNIFIES that you can append
		 */
		
		FileWriter fw = new FileWriter(newFile, true);
		
		/**
		 * Buffered Writer
		 * 	- The argument needs to be a writer object
		 *  - Good practice for buffering files, text, etc
		 */
		BufferedWriter bw = new BufferedWriter(fw);
		
		/**
		 * PrintWriter
		 *  - Parameter needs a writer object
		 *  - Adds more methods and services to writing on text
		 */
		
		PrintWriter pw = new PrintWriter(bw);
		
		
		
		pw.println("Multiplication table below!\n");
		
		for(int i = 1; i <=12; i++) {
			for(int j = 1; j <= 12; j++) {
				pw.print(i * j + "\t");
			}
			pw.println();
		}
		
		
		pw.close();
		bw.close();
		fw.close();
		
		

		writeHello("new_text.txt", "Hello!!");
		
		writeHello("new_text.txt", "Hello!!");
		
		writeHello("new_text.txt", "Hello!!");
		
		writeHello("new_text.txt", "Hello!!");

		
		System.out.println("Exists?: " + newFile.exists());
		
	}
	
	public static void writeHello(String filePath, String text) throws IOException {
		File file = new File(filePath);
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.print(text);
		
	
		pw.close();
		bw.close();
		fw.close();
	}

}
