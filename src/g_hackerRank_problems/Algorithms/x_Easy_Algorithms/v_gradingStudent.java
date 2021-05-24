package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class v_gradingStudent {

    public static List<Integer> roundGrades(List<Integer> studentGrades) {
        if(studentGrades.size() == 0) return studentGrades;

        List<Integer> roundedGrades = new ArrayList<>();


        // if grade is less than 3 then round up to multiple of 5 ...
        // if below 38, no rounding occurs
        for(int grade: studentGrades) {
            if(grade < 38) {
                roundedGrades.add(grade); // no change occues because less than 38
                continue;
            }

            // 78 % 5 = 3
            // 5 - 3 = 2
            // 78 + 2 = 80
            int mod5 = grade % 5;
            int gradeToRoundUpTo = grade + (5 - mod5);

            // get the number to round up to ** brute force. good job.
            // for(int i = 0; i <= 100; i += 5) {
            //     if(grade <= i) {
            //         gradeToRoundUpTo = i;
            //         break; // out of THIS for loop.
            //     }
            // }

            int evaluation = gradeToRoundUpTo - grade; // 40 - 38 | 60 - 57 = 3

            if(evaluation < 3) {
                roundedGrades.add(grade + evaluation);
            } else {
                roundedGrades.add(grade);
            }
        }

        return roundedGrades;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> studentGrades = new ArrayList<>();

        System.out.print("Enter total of grades to round: ");
        int totalOfGrades = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < totalOfGrades; i++) {
            System.out.print("Enter grade: ");
            int gradeForStudent = Integer.parseInt(br.readLine().trim());
            studentGrades.add(gradeForStudent);
        }

        br.close();

        List<Integer> roundedGrades = roundGrades(studentGrades);

        for(int roundedGrade: roundedGrades) System.out.println(roundedGrade);

    }

}
