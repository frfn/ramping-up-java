package z_hackerRank_problems;

import java.util.HashMap;

public class d_matchingPair {

    public static void main(String[] agrs) {

        System.out.println(pairs(8, new int[] {1, 2, 1, 2, 1, 2, 1, 2}));

    }

    public static int pairs(int numOfItems, int[] arrOfItems) {
        HashMap<Integer, Integer> collection = new HashMap<>();
        int pairings = 0;
        for(int i = 0; i < numOfItems; i++) {
            if(collection.containsKey(arrOfItems[i])){
                collection.put(arrOfItems[i], collection.get(arrOfItems[i]) + 1);
                if(collection.get(arrOfItems[i]) == 2) {
                    pairings++;
                    collection.remove(arrOfItems[i]);
                }
            }
            else {
                collection.put(arrOfItems[i], 1);
            }
        }
        return pairings;
    }
}

/*
Baby Answer: n^2
// size is 6
// [1, 2, 1, 2, 1, 1]
int pairOfSocks = 0;
for(int i = 0; i < n; i++) {
    if(ar[i] == 0) {
        continue;
    }
    int pairOne = ar[i];
    for(int j = i + 1; j < n;j++ ) {
        int pairTwo = ar[j];
        if(pairOne == pairTwo) {
            pairOfSocks++;
            ar[j] = 0;
            break;
        }
    }
}
return pairOfSocks;
 */
