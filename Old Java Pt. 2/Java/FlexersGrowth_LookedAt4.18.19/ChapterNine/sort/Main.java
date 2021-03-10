package sort;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		
		int[] arr = {4, 5, 1, 10, 2, 5};
		
		for(int array: arr) {
			System.out.println(array);
		}
		
		System.out.println();
		
		selectionSortwINT.selectionSort(arr);
		
		for(int array: arr) {
			System.out.println(array);
		}
		/*
		 * for(int i = 0; i < arr.length; i++) { System.out.println(arr[i]); }
		 */
		
	}

}

/** Rightpoint code
 * for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				System.out.println("right");
			}
			
			if(i % 5 == 0) {
				System.out.println("point");
			}
			
			if(i % 5 == 0 && i % 3 == 0) {
				System.out.println("rightpoint");
			}
			
			System.out.println(i);
		}
		
		**Test**
		*	- Coding if the code were similar to Python/C++
		
		Scanner scan = new Scanner(System.in);
		
		String name = "flexer";
		int counter = 2;
		
		System.out.print("Guess my name, you have three tries: ");
		String guess = scan.nextLine();
		
		while(!guess.equals(name) && counter > 0){
			
			System.out.print("Wrong name, enter again, you have " + counter + " more tries: ");
			guess = scan.nextLine();
			counter--;
		}
		
		if(guess.equals(name)) {
			System.out.println("You win!");
		}else {
			System.out.println("You lose!");
		}
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			if(i == 2) {
				System.out.println("Number Three");
				i++;
			}
		}
		
 */
