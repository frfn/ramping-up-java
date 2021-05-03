package z_hackerRank_problems;

// I made a template for the hour glass ... wow.

public class g_hourGlass2D {

    /*
    -9 -9 -9  1 1 1
     0 -9  0  4 3 2
    -9 -9 -9  1 2 3
     0  0  8  6 6 0
     0  0  0 -2 0 0
     0  0  1  2 4 0

    For input:
     -9 -9 -9 1 1 1
     0 -9 0 4 3 2
     -9 -9 -9 1 2 3
     0 0 8 6 6 0
     0 0 0 -2 0 0
     0 0 1 2 4 0
     */

    public static void main(String[] args) {
        int[][] values = {
                        {-9, -9, -9,  1, 1, 1},
                        { 0, -9,  0,  4, 3, 2},
                        {-9, -9, -9,  1, 2, 3},
                        { 0,  0,  8,  6, 6, 0},
                        { 0,  0,  0, -2, 0, 0},
                        { 0,  0,  1,  2, 4, 0},
        };
        System.out.println(getMaxHourGlass(values));
    }

    public static int getMaxHourGlass(int[][] arr) {
        if(arr.length == 0) return 0;

        int maxValue = hourGlass(arr, 0 ,0); // assign maxValue of the first hour glass value
        int[] position = new int[2];

        // accounting for the 'off by 1', in this case off by 2 since our template requires (x + 2)
        for(int row = 0; row < arr.length - 2; row++) {
            for(int indexInRow = 0; indexInRow < arr[row].length - 2; indexInRow++) {
                int totalOf = hourGlass(arr, row, indexInRow);

                // keep track of max value
                if(totalOf > maxValue) {
                    maxValue = totalOf;
                    position[0] = row;
                    position[1] = indexInRow;
                }
            }
        }

        System.out.println("Max Position at: ["+position[0]+","+position[1]+"]");

        return maxValue;
    }

    public static int hourGlass(int[][] arr, int row, int indexInRow) {
        int hourGlass;

        /*
               indexInRow
        row    num num num
                -  num  -
               num num num
         */

        // top of hourGlass
        hourGlass = arr[row][indexInRow] + arr[row][indexInRow + 1] + arr[row][indexInRow + 2];

        // middle of hourGlass
        hourGlass += arr[row + 1][indexInRow + 1];

        // bottom of hourGlass
        hourGlass += arr[row + 2][indexInRow] + arr[row + 2][indexInRow + 1] + arr[row + 2][indexInRow + 2];

        return hourGlass;
    }

}
