package homework3;
import java.util.Scanner;
public class HomeworkAssignment2 {
	
	static Scanner scan = new Scanner(System.in);
	static int[] S = new int[256];
	static int[] T = new int[256];
	static int[] K;
	static int[] plaintext;
	static int i, j, t, k;
	static int[] cipher;
	static int[] decrypt;
	
	public static void main(String[] args) {
		
		System.out.print("Please enter key length: ");
		int length = scan.nextInt();
		
		K = new int[length];
		
		for(int i = 0; i < K.length; i++) {
			System.out.print("Enter the key: ");
			K[i] = scan.nextInt();
		}
		
		
		
		
		///////////
		
		System.out.println();
		
		System.out.print("Enter the size of input (in blocks): ");
		int input = scan.nextInt();
		
		plaintext = new int[input];
		
		//the cipher and decryption 
		cipher = new int[input];
		decrypt = new int[input];
		
		for(int i = 0; i < plaintext.length; i++) {
			System.out.print("Enter the plain text blocks: ");
			plaintext[i] = scan.nextInt();
		}
		
		System.out.print("Plain text: ");
		for(int plaintextValues: plaintext) {
			System.out.print(plaintextValues);
		}
		
		//Calling methods//
				initialization();
				
				
				
				initOfS();
				
				
				
				streamGeneration();
				
	}
	
	public static void initialization() {
		for(int i = 0; i <= 255; i++) {
			S[i] = i;
			T[i] = K[i % K.length];
		}
		
	}
	
	public static void initOfS() {
		j = 0;
		for(int i = 0; i <= 255; i++) {
			j = (j + S[i] + T[i]) % 256;
			swap(S[i], S[j]);
		}
	}
	
	public static void streamGeneration() {
		i=j=0;
		// t = z
		int counter = 0;
		while(counter < plaintext.length) {
			i = (counter + 1) % 256;
			j = (j + S[i]) % 256;
			swap(S[i], S[j]);
			t = (S[i] + S[j]) % 256;
			k = S[t];
			
			cipher[counter] = t^plaintext[counter]; //^ means XOR
			decrypt[counter] = t^cipher[counter];
			
			counter++;
		}
		
		System.out.println();
		System.out.print("Cipher text: ");
		display(cipher);
		
		System.out.println();
		System.out.print("Decrypted text: ");
		display(decrypt);
		
		
	}
	
	public static void display(int[] display) {
		int[] convert = new int[display.length];
		
		for(int i = 0; i < display.length; i++) {
			convert[i] = display[i];
			System.out.print(convert[i]);
		}
	}
	
	public static void swap(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
	}

}
