package KI306.Protsak.Lab3;

/**
 * Клас, що представляє відносну позицію пістолета.
 */
public class RelativePosition {
    /** Координата x положення пістолета. */
    private int x;
    /** Координата y положення пістолета. */
    private int y;

    /**
     * Конструктор позиції.
     */
    public RelativePosition() {
        x = 0;
        y = 0;
    }

    /**
     * Повертає x-координату.
     *
     * @return x-координата
     */
    public int getXPosition() {
        return x;
    }

    /**
     * Повертає y-координату.
     *
     * @return y-координата
     */
    public int getYPosition() {
        return y;
    }

    /**
     * Встановлює x-координату.
     *
     * @param x нова x-координата
     */
    public void setXPosition(int x) {
        this.x = x;
    }

    /**
     * Встановлює y-координату.
     *
     * @param y нова y-координата
     */
    public void setYPosition(int y) {
        this.y = y;
    }

    /**
     * Встановлює нову позицію.
     *
     * @param x нова x-координата
     * @param y нова y-координата
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}