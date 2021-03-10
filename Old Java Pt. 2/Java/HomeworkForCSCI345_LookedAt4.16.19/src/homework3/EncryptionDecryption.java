package homework3;
import java.util.Scanner;

public class EncryptionDecryption {
	
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		/////////////////////
		//	Keys – Length  //
		/////////////////////
		
		///////////////////////////////////////////////////////////
		System.out.println("Homework Assignment 2...");
		
		int[] key;
		
		System.out.print("Please enter key length: ");
		int length = scan.nextInt(); //getting the length
		
		key = new int[length]; // KEY = LENGTH
		
		for(int i = 0; i < key.length; i++) {
			System.out.print("Enter the key: ");
			key[i] = scan.nextInt();
		}
		////////////////////////////////////////////////////////////
		
		//Printing out elements in array
		System.out.print("Key/s to be used: ");
		for(int i = 0; i < key.length; i++) {
			System.out.print(key[i] + " ");
		}
		
		/////////////////////
		//  Size of Input  //
		/////////////////////
		
		System.out.println();
		
		////////////////////////////////////////////////////////////
		System.out.print("Enter size of input (in blocks): ");
		int plaintext = scan.nextInt();
		
		int[] blocks; //BLOCKS = PLAINTEXT
		
		blocks = new int[plaintext]; 
		
		for(int i = 0; i < blocks.length; i++) {
			System.out.print("Enter plain text blocks: ");
			blocks[i] = scan.nextInt();
		}
		////////////////////////////////////////////////////////////
		
		//Printing out elements in array
		System.out.print("Plain text: ");
		
		for(int i = 0; i < blocks.length; i++) {
			System.out.print(blocks[i]);
		}
		
		//////////////////////
		//  Initialization  //
		//////////////////////
		System.out.println();
		int[] S = new int[256];
		int[] T = new int[256];
		
		for(int i = 0; i <= 255; i++) {
			S[i] = i;
			T[i] = key[i % key.length];
			
		}
		
		/*Initial Permutation of S*/
		int j = 0;
		for(int i = 0; i <= 255; i++) {
			j = (j + S[i] + T[i]) % 256;
			swap(S[i], S[j]);
		}
		
		/*Stream Generation*/
		int i = 0, t, k = 0;
		j = 0;
		int count = 0;
		while(count <= blocks.length) {
			i = (i + 1) % 256;
			j = (j + S[i]) % 256;
			swap(S[i], S[j]);
			t = (S[i] + S[j]) % 256;
			k = S[t];
			count++;
		}
		
		
		
		
	}
	
	public static void swap(int a, int b) {
		
		int temp;
		
		temp = a;
		a = b;
		b = temp;
		
	}
}
