package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.*;

public class za_migratoryBirds {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Integer> frequency = new ArrayList<>();
        for(int i = 0; i < 11; i++) {
            frequency.add(scan.nextInt());
        }

        System.out.println(migratoryBirdsBucket(frequency));
    }

    public static int migratoryBirds(List<Integer> arr) {
        if(arr.size() == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int highestFrequency = Integer.MIN_VALUE;

        for(int number: arr){
            int count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
            highestFrequency = Math.max(highestFrequency, map.get(number));
        }

        int lowestType = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == highestFrequency) {
                lowestType = Math.min(lowestType, entry.getKey());
            }
        }
        return lowestType;
    }

    public static int migratoryBirdsBucket(List<Integer> arr) {

        int[] birdFreq = new int[6]; // that is the constraint! 1,2,3,4, or 5 is guaranteed.

        // [ 1,2,3,1,4,5 ]
        // [ 0,0,0,0,0,0 ]

        int mostFreq = 0;

        for(int num: arr) {
            birdFreq[num]++;
            mostFreq = Math.max(birdFreq[num], mostFreq);
        }


        for(int i = 0; i < birdFreq.length; i++) {
            if(birdFreq[i] == mostFreq) {
                return i;
            }
        }

        return 0;
    }

}
