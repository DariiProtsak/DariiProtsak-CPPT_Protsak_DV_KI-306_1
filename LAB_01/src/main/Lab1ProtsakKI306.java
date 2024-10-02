package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Lab1ProtsakKI306 is a Java program that allows the user to input a matrix size and a filler character,
 * then creates an upper triangular matrix filled with the specified character.
 * The matrix is printed to both the console and a file called "lab1.txt".
 * This program showcases various functionalities such as user input, matrix generation,
 * character replacement, output to console and saving to a file.
 * 
 * @author Darii Protsak
 * @version 2.1
 * @since 2024-09-13
 */
public class Lab1ProtsakKI306 {

    /**
     * The main method drives the program, orchestrating input collection, matrix creation,
     * filling the matrix with a filler character, and finally printing and saving the matrix.
     * 
     * @param args command-line arguments (not used in this program)
     * @throws FileNotFoundException if the program fails to create or write to the file
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);  // Scanner for reading user input
        File dataFile = new File("lab1.txt"); // Output file to store the matrix
        PrintWriter fout = new PrintWriter(dataFile); // Writer to output data to the file

        // Step 1: Get matrix size from user
        int nRows = getMatrixSize(in);

        // Step 2: Create an empty upper triangular matrix
        char[][] matrix = createEmptyUpperTriangularMatrix(nRows);

        // Step 3: Get filler character from user
        char filler = getFillerCharacter(in);

        // Step 4: Fill the matrix with the filler character
        fillMatrix(matrix, filler);

        // Step 5: Print matrix to console and save to file
        printMatrix(matrix);
        saveMatrixToFile(matrix, fout);

        // Close resources
        fout.flush();
        fout.close();
        in.close();
    }

    /**
     * Prompts the user to input the size of the square matrix.
     * The size represents both the number of rows and columns for the matrix.
     *
     * @param in Scanner used to read input from the user
     * @return The size of the matrix (number of rows/columns)
     */
    public static int getMatrixSize(Scanner in) {
        System.out.print("Enter the size of the square matrix: ");
        int nRows = in.nextInt();
        in.nextLine(); // Consume the newline character
        return nRows;
    }

    /**
     * Creates an empty upper triangular matrix (a matrix where elements below the diagonal are not used).
     * The matrix is represented as a 2D jagged array where the length of each row decreases progressively.
     *
     * @param size The size of the matrix (number of rows/columns)
     * @return A 2D char array representing an empty upper triangular matrix
     */
    public static char[][] createEmptyUpperTriangularMatrix(int size) {
        char[][] arr = new char[size][];
        for (int i = 0; i < size; i++) {
            arr[i] = new char[size - i]; // Each row gets progressively smaller for the upper triangle
        }
        return arr;
    }

    /**
     * Prompts the user to input a single character that will be used to fill the matrix.
     * Validates that exactly one character was entered.
     *
     * @param in Scanner used to read input from the user
     * @return The filler character
     */
    public static char getFillerCharacter(Scanner in) {
        System.out.print("\nEnter the filler character: ");
        String filler = in.nextLine();
        if (filler.length() != 1) {
            System.out.println("Invalid input. Please enter a single character.");
            System.exit(1); // Exit if the input is invalid
        }
        return filler.charAt(0);
    }

    /**
     * Fills the upper triangular part of the matrix with the specified filler character.
     *
     * @param matrix The matrix to be filled
     * @param filler The character used to fill the matrix
     */
    public static void fillMatrix(char[][] matrix, char filler) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = filler; // Fill each position in the upper triangle
            }
        }
    }

    /**
     * Prints the matrix to the console in a formatted way.
     * Only the upper triangular part of the matrix is printed, with spaces for unused parts.
     *
     * @param matrix The matrix to be printed
     */
    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j >= i) {
                    System.out.print(matrix[i][j - i] + " "); // Print matrix elements
                } else {
                    System.out.print("  "); // Print spaces for formatting
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    /**
     * Saves the matrix to a text file, following the same formatting as the c6onsole output.
     * Only the upper triangular part of the matrix is saved, with spaces for unused parts.
     *
     * @param matrix The matrix to be saved to the file
     * @param fout PrintWriter used to write data to the file
     */
    public static void saveMatrixToFile(char[][] matrix, PrintWriter fout) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j >= i) {
                    fout.print(matrix[i][j - i] + " "); // Write matrix elements to file
                } else {
                    fout.print("  "); // Write spaces for formatting
                }
            }
            fout.println(); // New line after each row
        }
    }
}
