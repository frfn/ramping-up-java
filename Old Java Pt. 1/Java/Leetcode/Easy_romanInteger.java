package Leetcode;

import java.util.HashMap;

public class Easy_romanInteger {

    public static void main(String[] args) {
        int num = romanToInt("VX");
        System.out.println(num);
    }

    public static int romanToInt(String s) {

        // Add Roman Numerals into a map
        HashMap<Character, Integer> map = new HashMap<>();
        int total = 0;

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        // Split the string into chars
        char[] stringArray = s.toCharArray();

        // Add the first roman integer to total
        total += map.get(stringArray[0]);

        // Many are working here, start to have a feel of what's happening
        // current and previous to keep track
        for(int i = 1; i<stringArray.length; i++){

            int current = map.get(stringArray[i]);  // gets a char value, and if has value then assign to current, I = 1;
            int previous = map.get(stringArray[i-1]);  // this is here FOR comparison!!

            // this is where the meat happens, this is how the IV = 4, IX = 9 is calculated, genius really.
            if(previous < current){
                total -= previous * 2;
            }

            total += current;

            /**
             * if arg is IX
             * total = 0
             * total += map.get('I') == 1
             * total = 1
             *
             * current = 10
             * previous = 1
             *
             * total -= previous * 2
             *        =  1  -  2
             * total = -1
             *
             * total += 10
             * total = 9
             */
        }
        return total;
    }

}
