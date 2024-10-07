package KI306.Protsak.Lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Клас для управління файловими операціями результатів обчислень.
 * Підтримує запис та читання даних у текстовому та бінарному форматах.
 */
public class FileManager {
	/** The name of the text file where calculation results are saved. */
	private static final String TEXT_FILE = "calculation_results.txt";

	/** The name of the binary file where calculation results are saved. */
	private static final String BINARY_FILE = "calculation_results.bin";

    /**
     * Конструктор, який очищає файли при створенні нового екземпляра.
     */
    public FileManager() {
        clearFiles();
    }

    /**
     * Очищає обидва файли перед новим записом.
     */
    private void clearFiles() {
        try {
            new FileWriter(TEXT_FILE).close();  // Очищує текстовий файл
            new FileOutputStream(BINARY_FILE).close();  // Очищує бінарний файл
        } catch (IOException e) {
            System.err.println("Помилка при очищенні файлів: " + e.getMessage());
        }
    }

    /**
     * Writes the calculation result to a text file.
     *
     * @param x The input value used for the calculation.
     * @param result The result of the calculation.
     * @throws CalculationException If an error occurs while writing to the text file.
     */
    public void writeToTextFile(double x, double result) throws CalculationException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEXT_FILE))) {
            writer.printf("Для значення x(коеф. при Pi) = %.4f:%n", x);
            writer.printf("Результат обчислення виразу y = sin(3x - 5) / ctg(2x) = %.4f%n", result);
        } catch (IOException e) {
            throw new CalculationException("Помилка при записі у текстовий файл", e);
        }
    }

    /**
     * Writes the calculation result to a binary file.
     *
     * @param x The input value used for the calculation.
     * @param result The result of the calculation.
     * @throws CalculationException If an error occurs while writing to the binary file.
     */
    public void writeToBinaryFile(double x, double result) throws CalculationException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(BINARY_FILE))) {
            dos.writeDouble(x);
            dos.writeDouble(result);
        } catch (IOException e) {
            throw new CalculationException("Помилка при записі у бінарний файл", e);
        }
    }

    /**
     * Reads calculation results from the text file.
     *
     * @return A list of strings containing the results from the text file.
     * @throws CalculationException If an error occurs while reading from the text file.
     */
    public List<String> readFromTextFile() throws CalculationException {
        List<String> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line);
            }
        } catch (IOException e) {
            throw new CalculationException("Помилка при читанні з текстового файлу", e);
        }
        return results;
    }

    /**
     * Reads calculation results from the binary file.
     *
     * @return A list of strings containing the results from the binary file.
     * @throws CalculationException If an error occurs while reading from the binary file.
     */
    public List<String> readFromBinaryFile() throws CalculationException {
        List<String> results = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(BINARY_FILE))) {
            while (dis.available() > 0) {
                double x = dis.readDouble();
                double result = dis.readDouble();
                results.add(String.format("x = %.4f, результат = %.4f", x, result));
            }
        } catch (IOException e) {
            throw new CalculationException("Помилка при читанні з бінарного файлу", e);
        }
        return results;
    }

    /**
     * Retrieves user input for the calculation.
     *
     * @return The value of x entered by the user.
     * @throws CalculationException If the input is not a valid number.
     */
    public double getUserInput() throws CalculationException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Програма обчислює значення виразу: y = sin(3x - 5) / ctg(2x)");
        System.out.print("Будь ласка, введіть значення x(коеф. при Pi): ");
        
        try {
            String input = scanner.nextLine().trim();
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new CalculationException("Некоректне введення. Будь ласка, введіть числове значення.");
        }
    }
}