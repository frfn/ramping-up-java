package MergeSort;

/**
 * I'm most happy with this one, it works amazingly. 
 * The logic is the same for all iteration of it, just that the parameters can change and methods.
 * @author Flexer
 *
 */

public class Mergesort {
	public static void main(String[] args) {
		int[] ls = {10, 9, 65, 4, 7, 3, 79, 1};
		for(int i=0; i<ls.length; ++i) {
			System.out.print(ls[i] + ", ");
		}
		mergesort(ls);
		System.out.print("\n\n");
		for(int i=0; i<ls.length; ++i) {
			System.out.print(ls[i] + ", ");
		}
	}
	public static void merge(int[] array, int[] left, int[] right) {
		int i, j, k;
		i=j=k=0;
		while (i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				array[k++]=left[i++];
				//++i;
			}
			else {
				array[k++]=right[j++];
				//++j;
			}
			//++k;
		}
		while (i < left.length) {
			array[k++]=left[i++];
			//++i;
			//++k;
		}
		while (j < right.length) {
			array[k++]=right[j++];
			//++j;
			//++k;
		}
	}
	public static void mergesort(int[] array) {
		if (array.length == 1) {
			return;
		}
		
		int middle = array.length / 2;
		
		
		int[] left = new int[middle];
		int[] right = new int[array.length - middle];
		
		// populate left array
		for(int i=0; i<middle; ++i) {
			left[i]=array[i];
		}
		
		// populate right array - Note: length is different as well as position of index in the array
		for(int i=0; i<array.length-middle; ++i) {
			right[i]=array[middle+i];
		}
		
		mergesort(left);
		mergesort(right);
		merge(array, left, right);
	}
}
