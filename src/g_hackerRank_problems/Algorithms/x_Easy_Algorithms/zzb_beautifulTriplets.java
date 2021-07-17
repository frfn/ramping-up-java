package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class zzb_beautifulTriplets {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1); l.add(2); l.add(4); l.add(5); l.add(7); l.add(8); l.add(10);
        System.out.println(hashSetBeautifulTriplets(3, l));
    }

    public static int hashSetBeautifulTriplets(int d, List<Integer> arr) {
        HashSet<Integer> set = new HashSet<>(arr);
        int count = 0;

        for (int number : arr) {
            if (set.contains(number + d) && set.contains(number + (d * 2))) {
                count++;
            }
        }
        return count;
    }

    public static int beautifulTriplets(int d, List<Integer> arr) {
        /*
        if
        i < j < k
        a[j] - a[i] == a[k] - a[j] == d

        basically saying whats the sequence, given d, just scan for next possible solution

        1 2 4 5 7 8 10
         */
        ArrayList<Integer> list;
        int possibleTriplets = 0;

        for(int i = 0; i < arr.size(); i++) {
            list = new ArrayList<>();

            int tempNum = arr.get(i); // get num from arr
            list.add(tempNum); // add it to list automatically, default size = 1

            // list = [ 1,
            for(int j = i + 1; j < arr.size(); j++) {
                if(tempNum + d == arr.get(j)) {
                    tempNum = arr.get(j);
                    list.add(arr.get(j));

                    if(list.size() == 3) {
                        possibleTriplets++;
                        list.clear();
                        break;
                    }
                }
            }

        }

        return possibleTriplets;
    }


}
