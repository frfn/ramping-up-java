package FunStuff;
import java.io.*;

public class readingStuff {

	public static void main (String read[]) throws IOException {
		
		
		FileReader fr = new FileReader("/Users/flexer/Library/Mobile Documents/com~apple~TextEdit/Documents/TestFile.txt");
		BufferedReader br = new BufferedReader(fr);
		
		int load;
		char characters;
		
		while((load = br.read()) != -1) {
			characters = (char)load;
			
			System.out.print(characters);
		}
		
		
	}
		
}
