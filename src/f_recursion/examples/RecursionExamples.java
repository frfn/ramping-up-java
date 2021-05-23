package f_recursion.examples;

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
        /*
        char[][] charGrid = {
                {'0', '0', '1'},
                {'0', '0', '1'},
                {'1', '0', '1'},
                {'0', '0', '1'},
        };

        int[][] intGrid = {
                {0, 0},
                {0, 0},
                {0, 0},
        };
        */
        /*
        GridProblems gp = new GridProblems();
        System.out.println("# of Islands: "+gp.numOfIslands(charGrid));
        */
        /*
        Foundation f = new Foundation();
        System.out.println("Factorial of 5: "+f.factorial(5));
        */

        DynamicProgramming dp = new DynamicProgramming();

        int target = 5;

        // memoization
        // you must increase by one bc the target is equivalent to the index
        /* 5 elements in an array has 4 index, so +1 to make it to 5 index */
        int[] memo = new int[target+1];

        System.out.println("Memo Fibonacci: "+dp.fibonacciMemo(memo, target));

        // tabulation
        System.out.println("Tab Fibonacci: "+dp.fibonacciTab(target));
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
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;
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


}