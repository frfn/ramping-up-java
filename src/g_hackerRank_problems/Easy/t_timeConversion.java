package g_hackerRank_problems.Easy;

public class t_timeConversion {

    /* Sample Input 0       Sample Output 0
       00:05:45AM           12:05:45AM       */
    public static String convertTimeToMilitary(String s) {

        StringBuilder sb = new StringBuilder(); // string builder for optimized string concatenation

        int hour = Integer.parseInt(s.substring(0, 2)); // getting the hour
        String AMorPM = s.substring(s.length() - 2);    // getting the AM or PM

        /*
        LOGIC:

        if AM, and hour is 12, then -> 00, if not, just add the hour ( if 01:00:00AM --> 01:00:00 )

        if PM, and hour is 12, then -> 12, if not, add 12. ( if 01:00:00PM --> 1 + 12 = 13:00:00 )

         */

        if(AMorPM.equals("AM")) {
            if(hour == 12) {
                sb.append("00");
            } else {
                sb.append("0").append(hour);
            }

            // this line reads, from String s, substring from index 2, to the length of string - 2 ( since the last 2 characters are the PM or AM )
            sb.append(s, 2, s.length() - 2);
        }

        if(AMorPM.equals("PM")) {
            if(hour == 12) {
                sb.append(hour);
            } else {
                sb.append(hour + 12); // look at logic why we add 12.
            }

            sb.append(s, 2, s.length() - 2);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertTimeToMilitary("12:05:45PM"));
    }

}
