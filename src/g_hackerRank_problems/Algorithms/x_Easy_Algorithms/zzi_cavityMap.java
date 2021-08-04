package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;

import java.util.List;

public class zzi_cavityMap {

    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();
        grid.add("1112");
        grid.add("1912");
        grid.add("1892");
        grid.add("1234");


        for(String row: cavityMap(grid)) System.out.println(row);
    }

    public static List<String> cavityMap(List<String> grid) {
       List<String> cavities = new ArrayList<>();
       StringBuilder sb = new StringBuilder();

       for(int i = 0; i < grid.size(); i++) {                   // column
           for(int j = 0; j < grid.get(i).length(); j++) {      // row

               if((i != 0 && i != grid.size() - 1) && (j != 0 && j != grid.get(i).length() - 1)) {

                   int currentNumber = Character.getNumericValue(grid.get(i).charAt(j));

                   int num1 = Character.getNumericValue(grid.get(i+1).charAt(j));
                   int num2 = Character.getNumericValue(grid.get(i-1).charAt(j));
                   int num3 = Character.getNumericValue(grid.get(i).charAt(j+1));
                   int num4 = Character.getNumericValue(grid.get(i).charAt(j-1));

                   if(currentNumber > num1 && currentNumber > num2 &&
                       currentNumber > num3 && currentNumber > num4
                   ) {
                       sb.append("X");
                   }
                   else {
                       sb.append(currentNumber);
                   }
               } else {
                   sb.append(grid.get(i).charAt(j));
               }
           }
           cavities.add(sb.toString());
            sb.setLength(0);
       }
       return cavities;
    }
}
