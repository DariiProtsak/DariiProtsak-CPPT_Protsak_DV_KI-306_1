package KI306.Protsak.Lab5;

/**
 * Оновлений клас Lab5, який використовує FileManager для обробки файлових операцій.
 */
public class Lab5 {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        try {
            // Отримання введення від користувача
            double x = fileManager.getUserInput();
            
            // Обчислення результату
            double result = ExpressionCalculator.calculate(x);
            
            // Запис результатів у файли
            fileManager.writeToTextFile(x, result);
            fileManager.writeToBinaryFile(x, result);
            
            System.out.println("\nРезультати обчислення:");
            System.out.printf("Для x = %.4f, результат = %.4f%n", x, result);
            System.out.println("Результати були записані у текстовий та бінарний файли.");
            
            // Читання та виведення результатів
            System.out.println("\nЗчитування з текстового файлу:");
            for (String line : fileManager.readFromTextFile()) {
                System.out.println(line);
            }
            
            System.out.println("\nЗчитування з бінарного файлу:");
            for (String line : fileManager.readFromBinaryFile()) {
                System.out.println(line);
            }
            
        } catch (CalculationException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}