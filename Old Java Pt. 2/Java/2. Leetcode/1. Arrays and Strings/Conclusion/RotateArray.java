package Conclusion;

public class RotateArray {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		for(int val: arr) {
			System.out.print(val + ", ");
		}
		
		rotate(arr, 3);
		
		System.out.println("\n");
		
		for(int val: arr) {
			System.out.print(val + ", ");
		}
		
	}
	
	public static void rotate(int[] arr, int index) {
		
		int[] rotated = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			rotated[i] = arr[i];
		}
		
		index = arr.length - index;
		
		int tempIndex = 0;
		
		for(int i = index; i < arr.length; i++) {
			arr[tempIndex++] = rotated[i]; 
		}
		
		for(int i = 0; i < index; i++) {
			arr[tempIndex++] = rotated[i];
		}
		
	}

}
