package BinarySearch;
public class BinarySearch {

	public static void main(String[] args) {
		int[] list = {0, 2, 9, 10, 15, 20, 21, 34, 56, 78, 90, 100};
		
		for(int i=0; i<list.length;++i) {
			System.out.print(list[i] + ", ");
		}
		
		System.out.println(binarysearch(list, 0));
		
	}
	
	public static boolean binarysearch(int[] array, int targetValue) {
		int Left = 0;
		int Right = array.length-1;
		
		while (Left <= Right) {
			int Middle = (Left + Right) / 2;
			
			if (array[Middle] == targetValue) {
				return true;
			}
			if(array[Middle] < targetValue) {
				Left = Middle + 1;
			}
			if(array[Middle] > targetValue) {
				Right = Middle - 1;
			}
		}
		return false;
	}

	
	
}
