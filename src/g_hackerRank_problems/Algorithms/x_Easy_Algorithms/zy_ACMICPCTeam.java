package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class zy_ACMICPCTeam {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("10101");
        list.add("11110");
        list.add("00010");
        for(int num: acmTeam(list)) System.out.print(num + ", ");
    }

    // similar to binary add, but if 1 and 1, then 1 OR if 1 and 0 || 0 and 1 then 1 ELSE 0
    //   10101
    // + 01010
    // = 11111
    public static String groupingAddition(String bin, String bin2) {
        // .insert() is neat
        StringBuilder sb = new StringBuilder();
        int binIndex = bin.length() - 1;
        int bin2Index = bin2.length() - 1;

        while(binIndex >= 0 || bin2Index >= 0) {
            int num = 0, num2 = 0;
            if(binIndex >= 0) {
                num = bin.charAt(binIndex--) - '0';
            }
            if(bin2Index >= 0) {
                num2 = bin2.charAt(bin2Index--) - '0';
            }

            // sees if numbers are both 1 or 0 and 1 then add 1 to SB ELSE if both 0 add 0 to SB
            if(num == 1 && num2 == 1) sb.insert(0, 1);
            else if((num == 1 && num2 == 0) || (num == 0 && num2 == 1)) sb.insert(0, 1);
            else sb.insert(0, 0);
        }

        return sb.toString();
    }

    public static List<Integer> acmTeam(List<String> topic) {
        List<Integer> returnValue = new ArrayList<>();
        int maxCount = 0;
        int teamMaxCount = 0;

        for(int i = 0; i < topic.size(); i++) {
            for(int j = i + 1; j < topic.size(); j++) {

                String firstValue = topic.get(i);  // 10101
                String secondValue = topic.get(j); // 11110

                String sum = groupingAddition(firstValue, secondValue);
                int count = 0;

                // 11111 | count = 5
                for(char digit: sum.toCharArray()) {
                    if(digit == '1') count++;
                }

                if(count == maxCount) {
                    teamMaxCount++;
                }

                // restart if maxCount changes
                if(count > maxCount) {
                    teamMaxCount = 1;
                    maxCount = count;
                }
            }
        }
        returnValue.add(maxCount);
        returnValue.add(teamMaxCount);
        return returnValue;
    }

    // relearning ASCII tricks and stuff :)
    public static String addBinary(String bin, String bin2) {
        // by doing charAt(..) - '0', this will grab the ascii
        // why? because we want to go from STRING to CHAR to INT

        StringBuilder sb = new StringBuilder();
        int binIndex = bin.length() - 1;
        int bin2Index = bin2.length() - 1;
        int carry = 0;

        // 00101 - bin
        //   011 - bin2
        //
        while(binIndex > 0 || bin2Index > 0) {
            int sum = carry;

            if(binIndex >= 0) {
                sum += bin.charAt(binIndex--) - '0'; // let's say at charAt(..) == 1, that INT value will be 49! it will be converted into ASCII character value!
            }

            if(bin2Index >= 0) {
                sum += bin2.charAt(bin2Index--) - '0'; // by subtracting - '0', it is a ASCII trick to use character numbers, AS int numbers!
            }

            sb.append(sum % 2); // 2 % 2 = 0 | 1 % 2 = 1
            carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);

        return sb.toString();

        // ex
        // String bin = "10101";
        // String bin2 = "11110";
        // int num = '2' - '0';
        // System.out.println('2');
        // System.out.println(num);
    }
    public static String addBinaryShortWay(String bin, String bin2) {
        int intBin = Integer.parseInt(bin, 2);
        int intBin2 = Integer.parseInt(bin2, 2);
        return Integer.toBinaryString(intBin + intBin2);
    }

}
