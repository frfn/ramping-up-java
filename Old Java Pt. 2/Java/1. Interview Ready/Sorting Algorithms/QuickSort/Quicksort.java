package QuickSort;
public class Quicksort {
	public static void main(String[] args) {
		int[] list = {10, 9, 8, 7, 6};
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ", ");
		}
		quicksort(list, 0, list.length-1);
		System.out.print("\n\n");
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ", ");
		}
	}
	public static int partition(int[] Array, int start, int end) {
		int pivot = Array[end];
		int partitionIndex = start;
		
		for (int i = start; i <= end; i++) {
			if (Array[i] < pivot) {
				swap(Array, i, partitionIndex);
				++partitionIndex;
			}
		}
		swap(Array, end, partitionIndex);
		return partitionIndex;
	}
	public static void quicksort(int[] Array, int start, int end) {
		if (start <= end) {
			int pi = partition(Array, start, end);
			quicksort(Array, start, pi-1);
			quicksort(Array, pi+1, end);
		}
	}
	public static void swap(int[] Array, int num, int num2) {
		int temp = Array[num];
		Array[num] = Array[num2];
		Array[num2] = temp;
	}
}
