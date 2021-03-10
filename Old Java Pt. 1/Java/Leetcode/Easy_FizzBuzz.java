package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Easy_FizzBuzz {

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);

        System.out.println(list);
    }

    public static List<String> fizzBuzz(int n){
        ArrayList list = new ArrayList<>();

        if (n == 0){
            list.add("Number is 0");
            return list;
        }

        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            }
            else if(i % 3 == 0){
                list.add("Fizz");
            }
            else if(i % 5 == 0){
                list.add("Buzz");
            }
            else {
                list.add(Integer.toString(i));
            }
        }

        return list;
    }
}
