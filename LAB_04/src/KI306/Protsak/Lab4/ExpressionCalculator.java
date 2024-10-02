package KI306.Protsak.Lab4;

/**
 * Клас ExpressionCalculator містить метод для обчислення математичного виразу.
 */
public class ExpressionCalculator {

    /**
     * Обчислює значення виразу y = sin(3x - 5) / ctg(2x).
     * Котангенс обчислюється як 1 / tan(2x).
     *
     * @param x Вхідне значення x, для якого обчислюється вираз.
     * @return Результат обчислення виразу.
     * @throws CalculationException Якщо виникає помилка під час обчислень (наприклад, якщо значення x
     * призводить до некоректного результату, як NaN або нескінченність).
     */
    public static double calculate(double x) throws CalculationException {
        // Перевірка, чи є вхідне значення NaN (нечислове значення)
        if (Double.isNaN(x)) {
            throw new CalculationException("Вхідне значення x не є числом!");
        }

        // Обчислення чисельника: sin(3 * x - 5)
        double numerator = Math.sin(3 * x - 5);

        // Обчислення тангенса для знаменника: tan(2 * x)
        double tangent = Math.tan(2 * x);

        // Обчислення котангенса як 1 / tan(2 * x)
        double cotangent = 1 / tangent;

        // Перевірка, чи котангенс прямує до нескінченності
        if (Math.abs(cotangent) < 1e-10) {
            throw new CalculationException("Котангенс не визначений, значення прямує до безкінечності!");
        }

        // Обчислення результату виразу
        double result = numerator / cotangent;

        // Перевірка, чи результат є нескінченним (переповнення)
        if (Double.isInfinite(result)) {
            throw new CalculationException("Результат обчислення призвів до переповнення!");
        }

        return result;
    }
}
