import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Hao implements ActionListener {
	public static int score = 0;
	public final int RESET_SCORE = 0;
	
    JFrame mainFrame = new JFrame(); // main frame 
    Container thisContainer = new Container();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JButton diamondsButton[][] = new JButton[6][5];// game grid 
    JButton exitButton = new JButton(); // exit button
    JButton resetButton = new JButton(); // reset button
    JButton restartButton = new JButton(); // new game button
    JLabel scoreLable = new JLabel(Integer.toString(score)); // score lable
    JButton firstButton = new JButton(); // first button pressed
    JButton secondButton = new JButton(); // second button pressed
    int grid[][] = new int[8][7];// game board matrix
    static boolean pressInformation = false; // determine whether button is being pressed 
    int x0 = 0, y0 = 0, x = 0, y = 0, fristMsg = 0, secondMsg = 0, validateLV; // positions 
    int i, j, k, n;// ways to cancel buttons

    /*
     * Set up all the necessary labels, buttons, etc for the game
     */
    public void init() {
        mainFrame = new JFrame("连连看"); // title of the program
        thisContainer = mainFrame.getContentPane();
        thisContainer.setLayout(new BorderLayout());
        centerPanel = new JPanel(); // center location
        southPanel = new JPanel(); // south locaiton
        northPanel = new JPanel(); // north location
        thisContainer.add(centerPanel, "Center");
        thisContainer.add(southPanel, "South");
        thisContainer.add(northPanel, "North");
        centerPanel.setLayout(new GridLayout(6, 5));
        for (int rows = 0; rows < 6; rows++) {
            for (int cols = 0; cols < 5; cols++) {
                diamondsButton[rows][cols] = new JButton(String.valueOf(grid[rows + 1][cols + 1]));
                diamondsButton[rows][cols].addActionListener(this);
                centerPanel.add(diamondsButton[rows][cols]);
            } // put the buttons on the board
        }
        exitButton = new JButton("Exit"); // add Exit button
        exitButton.addActionListener(this); // add actionlistener to exitButton
        resetButton = new JButton("Reset"); // add Reset button
        resetButton.addActionListener(this); // add actionlistener to resetButton
        restartButton = new JButton("Restart"); // add Restart button
        restartButton.addActionListener(this); // add actoinlistener to restartButton
        southPanel.add(exitButton); // location of exitButton
        southPanel.add(resetButton); // location of resetButton
        southPanel.add(restartButton); // location of restartButton
        scoreLable.setText(String.valueOf(Integer.parseInt(scoreLable.getText())));
        northPanel.add(scoreLable);
        mainFrame.setBounds(280, 100, 500, 450); // bounds of the program
        mainFrame.setVisible(true); // set the panel to visible
    }

    /*
     * Generate a gameboard with 30 buttons, 15 different numbers and all number must be different
     */
    public void randomBuild() {
        int randomNum;
        int rows;
        int cols;
        ArrayList<Integer> repeatNum = new ArrayList<Integer> ();        
        for (int i = 0; i < 10; i++)  { // do this 15 times, aka make 15 different numbers
        	randomNum = (int) (Math.random() * 30 + 1); // generate random number from 1 - 30
        	while (repeatNum.contains(randomNum)) { // make sure only have 1 set of randomNum
        		randomNum = (int) (Math.random() * 25 + 1); // make new randomNum is it is repeated
        	}
        	repeatNum.add(randomNum); // store the new randomNum into the array
        	for (int j = 0; j < 2; j++) { // make sure 2 buttons have same number
        		rows = (int) (Math.random() * 6 + 1); // pick a random row
        		cols = (int) (Math.random() * 5 + 1); // pick a random col
        		while (grid[rows][cols] != 0) { // checking if number at current row and col is 0, proceed only if it is not 0
                  rows = (int) (Math.random() * 6 + 1); // pick a new row
                  cols = (int) (Math.random() * 5 + 1); // pick a new col
              }
        		this.grid[rows][cols] = randomNum; // set the button to randomNum
        	}
        }
    }

    /*
     * Update teh score by 100 each successful time
     */
    public void updateScore() {
    	scoreLable.setText(String.valueOf(score + 100));

    }

    public void reload() {
    	
        int save[] = new int[30];
        int n = 0;
        int rows;
        int cols;
        int grid[][] = new int[8][7];
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 5; j++) {
                if (this.grid[i][j] != 0) {
                    save[n] = this.grid[i][j];
                    n++;
                }
            }
        }
        n = n - 1;
        this.grid = grid;
        while (n >= 0) {
            rows = (int) (Math.random() * 6 + 1);
            cols = (int) (Math.random() * 5 + 1);
            while (grid[rows][cols] != 0) {
                rows = (int) (Math.random() * 6 + 1);
                cols = (int) (Math.random() * 5 + 1);
            }
            this.grid[rows][cols] = save[n];
            n--;
        }
        mainFrame.setVisible(false);
        pressInformation = false; 
        init();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (grid[i + 1][j + 1] == 0)
                    diamondsButton[i][j].setVisible(false);
            }
        }
    }

    public void estimateEven(int placeX, int placeY, JButton bz) {
        if (pressInformation == false) {
            x = placeX;
            y = placeY;
            secondMsg = grid[x][y];
            secondButton = bz;
            pressInformation = true;
        } else {
            x0 = x;
            y0 = y;
            fristMsg = secondMsg;
            firstButton = secondButton;
            x = placeX;
            y = placeY;
            secondMsg = grid[x][y];
            secondButton = bz;
            if (fristMsg == secondMsg && secondButton != firstButton) {
                xiao();
            }
        }
    }

    public void xiao() { 
        if ((x0 == x && (y0 == y + 1 || y0 == y - 1)) || ((x0 == x + 1 || x0 == x - 1) && (y0 == y))) { // determine if buttons are next to each other
            remove();
        } else {
            for (j = 0; j < 7; j++) {
                if (grid[x0][j] == 0) { //判断第一个按钮同行哪个按钮为空 
                    if (y > j) { //如果第二个按钮的Y坐标大于空按钮的Y坐标说明第一按钮在第二按钮左边 
                        for (i = y - 1; i >= j; i--) { //判断第二按钮左侧直到第一按钮中间有没有按钮 
                            if (grid[x][i] != 0) {
                                k = 0;
                                break;
                            } else {
                                k = 1;
                            }
                        }
                        if (k == 1) {
                            linePassOne();
                        }
                    }
                    if (y < j) { //如果第二个按钮的Y坐标小于空按钮的Y坐标说明第一按钮在第二按钮右边 
                        for (i = y + 1; i <= j; i++) { //判断第二按钮左侧直到第一按钮中间有没有按钮 
                            if (grid[x][i] != 0) {
                                k = 0;
                                break;
                            } else {
                                k = 1;
                            }
                        }
                        if (k == 1) {
                            linePassOne();
                        }
                    }
                    if (y == j) {
                        linePassOne();
                    }
                }
                if (k == 2) {
                    if (x0 == x) {
                        remove();
                    }
                    if (x0 < x) {
                        for (n = x0; n <= x - 1; n++) {
                            if (grid[n][j] != 0) {
                                k = 0;
                                break;
                            }
                            if (grid[n][j] == 0 && n == x - 1) {
                                remove();
                            }
                        }
                    }
                    if (x0 > x) {
                        for (n = x0; n >= x + 1; n--) {
                            if (grid[n][j] != 0) {
                                k = 0;
                                break;
                            }
                            if (grid[n][j] == 0 && n == x + 1) {
                                remove();
                            }
                        }
                    }
                }
            }
            for (i = 0; i < 8; i++) { //列 
                if (grid[i][y0] == 0) {
                    if (x > i) {
                        for (j = x - 1; j >= i; j--) {
                            if (grid[j][y] != 0) {
                                k = 0;
                                break;
                            } else {
                                k = 1;
                            }
                        }
                        if (k == 1) {
                            rowPassOne();
                        }
                    }
                    if (x < i) {
                        for (j = x + 1; j <= i; j++) {
                            if (grid[j][y] != 0) {
                                k = 0;
                                break;
                            } else {
                                k = 1;
                            }
                        }
                        if (k == 1) {
                            rowPassOne();
                        }
                    }
                    if (x == i) {
                        rowPassOne();
                    }
                }
                if (k == 2) {
                    if (y0 == y) {
                        remove();
                    }
                    if (y0 < y) {
                        for (n = y0; n <= y - 1; n++) {
                            if (grid[i][n] != 0) {
                                k = 0;
                                break;
                            }
                            if (grid[i][n] == 0 && n == y - 1) {
                                remove();
                            }
                        }
                    }
                    if (y0 > y) {
                        for (n = y0; n >= y + 1; n--) {
                            if (grid[i][n] != 0) {
                                k = 0;
                                break;
                            }
                            if (grid[i][n] == 0 && n == y + 1) {
                                remove();
                            }
                        }
                    }
                }
            }
        }
    }

    public void linePassOne() {
        if (y0 > j) { //第一按钮同行空按钮在左边 
            for (i = y0 - 1; i >= j; i--) { //判断第一按钮同左侧空按钮之间有没按钮 
                if (grid[x0][i] != 0) {
                    k = 0;
                    break;
                } else {
                    k = 2;
                } //K=2说明通过了第二次验证 
            }
        }
        if (y0 < j) { //第一按钮同行空按钮在与第二按钮之间 
            for (i = y0 + 1; i <= j; i++) {
                if (grid[x0][i] != 0) {
                    k = 0;
                    break;
                } else {
                    k = 2;
                }
            }
        }
    }

    public void rowPassOne() {
        if (x0 > i) {
            for (j = x0 - 1; j >= i; j--) {
                if (grid[j][y0] != 0) {
                    k = 0;
                    break;
                } else {
                    k = 2;
                }
            }
        }
        if (x0 < i) {
            for (j = x0 + 1; j <= i; j++) {
                if (grid[j][y0] != 0) {
                    k = 0;
                    break;
                } else {
                    k = 2;
                }
            }
        }
    }

    public void remove() {
        firstButton.setVisible(false);
        secondButton.setVisible(false);
        updateScore();
        pressInformation = false;
        k = 0;
        grid[x0][y0] = 0;
        grid[x][y] = 0;
        score += 100;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartButton) {
        	score = 0;
            int grid[][] = new int[8][7];
            this.grid = grid;
            randomBuild();
            mainFrame.setVisible(false);
            pressInformation = false;
            scoreLable.setText(String.valueOf(RESET_SCORE)); // reset the socreboard back to 0
            init();
        }
        if (e.getSource() == exitButton)
            System.exit(0);
        if (e.getSource() == resetButton)
            reload();
        for (int rows = 0; rows < 6; rows++) {
            for (int cols = 0; cols < 5; cols++) {
                if (e.getSource() == diamondsButton[rows][cols])
                    estimateEven(rows + 1, cols + 1, diamondsButton[rows][cols]);
            }
        }
    }

    public static void main(String[] args) {
        Hao llk = new Hao();
        llk.randomBuild();
        llk.init();
    }
} 