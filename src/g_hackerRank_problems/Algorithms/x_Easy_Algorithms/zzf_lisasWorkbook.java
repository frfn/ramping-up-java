package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class zzf_lisasWorkbook {

    public static void main(String[] args) {
        List<Integer> probs = new ArrayList<>();
        probs.add(4); probs.add(2); probs.add(6); probs.add(1); probs.add(10);
        System.out.println(workbook(5, 3, probs));
    }

    /*
    * A problem is special if its index in the chapter is the same as the page number
    *
    * there are N chapters , 1 to n
    *
    * ith chapter has arr[i] problems, numbered from 1 to arr[i]
    *
    * page can hold up (k) problems , only a chapters LAST PAGE can contain fewer than k problems
    *
    * each new chapter STARTS on a NEW page, so a page will NEVER contain problems MORE THAN on chapter
    *
    * the page indexing starts at 1
    *
    *
    * when its FALSE stop loop :)
    */


    /*
    Example

    arr = [0, 4, 2]
    k = 3

    arr[1] = 4 problems for chapter 1
    arr[2] = 2 problems for chapter 2
    ...
    etc.

    Looks like we need a page counter
    Might look at modulo operator
    if / else statements

     */
    public static int workbook(int n, int k, List<Integer> arr) {
        // what happens if n == 1? think about it

        int indexForArr = 0;
        int pageNum = 1;
        int specialProblem = 0;

        while(indexForArr != arr.size()) {

            for (int i = 1; i <= arr.get(indexForArr); i++) {
                if (pageNum == i) specialProblem++;
                if (i % k == 0) pageNum++;
            }

            int value = arr.get(indexForArr);

            // I was skipping a page... again, this is the check that we need
            if(value % k != 0) { // if 6 % 3 != 0 --> 0 != 0? --> false --> this is the validator, do we move on to "next page?"
                pageNum++;
            }
            indexForArr++;
        }
        return specialProblem;
    }

}
