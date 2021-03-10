package homework3;
import java.util.Scanner;
public class HWAssignment2Try3 {

	static int[] K; //keys
	static int[] P; //plain text
	static int[] S = new int[256];
	static int[] T = new int[256]; //T is the other K, just a place holder
	static int i, j, t, k;
	//cipher and decrypt
	static int[] cipher; 
	static int[] decrypt;
	//variables for input
	static int length, plaintext;
	//scanner
	static Scanner scan = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		//Getting keys
		
		//ENTER KEY LENGTJ
		System.out.print("Please enter key length: ");
		length = scan.nextInt();
		
		K = new int[length]; //ASSIGNING LENGTH FOR ARRAY K
		
		for(int i=0; i<K.length; i++) {
			System.out.print("Enter the key: ");	//GETTING VALUES 
			K[i] = scan.nextInt();
		}
		
		//PRINTING OUT THE ARRAY ELEMENTS
		System.out.print("Here are the keys: ");
		for(int keys : K) {
			System.out.print(keys + " ");
		}
		System.out.println();
		
		//////////////////////////////////////////////////////////
		
		//Getting plaintext size and value
		
		//GETTING THE PLAINTEXT SIZE
		System.out.print("Enter size of input (in blocks): ");
		plaintext = scan.nextInt();
		
		P = new int[plaintext]; //ASSIGNING SIZE FOR ARRAY P
		
		//giving me error, not initialized and out of bounds
		//ALSO INITIALIZING the cipher and decrypt array
		
		cipher = new int[plaintext];
		decrypt = new int[plaintext];
		
		for(int i=0; i<P.length; i++) {
			System.out.print("Enter plain text blocks: "); //ASSIGNING VALUES FOR PLAINTEXT
			P[i] = scan.nextInt();
		}
		
		//PRINTING OUT VALUES
		System.out.print("Plain text: ");
		for(int text : P) {
			System.out.print(text);
		}
		
		/*
		 * Following the pseudo code
		 * and adding cipher and decrypt array
		 */

		System.out.println();
		/*initialization*/
		for(int i=0; i<=255; i++) {
			S[i]=i;
			T[i]=K[i % K.length];
			
			
			//System.out.print(S[i]);
			
			//System.out.print(T[i]);
		}
		
		/*initial permutation of S*/
		j=0;
		for(int i=0; i<=255; i++) {
			j=(j+S[i]+T[i]) % 256;
			//System.out.println(j);
			swap(S[i], S[j]);
		}
		
		/*stream generation*/
		i=0;
		j=0;
		int count=0;
		//for(int l=0; l<P.length; l++) {
			while(count < P.length) {
			i=(i+1) % 256;
			j=(j+S[i]) % 256;
			
			swap(S[i], S[j]);
			t = (S[i]+S[j]) % 256;
			k = S[t];
			
			//cipher and decrypt with XOR ( ^ )
			
			cipher[count]=k^(P[count]);
			decrypt[count]=k^(cipher[count]);
			count++;
		}
		
		System.out.print("Cipher text: ");
		for(int ctext : cipher) {
			System.out.print(ctext);
		}
		
		System.out.print("\nDecrypted text: ");
		for(int dtext : decrypt) {
			System.out.print(dtext);
		}
		
		
	}
	static void swap(int a, int b) {
		int temp;
		temp=a;
		a=b;
		b=temp;
			
	}

}
