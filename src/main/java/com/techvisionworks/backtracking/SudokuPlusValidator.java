package com.techvisionworks.backtracking;
import java.io.*;
import java.util.ArrayList;

/**
 * This class validates the given sudoku plus input and print the result as valid or invalid.
 * It also takes care of any file issues and check the rules like board size etc and throw errors.
 * <p/>
 * <p/>
 * This program takes the full path of the file as input. The file should contain comma separated values
 * that represents the sudoku board. All rows are separated by newline charectar and columns are separated by commas.
 * <p/>
 * <p/>
 * For ex a 4x4 board is represented as follows:??
 * 1,4,2,3
 * 2,3,1,4
 * 4,2,3,1
 * 3,1,4,2
 *
 * @author sathish duraivelu
 * @version 1.0
 */
public class SudokuPlusValidator {

    private static final String COMMA = ",";


    /**
     * Parse the input file and Print the input Sudoku plus solution.
     * Output: Prints the given solution is a valid or not.
     *
     * @param args The command-line arguments with csv file name containing solution.
     */
    public static void main(String[] args) {


        //parse the input args to get the sudoku board from the file input
        int[][] board = parseInput(args);


        //Create the SudokuPlu
        SudokuPlusGame game = new SudokuPlusGame(board);

        log("****** Given Sudoku Plus Board ****");

        game.writeBoard();

        boolean isCorrect = game.checkSolution();
        log("**********************************************************");
        if (isCorrect) {
            log("******The given Sudoku Plus solution is a valid solution****");
        } else {
            log("******The given Sudoku Plus solution is not a valid solution*****");
        }

        log("**********************************************************");
    }


    static int[][] parseInput(String[] args) {

        int[][] problem = null;

        if (args.length < 1) {
            log("Usage : java SuodkuPlusValidator <filepath>");
            System.exit(1);
        }

        String inputFile = args[0];

        DataInputStream in = null;

        if ("".equals(inputFile)) {
            log("Usage : java SuodkuPlusValidator <filepath>");
            System.exit(1);
        }

        //check and read the file

        try {

            //Check File exists
            File file = new File(inputFile);
            if (!file.exists()) {
                log("The give file doesn't exists. Please input the full path of the file!");
                System.exit(1);
            }

            // Get the Buffered Reader from the given file
            FileInputStream fstream = new FileInputStream(inputFile);

            in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            int noOfRows = 0;
            ArrayList<String> strRowList = new ArrayList<String>();

            //Read File Line By Line to array List
            while ((strLine = br.readLine()) != null) {
                strRowList.add(strLine);
            }

            noOfRows = strRowList.size();

            int noOfCols = 0;

            // form the board from the string array list
            for (int i = 0; i < noOfRows; i++) {
                String row = strRowList.get(i);
                String[] strCols = row.split(",");
                noOfCols = strCols.length;

                //validate given input is square
                if (noOfCols != noOfRows) {
                    log("File error:: No of rows should match the no of columns. Problem in line " + i + " of the file");
                    System.exit(1);
                }

                //initialize the board array only on the first iteration
                if (i == 0)
                    problem = new int[noOfRows][noOfCols];

                //Fill the array
                for (int j = 0; j < strCols.length; j++) {
                    problem[i][j] = Integer.parseInt(strCols[j]);
                }

            }


        } catch (IOException e) {
            System.out.print("Problem in the input File. Please input \n java SudokuPlusValidator <inputfilepath>");
        } catch (Exception ex) {
            log("Problem in input File parsing." + ex.getMessage());
            // ex.printStackTrace();
        } finally {
            //Close the input stream
            try {
                in.close();
            } catch (IOException ioe) {
                log("ioException during close!");
            }
        }


        return problem;
    }


    static void log(String msg) {
        System.out.println(msg);
    }


}