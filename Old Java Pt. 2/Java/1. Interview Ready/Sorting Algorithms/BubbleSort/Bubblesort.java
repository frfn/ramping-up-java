package BubbleSort;
public class Bubblesort {
	// Standard printing of Arrays
	public static void main(String[] args) {
		int[] ls = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		for(int i=0; i<ls.length; ++i) {
			System.out.print(ls[i] + ", ");
		}
		bubblesort(ls);
		System.out.print("\n\n");
		for(int i=0; i<ls.length; ++i) {
			System.out.print(ls[i] + ", ");
		}
	}
	// Swapping of variables inside array, notice three elements are passed in
	public static void swap(int[] array, int num, int num2) {
		int temp = array[num];
		array[num] = array[num2];
		array[num2] = temp;
	}
	// Bubble sort method
	public static void bubblesort(int[] array) {
		boolean sorted = false;
		
		// while not sorted
		while (!sorted){
			sorted = true;
			
			// for length of array, if i+1 < i, swap.
			// pushes the greatest element to the end and re-loops.
			for(int i=0; i<array.length-1; ++i) {
				if(array[i+1] < array[i]) {
					swap(array, i+1, i);
					sorted = false;
				}
			}
		}
	}
}