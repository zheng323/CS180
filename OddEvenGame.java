/**
 * CS180 - Homework 09
 * Odd even game
 *
 * @author Kenny Zheng, zheng323@purdue.edu, L04
 * @version 2016-02-14
 */
public class OddEvenGame {

    int oddsum;
    int evensum;
    static int totalOddSum;
    static int totalEvenSum;

    /**
     * add the evens
     * @param array is given
     */

    void addEven(int[] array) {

        int number;

        for (int i = 0; i < array.length; i++) {
            number = array[i];
            if (number % 2 == 0) {
                evensum += number;
                totalEvenSum += number;
            } else {
                continue;
            }
        }
    }

    /**
     * add the odds
     * @param array is given
     */

    void addOdd(int[] array) {

        int number;

        for (int i = 0; i < array.length; i++) {
            number = array[i];
            if (number % 2 != 0) {
                oddsum += number;
                totalOddSum += number;
            } else {
                continue;
            }
        }
    }

    /**
     * get total odd
     * @return oddsum
     */

    int getOddSum() {

        return oddsum;
    }

    /**
     * get total even
     * @return evensum
     */

    int getEvenSum() {

        return evensum;
    }

    /**
     * return total odd
     * @return totalOddSum
     */

    int getTotalOddSum() {

        return totalOddSum;
    }

    /**
     * return total even
     * @return totalEvenSum
     */

    int getTotalEvenSum() {

        return totalEvenSum;
    }

    /**
     * Main of the program
     * @param args the arguments
     */

    public static void main(String[] args) {
        OddEvenGame obj1 = new OddEvenGame();
        OddEvenGame obj2 = new OddEvenGame();
        obj1.addEven(new int[] { 1, 2, 3, 4, 5, 6 });
        obj1.addOdd(new int[]{1, 2, 3, 4, 5, 6});

        obj2.addEven(new int[]{100, 101, 241, 302, 501, 623});
        obj2.addOdd(new int[]{100, 101, 241, 302, 501, 623});

        System.out.println(obj1.getEvenSum()); // Prints 12.
        System.out.println(obj2.getOddSum()); // Prints 1466.
        System.out.println(obj1.getTotalOddSum()); // Prints 1475.
        System.out.println(obj2.getTotalEvenSum()); // Prints 414.
    }
}
