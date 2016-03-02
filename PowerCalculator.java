/**
 * CS180 - Homework 05
 * power calculator.
 * @author Kenny Zheng, zheng323@purdue.edu, L04
 * @version 2016-01-30
 */

public class PowerCalculator {

    /**
     *
     * calculate what power
     *
     * @param number given number
     * @param base given base
     * @return returns the power
     */
    int whatPower(int number, int base) {
        int counter = 0;
        int rem;

        while (number != 1) {

            rem = number % base;

            if (rem > 0)
                return -1;
            else {
                number = number / base;
                counter++;
            }

        }

        return counter;
    }

    /**
     * the main method
     *
     * @param args the arguemtns
     */
    public static void main(String[] args) {
        PowerCalculator p = new PowerCalculator();
        System.out.println(p.whatPower(8, 2)); //prints "3"
        System.out.println(p.whatPower(100, 10)); //prints "2"
        System.out.println(p.whatPower(125, 5)); //prints "3"
        System.out.println(p.whatPower(12, 5)); //prints "-1"
    }
}
