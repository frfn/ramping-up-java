package Day8Maps;

public class CountingSort {
	
	public static int[] sort(int[] scores, int highScore) {
		
		int[] scoreCount = new int[highScore + 1];
		
		// this portion fills the whole entire array if needed
		
		for (int data : scores) {
			scoreCount[data]++;  // that empty array space, if 0, plus 1, and so on
		}
		
		// this portion has the needed values from above
		
		int[] sortedScores = new int[scores.length];  // correct size of array
		
		int currentScoreIndex = 0;  // so that it moves the index after filling the empty array space, iterator
		
		for (int i = highScore; i >= 0; i--) {  // sort from highest to lowest
			
			int count = scoreCount[i];  // if scoreCount[100] = 0
			
			for(int j = 0; j < count; j++) {  // if 0 < 0 , it DOESN'T even touch this part
				
				
				sortedScores[currentScoreIndex] = i;  // it is the value OF THE OUTER for loop that will go in
				currentScoreIndex++;  // move index!!
				
			}
		}
		return sortedScores;
	}
	
	public static void main(String[] args) {
		
		int[] list = {2, 4, 5, 1, 5, 3, 1, 5, 6};
		
		int[] data = sort(list, 10);
		
		for(int view : data) {
			System.out.println(view);
		}
		
	}
	
}
