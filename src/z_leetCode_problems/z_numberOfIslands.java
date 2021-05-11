package z_leetCode_problems;

public class z_numberOfIslands {

    private int m, n; //

    public int numIslands(char[][] grid) {

        int count = 0; // how many islands

        // length of grid
        n = grid.length;
        if (n == 0) return 0; // base case

        m = grid[0].length;



        // iterate, no escaping 2 for loops since 2D matrix
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)

                // if at we hit a one, start marking
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j); // this will mark the site visited with 0
                    ++count;
                }
        }

        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        // if the position is less than length   OR
        // we pass the length of our grid        OR
        // if the position is NOT 1              then RETURN
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;

        grid[i][j] = '0'; // visited

        // how?
        // i = row
        // j = item IN row
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'1', '1', '0'},
            };

        z_numberOfIslands obj = new z_numberOfIslands();
        System.out.println("Number of Islands: " + obj.numIslands(matrix));
    }

}
