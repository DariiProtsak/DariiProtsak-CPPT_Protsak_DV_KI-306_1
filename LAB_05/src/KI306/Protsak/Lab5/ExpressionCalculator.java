package KI306.Protsak.Lab5;

/**
 * Клас ExpressionCalculator містить метод для обчислення математичного виразу.
 */
public class ExpressionCalculator {

    /**
     * Обчислює значення виразу y = sin(3x - 5) / ctg(2x).
     * Котангенс обчислюється як 1 / tan(2x).
     *
     * @param x Вхідне значення x, яке є коефіцієнтом числа π, для якого обчислюється вираз.
     * @return Результат обчислення виразу.
     * @throws CalculationException Якщо виникає помилка під час обчислень
     */
    public static double calculate(double x) throws CalculationException {
        // Перевірка, чи є вхідне значення NaN
        if (Double.isNaN(x)) {
            throw new CalculationException("Вхідне значення x не є числом!");
        }

        // Обчислюємо значення x, множачи його на π
        double piMultiplier = x * Math.PI;

        // Обчислення чисельника: sin(3 * piMultiplier - 5)
        double numerator = Math.sin(3 * piMultiplier - 5);

        // Обчислення тангенса для знаменника: tan(2 * piMultiplier)
        double tangent = Math.tan(2 * piMultiplier);

        // Перевірка, чи тангенс близький до нуля
        if (Math.abs(tangent) < 1e-10) {
            throw new CalculationException("Значення тангенса близьке до нуля!");
        }

        // Обчислення котангенса як 1 / tan(2 * piMultiplier)
        double cotangent = 1 / tangent;

        // Перевірка, чи котангенс близький до нуля
        if (Math.abs(cotangent) < 1e-10) {
            throw new CalculationException("Значення котангенса близьке до нуля!");
        }

        // Обчислення результату виразу
        double result = numerator / cotangent;

        // Перевірка, чи результат є нескінченним
        if (Double.isInfinite(result)) {
            throw new CalculationException("Результат обчислення призвів до переповнення!");
        }

        return result;
    }
}
