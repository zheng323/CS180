import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * CS180 - Homework 08
 * Add the matrix
 *
 * @author Kenny Zheng, zheng323@purdue.edu, L04
 * @version 2016-02-09
 */
public class Matrix {

    int rows;
    int columns;
    int[][] matrix;

    /**
     * Constructor
     *
     * @param rows of matrix
     * @param columns of matrix
     */
    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    /**
     * add data
     *
     * @param array the giving array
     */
    public void addData(int[] array) {

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = array[count];
                count++;
            }
        }
    }

    /**
     * Add the matrices
     *
     * @param a Matrix a
     * @param b Matrix b
     * @return a + b
     */
    public static Matrix addMatrices(Matrix a, Matrix b) {

        Matrix c = new Matrix(a.rows, a.columns);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.columns; j++) {
                c.matrix[i][j] = a.matrix[i][j] + b.matrix[i][j];
            }
        }
        return c;
    }

    /**
     * Main of the class
     *
     * @param args the arguements
     */
    public static void main(String[] args) {

        Matrix obj1 = new Matrix(2, 2); // creates a Matrix object with two rows and two columns
        Matrix obj2 = new Matrix(2, 2); // creates another Matrix object with two rows and two columns

        obj1.addData(new int[]{1, 2, 3, 4}); // addData() is called using obj1,
        // so {1, 2, 3, 4} is populated into obj1.matrix
        obj2.addData(new int[]{5, 6, 7, 8}); // addData() is called using obj2,
        // so {5, 6, 7, 8} is populated into obj2.matrix

        Matrix sum = addMatrices(obj1, obj2); // Should contain {6, 8, 10, 12}.
    }
}