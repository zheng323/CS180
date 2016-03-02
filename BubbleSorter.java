/**
 * import the neccessary libary
 */

import java.util.Arrays;

/**
 * CS180 - Homework 07
 * Does the bubble sort
 * @author Kenny Zheng, zheng323@purdue.edu, L04
 * @version 2016-02-09
 */
public class BubbleSorter {

    /**
     * Do the bubble sort.
     *
     * @param array the given array.
     * @return array   the final array.
     */

    int[] bubbleSort(int[] array) {

        if (array == null) {
            return null;
        }

        if (array.length == 0) {
            return null;
        }

        int temp = 0;
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    keepGoing = true;
                }
            }
        }
        return array;
    }

    /**
     * Main method of the program
     *
     * @param args the argument
     */
    public static void main(String[] args) {
        BubbleSorter b = new BubbleSorter();
        int[] array = b.bubbleSort(new int[]{5, 4, 3, 2, 1}); //should return array "{1, 2, 3, 4, 5}"
        System.out.println(Arrays.toString(array));
        int[] otherArray = b.bubbleSort(new int[]{95, 97, 100, 96}); //should return array "{95, 96, 97, 100}"
        System.out.println(Arrays.toString(otherArray));
        System.out.println(b.bubbleSort(null) == null); //prints "true"
    }
}
