package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zg_electronicsShop {

    public static void main(String[] args) {
        System.out.println(getMoneySpent(new int[] {60}, new int[] {5,8,12}, 60));
    }

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        int maxValue = -1;

        for(int priceOfKB: keyboards) {

            for(int priceOfDrives: drives) {

                if(priceOfDrives + priceOfKB <= b) {
                    maxValue = Math.max(maxValue, priceOfDrives + priceOfKB);
                }

            }

        }

        return maxValue;
    }

}
