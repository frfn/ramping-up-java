package RestudyHash;

public class CountingSortWithArray {
	
	public static void main(String[] args) {
		
		int[] set = {2,3,1,4,8,4,3,8,2,9,1,5,10,5};
		countingSort(set, 10);
		
		
	}
	
	public static void countingSort(int[] arr, int bound) {
		
		int[] fillingArray = new int[bound + 1];  // this is base on filling the index, if up to 10 -- 0, 1, 2, ... and so on.
		
		for(int valueOfArr : arr) {
			fillingArray[valueOfArr]++;  // if value is 5, then it will fill spot 5!
		}
		
		/*
		 * int ii = 0; for(int val : fillingArray) { System.out.print(ii + "-" +val +
		 * ", "); ii++; }
		 */
		
		int[] sortingArray = new int[arr.length];  // this is base on accurate population, if value up to 30, but only has length of 5, it will populate accordingly
		int index = 0; // the index to move in the sortingArray
		
		for(int i = 0; i <= bound; i++) {
			int valueInsideFillingArray = fillingArray[i];  // will have filling array value
			
			for(int j = 0; j < valueInsideFillingArray; j++) {
				sortingArray[index] = i;
				index++;
			}
		}
		
		for(int print : sortingArray) {
			System.out.print(print + ", ");
		}
		
	}

}
