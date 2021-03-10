package InsertionSort;
public class Insertionsort {   
	// Standard array
	public static void main(String[] args) {
		int[] ls = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		for(int i=0; i<ls.length; ++i) {
			System.out.print(ls[i] + ", ");
		}
		insertionsort(ls);
		System.out.print("\n\n");
		for(int i=0; i<ls.length; ++i) {
			System.out.print(ls[i] + ", ");
		}
	}
	public static void insertionsort(int[] array) {
		for(int i=1; i<array.length;++i) {	
			for(int j=i-1; j>-1;--j) {	
				if(array[j+1] < array[j]) {
					swap(array, j+1, j);
				}
				else {
					break;
				}
			}
		}
	}
	public static void swap(int[] array, int num, int num2) {
		int temp = array[num];
		array[num] = array[num2];
		array[num2] = temp;
	}
}
