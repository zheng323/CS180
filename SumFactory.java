/**
 * CS180 - Homework 10
 * Finding the sum
 *
 * @author Kenny Zheng, zheng323@purdue.edu, L04
 * @version 2016-02-14
 */
public class SumFactory {

    int sum;
    static int totalSum;

    /**
     * add the value
     * @param array is givin
     */

    void add(int[] array) {

        int number;

        for (int i = 0; i < array.length; i++) {
            number = array[i];
            sum += number;
            totalSum += number;
        }
    }

    /**
     * return the sum
     * @return sum
     */

    int getSum() {

        return sum;
    }

    /**
     * return the total sum
     * @return total sum
     */
    int getTotalSum() {

        return totalSum;
    }

    /**
     * The main of class
     * @param args the argument
     */
    public static void main(String[] args) {
        SumFactory s1 = new SumFactory();
        SumFactory s2 = new SumFactory();
        SumFactory s3 = new SumFactory();
        s1.add(new int[]{1, 2, 3});
        s2.add(new int[]{100, 200, 300});
        s3.add(new int[]{16, 32, 64, 128, 256});
        System.out.println(s1.getSum()); //prints "6"
        System.out.println(s2.getSum()); //prints "600"
        System.out.println(s3.getSum()); //prints "496"
        System.out.println(s1.getTotalSum()); //prints "1102
    }
}
