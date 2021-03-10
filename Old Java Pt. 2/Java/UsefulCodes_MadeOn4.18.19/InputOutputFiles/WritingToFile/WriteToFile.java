package WritingToFile;
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

public class WriteToFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("text2");  // created a file object
		
		file.canRead();  file.canWrite();  file.canExecute();
		
		if(file.exists()) {  // if file exists
			System.out.println("File exists...");
		}
		else {
			file.createNewFile();  // if not create file
		}
		
		/**
		 * FileWriter
		 *  - Needs a file object
		 *  - Enabling file object to be used with Writer objects
		 *  - Important, boolean value at the end SIGNIFIES if you can append or not
		 */
		
		FileWriter fw = new FileWriter(file, true);
		
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
		
		pw.println("Hello there! I am writing on this text");  // for you to write on this text, you will NEED TO CLOSE the writer objects
		
		/**
		 * Close Object writers
		 */
		
		pw.close();
		bw.close();
		fw.close();
		
	}
	
}
