package d_search;

// only works on sorted lists

public class binarysearch {

    public static void main(String[] args) {
        System.out.println(bs(new int[] {1,3,5,6,7,8,9,9}, 4));
    }

    public static boolean bs(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        // left and right WILL get closer and closer .. they will be the same eventually
        while(left<=right) {
            int middle = (left+right) / 2;

            if(arr[middle] == target) {
                return true;
            }

            else if(arr[middle] < target) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
            return false;
    }
}
