package f_recursion.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*

Recursive Leap of Faith
        - Assume simpler cases work out
        - This is a real thing.
        - I did this… it worked. Thank god.

----------------------------------------------------------------

    Examples are for uniquePaths but the steps are for every recursive problem. ( edit this. )

    1. Simplest Possible Input? ( Base Case )
        - if m or n is 1, then the only possible answer is 1

    2. Play around with examples and visualize!
        create different super basic examples.
        - 1x1 matrix
        - 1x2 matrix
        - 2x1 matrix
        - 2x2 matrix
        - etc.

    3. Relate hard cases to simpler ones
        in example we are given three shapes, 2x3, 3x2, 3x3
        - here with the 2x3 and 3x2, we only move down once or right once to complete the 3x3 matrix!

    4. Generalize the pattern

    5. Write the code by combining the recursive pattern with base case

*/
public class RecursionExamples {

    public static void main(String[] args) {
        /* -------------------------------------- */

        // Matrix Problem
        // char[][] charGrid = {
        //         {'0', '0', '1'},
        //         {'0', '0', '1'},
        //         {'1', '0', '1'},
        // };

        // int[][] intGrid = {
        //         {0, 0},
        //         {0, 0},
        // };


        // GridProblems gp = new GridProblems();
        // System.out.println("# of ways: "+gp.uniquePathsWithConstraints(intGrid));
        // System.out.println("Islands: "+gp.numOfIslands(charGrid));

        /* -------------------------------------- */

        // Foundation f = new Foundation();
        // System.out.println("Factorial of 5: "+f.factorial(5));

        /* -------------------------------------- */

        // DynamicProgramming dp = new DynamicProgramming();

        // int target = 5;

        // memoization for fibo
        // you must increase by one bc the target is equivalent to the index
        /* 5 elements in an array has 4 index, so +1 to make it to 5 index */
        // int[] memo = new int[target+1];

        // System.out.println("Memo Fibonacci: "+dp.fibonacciMemo(memo, target));

        // tabulation for fibo
        // System.out.println("Tab Fibonacci: "+dp.fibonacciTab(target));

        /* ------- DP ------- */

        // Knapsack problem
        /* the 0 is intended, we start at 0 index, even though there are 4 elements */
        int[] values = {0,1,2,5,6};
        int[] weight = {0,2,3,4,5};
        int capacity = 8; // weight limit
        int length = 4; // how many elements we are looking at
        int[][] tableForKnapSack = new int[length+1][capacity+1]; // why +1? We will take into account the 0 spot

        int[][] table = DynamicProgramming.knapsackTabulation(weight,values,capacity,length,tableForKnapSack);

        for(int[] row: table){
            System.out.println(Arrays.toString(row));
        }

        System.out.println();

        for(List<Integer> results: DynamicProgramming.itemsToPutInBag(table,length,capacity,weight)) {
            for(int result : results) {
                System.out.print(result + ", ");
            }
            System.out.println();
        }
    }
}

class Foundation {
    public int factorial(int num) {
        if(num == 1) return 1;
        return num * factorial(num-1);
    }

}
class GridProblems {

    // using default constructor!

    //--------------//
    // # of islands //
    //--------------//
    public int numOfIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int counter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    isIsland(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }
    private void isIsland(char[][] grid, int i, int j) {
        if(
            i < 0 || i >= grid.length // why >= ? well, because if we go on index[3] and our array length 3
         || j < 0 || j >= grid[i].length // ... issue, there is nothing at index 3 since our array length is 3, it will only be 0,1,2!!
         || grid[i][j] != '1'            // this is checking for out of bounds error! Woohoo!

        ) return;

        grid[i][j] = '0';
        isIsland(grid, i+1, j);
        isIsland(grid, i-1, j);
        isIsland(grid, i, j+1);
        isIsland(grid, i, j-1);
    }

