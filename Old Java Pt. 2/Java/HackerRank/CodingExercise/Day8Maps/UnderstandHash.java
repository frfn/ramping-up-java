package Day8Maps;

import java.util.HashMap;
import java.util.Map;

public class UnderstandHash {
	
	
	public static void main(String[] args) {
		
		int[] theArray = {2, 1, 6, 3, 6, 3, 1, 1, 6, 5, 5, 5, 9};  // just an array full of integer elements
		
		  Map<Integer, Integer> counts = new HashMap<>();  // new HashMap, new container
		  
		 // Integer count = counts.get(theArray[0]); this gives us null

		 //System.out.println(count);
		  
		  for (int item : theArray) {  // for each item in theArray, the element will be item 
			  
		      Integer count = counts.get(item);  // new variable called count, it will get the VALUE of current key, which is NULL the first round
		      
		      
		    //  System.out.println(count);
		      
		      
		      int incrementedCount = (count == null) ? 1 : count + 1;  // return 1! 
		      
		      
		      
		      counts.put(item, incrementedCount);  // hash maps does NOT have duplicates, they can have duplicate values however
		  }
		  
		  System.out.println(counts);
		  
		  /**
		   * I get it but this will not work!
		   * 
		   *   
		  System.out.println(counts.get(1));
		  
		  int[] arr = new int[theArray.length];
		  int currentScoreIndex = 0;
		  
		  for(int i = 1; i < theArray.length; i++) {
			  int data = counts.get(i);  // will return 3
			 
			  
			  for(int j = 0; j < data; j++) {  // j 
				  arr[currentScoreIndex] = data;
				  currentScoreIndex++;
			  }
			  
		  }
		   */
		
			 			  
		  }
	
	
		  
		  
		  
	
	
	// Under will populate the NEW ARRAY!!
	
	/**
	 * public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

	    // array of 0s at indices 0..highestPossibleScore
	    int[] scoreCounts = new int[highestPossibleScore + 1];
	
	    // populate scoreCounts
	    for (int score : unorderedScores) {
	        scoreCounts[score]++;
	    }
	
				--// HERE //--
	
	    // populate the final sorted array
	    int[] sortedScores = new int[unorderedScores.length];
	    int currentSortedIndex = 0;
	
	    // for each item in scoreCounts
	    for (int score = highestPossibleScore; score >= 0; score--) {
	        int count = scoreCounts[score];
	
	        // for the number of times the item occurs
	        for (int occurrence = 0; occurrence < count; occurrence++) {
	
	            // add it to the sorted array
	            sortedScores[currentSortedIndex] = score;
	            currentSortedIndex++;
	        }
	    }
	
	    return sortedScores;
		}
	 */
	
	
	
}
