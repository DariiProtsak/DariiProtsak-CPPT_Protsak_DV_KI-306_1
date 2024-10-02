package KI306.Protsak.Lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Клас Lab4 містить основний метод для запуску програми, яка обчислює значення математичного виразу
 * на різних значеннях x і записує результати у файл.
 */
public class Lab4 {

    /**
     * Основний метод програми, який обчислює значення математичного виразу на різних значеннях x 
     * і записує результати у файл. Крім того, метод демонструє обробку помилок під час обчислень,
     * включаючи випадки з некоректними вхідними даними.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        double startX = -Math.PI;
        double endX = Math.PI;
        double step = Math.PI / 12;
        String fileName = "results.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (double x = startX; x <= endX; x += step) {
                try {
                    double result = ExpressionCalculator.calculate(x);
                    String output = String.format("x = %.4f, y = %.4f", x, result);
                    writer.println(output);
                    System.out.println(output);
                } catch (CalculationException e) {
                    String errorMessage = String.format("Помилка при x = %.4f: %s", x, e.getMessage());
                    writer.println(errorMessage);
                    System.out.println(errorMessage);
                }
            }

            // Тестування спеціального випадку з NaN
            try {
                double nanX = Double.NaN;
                double result = ExpressionCalculator.calculate(nanX);
                System.out.println(String.format("x = %f, y = %f", nanX, result));
            } catch (CalculationException e) {
                System.out.println("Тест з NaN: " + e.getMessage());
            }

            System.out.println("Результати записано у файл '" + fileName + "'");
        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлом: " + e.getMessage());
        }
    }
}
