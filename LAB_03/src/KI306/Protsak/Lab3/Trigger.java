package KI306.Protsak.Lab3;

/**
 * Клас, що представляє спусковий гачок пістолета.
 */
public class Trigger {
    /** Прапорець, що вказує, чи натиснутий спусковий гачок. */
    private boolean isPulled;


    /**
     * Конструктор спускового гачка.
     */
    public Trigger() {
        isPulled = false;
    }

    /**
     * Натискає спусковий гачок.
     */
    public void pull() {
        isPulled = true;
    }

    /**
     * Відпускає спусковий гачок.
     */
    public void release() {
        isPulled = false;
    }

    /**
     * Перевіряє, чи натиснутий спусковий гачок.
     *
     * @return true, якщо гачок натиснутий, інакше false
     */
    public boolean isPulled() {
        return isPulled;
    }
}