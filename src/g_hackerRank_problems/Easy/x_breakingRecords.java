package g_hackerRank_problems.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class x_breakingRecords {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter how many scores: ");
        int loopHowManyTimes = Integer.parseInt(br.readLine());

        List<Integer> scores = new ArrayList<>();

        for(int i = 0; i < loopHowManyTimes; i++) {
            System.out.print("Enter score: ");
            scores.add(Integer.parseInt(br.readLine()));
        }

        for(int records: breakingRecords(scores)) System.out.println(records);

    }

    public static List<Integer> breakingRecords(List<Integer> scores) {

        List<Integer> brokenRecords = new ArrayList<>();

        int max = scores.get(0); // 10
        int min = scores.get(0); // 10

        int breakingMaxRecord = 0;
        int breakingMinRecord = 0;

        // 10 5 20 20 4 5 2 25 1

        for(int score: scores) {

            if(score > max) {
                breakingMaxRecord++;
                max = score;
            }

            if(score < min) {
                breakingMinRecord++;
                min = score;
            }

        }

        brokenRecords.add(breakingMaxRecord);
        brokenRecords.add(breakingMinRecord);

        return brokenRecords;
    }

}
