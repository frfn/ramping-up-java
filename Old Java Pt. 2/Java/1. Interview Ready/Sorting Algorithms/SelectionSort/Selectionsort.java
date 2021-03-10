package SelectionSort;
public class Selectionsort {
	public static void main(String[] args) {
		int[] ls = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		for(int i=0; i<ls.length; ++i) {
			System.out.print(ls[i] + ", ");
		}
		
		selectionsort(ls);
		
		System.out.print("\n\n");
		
		for(int i=0; i<ls.length; ++i) {
			System.out.print(ls[i] + ", ");
		}
	}
	
	
	// 5, 3, 4, 2, 6
	public static void selectionsort(int[] array) {
		for(int i=0; i<array.length; ++i) {
			int min_index = i;
			
			for(int j=i+1; j<array.length; ++j) {
				if(array[j] < array[min_index]) {
					min_index = j;
				}
			}
			if(min_index != i) {
				swap(array, min_index, i);
			}
		}
	}
	public static void swap(int[] array, int num, int num2) {
		int temp = array[num];
		array[num] = array[num2];
		array[num2] = temp;
	}
}
