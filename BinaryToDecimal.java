/**
 * CS180 - Homework 06
 * Convert binary to decimal.
 * @author Kenny Zheng, zheng323@purdue.edu, L04
 * @version 2016-01-30
 */

public class BinaryToDecimal {

    /**
     * converting binary to decimal
     *
     * @param binary The given number
     * @return the decimal answer
     */
    int binaryToDecimal(int binary) {
        int power = 0;
        int rem;
        int answer = 0;

        while (binary > 0) {

            rem = binary % 10;
            answer += rem * Math.pow(2, power);
            binary = binary / 10;
            power++;
        }

        return answer;
    }

    /**
     * the main method of the program
     *
     * @param args the arguments
     */

    public static void main(String[] args) { // main method
        BinaryToDecimal obj = new BinaryToDecimal(); // call the method
        System.out.println(obj.binaryToDecimal(1001000)); // Prints 72
        System.out.println(obj.binaryToDecimal(1011000)); // Prints 88
    }
}