    //----------------------------------------------------------------//
    // unique paths: you can only move down or right 1 unit at a time //
    //----------------------------------------------------------------//
    public int uniquePathsWithConstraints(int[][] grid) {
        if(grid.length == 0) return 0;
        if(grid.length == 1 || grid[0].length == 1) return 1;

        return paths(grid, 0, 0); // we start at top left

    }
    private int paths(int[][] grid, int i, int j) {
        if(i < 0
                || j < 0
                || i >= grid.length
                || j >= grid[i].length)
            return 0; // why 0? I don't want to return a value just because we go out of bounds

        if(i == grid.length-1
                && j == grid[i].length-1)
            return 1; // I want to return a value when I hit the end

        // The portion below becomes the Recursive Leap of Faith, just see if it works.

        // just because there's only TWO statements here ... it goes through EACH as expected
        // I learned this approach because I have seen how the # of islands question work
        int down = paths(grid, i + 1, j);
        int right = paths(grid, i, j + 1);

        /*
        0 0
        0 0
         */

        return down + right;
    }
}
class DynamicProgramming {
    /*

    Dynamic Programming is just a fancy name for breaking a problem down into
    something small and reusing the solutions from the smaller problems to
    avoid solving them more than once.

    What we get from it?
    - Optimized Solution by storing ( caching ) values for future use
    - Improved runtime for recursion

    Two Ways.
    - Top Down  - (memoization)  -> recursive and less efficient
    - Bottom Up -  (tabulation)  -> iterative and more efficient

    */

    // Memoization ( Top Down Approach - memoization, a memo, a note to self approach )
    public int fibonacciMemo(int[] memo, int num){
        if(num <= 1) return num;

        if(memo[num] != 0) return memo[num];

        int value1 = fibonacciMemo(memo, num - 2);
        int value2 = fibonacciMemo(memo, num - 1);

        memo[num] = value1 +  value2; // value1 + value2 is fibValue!

        return value1 + value2;

    }

    // Tabulation ( Bottom Up Approach - starting with smaller values and calculating larger values )
    public int fibonacciTab(int num) {
        if(num <= 1) return num;

        int[] bottomUp = new int[num+1];
        bottomUp[1] = 1;
        bottomUp[2] = 1;

        for(int i = 3; i < bottomUp.length; i++) {
            bottomUp[i] = bottomUp[i - 2] + bottomUp[i - 1]; // using values that we already have information about
        }

        return bottomUp[num];
    }

    // KnapSack tabulation!
    /* https://www.youtube.com/watch?v=zRza99HPvkQ&ab_channel=AbdulBari | best explanation ever. */
    public static int[][] knapsackTabulation(int[] weight, int[] values, int capacity, int length, int[][] table) {

        for(int i = 0; i <= length; i++) { // i == the index | the rows

            for (int w = 0; w <= capacity; w++) { // w == the weight | the columns

                // table[i][w] will store the PROFIT, not the weight

                // 1st condition
                if(i == 0 || w == 0) {
                    table[i][w] = 0;
                }

                // 2nd condition | the main
                else if (weight[i] <= w) {
                    table[i][w] = Math.max( // grab the bigger number of two
                                    values[i] + table[i-1][w-weight[i]], // profit + the value already in table
                                    table[i-1][w]
                                    );
                }

                // 3rd condition | if weight[i] > than current w, then use previous data at index [i-1][w]
                else {
                    table[i][w] = table[i-1][w];
                }

            }

        }
        return table;
    }
    public static List<List<Integer>> itemsToPutInBag(int[][] knapSackTable, int length, int capacity, int[] weight) {
        List<Integer> bag = new ArrayList<>();
        List<Integer> whatWeAdded = new ArrayList<>();
        List<List<Integer>> returnThis = new ArrayList<>();

        // length == index of array | the rows
        // capacity == max limit of bag | weight
        int i = length;   // index
        int j = capacity; // weight

        while(i > 0 && j > 0) {
            if(knapSackTable[i][j] == knapSackTable[i-1][j]) {
                i--;
                whatWeAdded.add(0);
            }else {
                bag.add(weight[i]);
                j = j-weight[i];

                i--;
                whatWeAdded.add(1);
            }
        }

        if(whatWeAdded.size() != length) {
            whatWeAdded.add(0,0);
        }

        returnThis.add(bag);
        returnThis.add(whatWeAdded);

        return returnThis;
    }


    // Coin Change!


}