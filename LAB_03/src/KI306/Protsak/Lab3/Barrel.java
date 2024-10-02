package KI306.Protsak.Lab3;

/**
 * Клас, що представляє ствол пістолета.
 */
public class Barrel {
	/** Прапорець, що вказує, чи ствол чистий. */
    private boolean isClean;

    /**
     * Конструктор ствола.
     */
    public Barrel() {
        isClean = true;
    }

    /**
     * Здійснює постріл, забруднюючи ствол.
     */
    public void fire() {
        isClean = false;
    }

    /**
     * Очищує ствол.
     */
    public void clean() {
        isClean = true;
    }

    /**
     * Перевіряє, чи ствол чистий.
     *
     * @return true, якщо ствол чистий, інакше false
     */
    public boolean isClean() {
        return isClean;
    }
}
