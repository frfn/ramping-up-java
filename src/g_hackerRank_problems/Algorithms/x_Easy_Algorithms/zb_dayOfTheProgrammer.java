package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zb_dayOfTheProgrammer {

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1918));
    }

    public static String dayOfProgrammer(int year) {
        StringBuilder sb = new StringBuilder();

        int febDays = 28;

        // julian ( 1700 - 1917 )
        if(year >= 1700 && year <= 1917) {
            // leap year algorithm
            if(year % 4 == 0) febDays = 29;
        }

        // gregorian ( 1918 --> current )
        if(year > 1918) {
            // leap year algorithm
            if( year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0)) ) febDays = 29;
        }

        if(year == 1918) {
            febDays = febDays - 13; // 13 was the missing days
        }


        int sumOfEightMonths = 31 + febDays + 31 + 30 + 31 + 30 + 31 + 31;

        int dayOf = 256 - sumOfEightMonths;

        return sb.append(dayOf).append(".09.").append(year).toString();
    }

}
