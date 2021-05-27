package h_leetCode_problems;

public class y_numberOfIslands {
    /* This is now in f_recursive, it is a matrix recursive problem! -- Important for learning */
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int counter = 0;

        // go through matrix
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {

                if(grid[i][j] == '1') { // we hit an island..
                    markIsland(grid, i, j); // this method marks the 1s as 0s ( 0s is just a place holder )
                    counter++;
                }

            }
        }
        return counter;
    }
    public void markIsland(char[][] grid, int i, int j) {

        // you MUST use greater than or equal to when comparing the the max length, if not you will be met with an out of bounds error
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length  || grid[i][j] != '1') return;

        grid[i][j] = '0';

        // this is the recursive calls, understanding this will help your journey.
        markIsland(grid, i+1, j);
        markIsland(grid, i-1, j);
        markIsland(grid, i, j+1);
        markIsland(grid, i, j-1);

    }
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '1', '1'},
                {'1', '0', '1'},
                {'1', '1', '0'},
            };

        y_numberOfIslands obj = new y_numberOfIslands();
        System.out.println("Number of Islands: " + obj.numIslands(matrix));
    }
}
