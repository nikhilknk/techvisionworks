package com.techvisionworks.backtracking;
import java.util.Arrays;


/**
 * This class represents the SudokuPlus Game
 * It prints the game board and check solutions for sudoku plus board
 *
 * @author sathish duraivelu
 * @version 1.0
 */

public class SudokuPlusGame {

    int rows;
    int cols;
    int outerSquareSize;
    int innerSquareSize;
    int[][] board;
    boolean isDebug = false;


    /**
     * Constructor that accepts the board input
     *
     * @param board
     */
    public SudokuPlusGame(int[][] board) {
        this.board = board;
        setup();
    }

    /**
     * default constructor
     */
    public SudokuPlusGame() {

    }


    /**
     * Get the no of rows in the game
     *
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * set the no of rows
     *
     * @param rows
     */
    private void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * get the no of columns
     *
     * @return cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * set the no of columns
     *
     * @param cols
     */
    private void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * get outer square size
     *
     * @return getOuterSquareSize
     */
    public int getOuterSquareSize() {
        return outerSquareSize;

    }

    /**
     * set Outer square size
     *
     * @param outerSquareSize
     */
    private void setOuterSquareSize(int outerSquareSize) {
        this.outerSquareSize = outerSquareSize;
    }

    /**
     * get inner square size
     *
     * @return innerSquareSize
     */
    public int getInnerSquareSize() {
        return innerSquareSize;
    }

    /**
     * set inner square siae
     *
     * @param innerSquareSize
     */
    private void setInnerSquareSize(int innerSquareSize) {
        this.innerSquareSize = innerSquareSize;
    }

    /**
     * get the game board array
     *
     * @return board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * set board
     *
     * @param board
     */
    public void setBoard(int[][] board) {
        this.board = board;
        setup();
    }

    /**
     * check game is in debug to print additional info
     *
     * @return boolean
     */
    public boolean isDebug() {
        return isDebug;
    }

    /**
     * set debug mode for the game
     *
     * @param debug
     */
    private void setDebug(boolean debug) {
        isDebug = debug;
    }


    /**
     * This method is for setting up th sudoku board
     * It validates the board given and see whether it complies to the rules
     */
    private void setup() {
        if (board != null) {
            rows = board.length;
            cols = board[0].length;
            outerSquareSize = rows;
            innerSquareSize = getSquareRoot(outerSquareSize);
        }

        if (rows != cols || innerSquareSize == -1) {
            throw new RuntimeException("Invalid Board !");
        }


    }


    /**
     * This method check the solution for the given Sudoku plus board
     * and returns true for valid board or false for invalid board
     * <p/>
     * The logic is to check each element in the row and column falls within 1..n where n is size of the board.
     * Then it check the inner squares are complying the same rule.
     *
     * @return boolean
     */
    public boolean checkSolution() {

        int noOfRows = getRows();
        int noOfCols = getCols();
        int boardSize = getOuterSquareSize();

        //Check square
        if (noOfCols != noOfRows)
            return false;

        //Check board is initialized
        if (board == null) {
            log("Board is null. Please set the board!");
            return false;
        }


        int innerSquareSize = getInnerSquareSize();
        //copy each row to array and check the rule
        for (int i = 0; i < boardSize; i++) {
            if (!checkRule(board[i]))
                return false;
        }

        if (isDebug)
            log("Row Rule Valid");

        //Copy columns to and array and check the rule
        for (int j = 0; j < boardSize; j++) {
            int[] boardCol = new int[boardSize];

            for (int i = 0; i < boardSize; i++) {
                boardCol[i] = board[i][j];
            }
            //Check Column Rule
            if (!checkRule(boardCol))
                return false;
        }

        if (isDebug)
            log("Column Rule Valid");


        //copy elments for each inner square to an int array and check rule
        for (int i = 0; i < innerSquareSize; i++) {
            int k = 0;
            int[] list = new int[boardSize];

            for (int row = i * innerSquareSize; row < (i * innerSquareSize + innerSquareSize); row++) {

                for (int column = i * innerSquareSize; column < (i * innerSquareSize + innerSquareSize); column++) {
                    list[k++] = board[row][column];
                }

            }
            if (!checkRule(list))
                return false;

        }

        if (isDebug)
            log("Inner Squares Rule Valid");
        return true;
    }


    /**
     * This Method prints the Board in a nice readable form to the console.
     */
    void writeBoard() {
        int noOfCols = getCols();
        int noOfRows = getRows();
        int innerBoardSize = getInnerSquareSize();


        for (int i = 0; i < noOfCols; ++i) {
            if (i % innerBoardSize == 0)
                log(" -----------------------");
            for (int j = 0; j < noOfRows; ++j) {
                if (j % innerBoardSize == 0) System.out.print("| ");
                System.out.print(board[i][j] == 0
                        ? " "
                        : Integer.toString(board[i][j]));

                System.out.print(' ');
            }
            log("|");
        }
        log(" -----------------------");
    }


    /**
     * This method accepts a integer number
     * Computes the square root.
     * it returns -1 when the give number is not a perfect square root.
     *
     * @param n
     * @return
     */

    private final int getSquareRoot(int n) {
        if (n < 0)
            return -1;

        switch ((int) (n & 0xF)) {
            case 0:
            case 1:
            case 4:
            case 9:
                int squareRoot = (int) Math.sqrt(n);

                if (squareRoot * squareRoot == n)
                    return squareRoot;
                else
                    return -1;

            default:
                return -1;
        }
    }


    /**
     * This method check the rule for each portion of the board
     * it accepts the integer array that represents a row, column or elements of inner square of the sudoku plus board.
     * It sorts the input and checks all numbers from 1 to n where n is the size of the board are present in
     * sequence without duplicates
     * <p/>
     * This is generic method used to verify the solution for the problem
     *
     * @param boardPortion
     * @return boolean
     */
    private boolean checkRule(int[] boardPortion) {

        int boardLength = boardPortion.length;
        int[] temp = Arrays.copyOf(boardPortion, boardPortion.length);
        Arrays.sort(temp);

        for (int i = 0; i < boardLength; i++) {
            if (temp[i] != i + 1) {
                return false;
            }
        }
        return true;
    }


    /**
     * This method print the message to the console
     *
     * @param msg
     */
    void log(String msg) {
        System.out.println(msg);
    }

}