package arrayTests;

public class switchThem {
	
	public static void main(String[] args) {
		
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] array2 = {6, 7, 8, 9, 10, 0, 0, 0};
		
		System.out.print("Array 1: ");
		for(int view: array) {
			System.out.print(view + "\t");
		}
		
		System.out.println();
		
		System.out.print("Array 2: ");
		for(int view2: array2) {
			System.out.print(view2 + "\t");
		}
		
		SwitchThem(array, array2);
		
		System.out.println();
		System.out.println();
		
		System.out.print("Array 1: ");
		for(int view: array) {
			System.out.print(view + "\t");
		}
		
		System.out.println();
		
		System.out.print("Array 2: ");
		for(int view2: array2) {
			System.out.print(view2 + "\t");
		}
		
		
	}
	
	public static void SwitchThem(int[] arr, int[] arr2) {
		
		int[] temp = new int[arr.length]; //new Array
		
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i]; // Temp will get Array 1
		}
		
		for(int i = 0; i < arr2.length; i++) {
			arr[i] = arr2[i]; // Array 1 will get Array 2 contents
		}
		
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = temp[i];
		}
		
	}

}
