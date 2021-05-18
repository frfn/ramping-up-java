package g_hackerRank_problems;

import java.util.Arrays;

public class h_rotateLeft {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotated(new int[]{1, 2, 3, 4, 5}, 3)));
    }

    // This works, copies the array and puts it back
    public static int[] rotLeft(int[] a, int d) {

        int[] tempArray = new int[d];

        // index:  0 1 2 3 4
        //         1 2 3 4 5
        // d = 4 left
        //         5 1 2 3 4

        for(int index = 0; index < d; index++) {
            tempArray[index] = a[index];
        } // [1 2 3 4]

        int beginningIndex = 0;
        for(int index = d; index < a.length; index++, beginningIndex++) {
            a[beginningIndex] = a[index];
        } // 5 2 3 4 5

        int tempIndex = 0;
        for(int index = beginningIndex; index < a.length; index++, beginningIndex++, tempIndex++) {
            a[index] = tempArray[tempIndex];
        }
        return a;
    }

    // d = 2
    // 0 1 2 3 4
    // 1 2 3 4 5
    // 3 4 5 null null
    public static int[] rotLeftAnotherWay(int[] a, int d) {
        int globalCounter = 0;
        int[] rotatedArray = new int[a.length];
        for(int i = d; i < a.length; i++, globalCounter++) {
            rotatedArray[globalCounter] = a[i];
        }
        for(int i = 0; i < d; i++, globalCounter++) {
            rotatedArray[globalCounter] = a[i];
        }
        return rotatedArray;
    }

    public static int[] rotated(int[] array, int index) {
        int[] rotate = new int[array.length];
        int globalIndex = 0;

        //  0,1,2,3,4
        // [1,2,3,4,5]
        // []

        for(int i = index; i < array.length; i++) {
            rotate[globalIndex++] = array[i];
        }
        for(int i = 0; i < index; i++) {
            rotate[globalIndex++] = array[i];
        }
        return rotate;
    }

}
