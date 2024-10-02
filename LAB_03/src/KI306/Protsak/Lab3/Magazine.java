package KI306.Protsak.Lab3;

/**
 * Клас, що представляє магазин пістолета.
 */
public class Magazine {
    /** Ємність магазину. */
    private int capacity;
    /** Поточна кількість патронів у магазині. */
    private int currentAmmo;

    /**
     * Конструктор магазину.
     *
     * @param capacity ємність магазину
     */
    public Magazine(int capacity) {
        this.capacity = capacity;
        this.currentAmmo = capacity;
    }

    /**
     * Використовує один патрон.
     *
     * @return true, якщо патрон використано успішно, інакше false
     */
    public boolean useAmmo() {
        if (currentAmmo > 0) {
            currentAmmo--;
            return true;
        }
        return false;
    }

    /**
     * Перезаряджає магазин.
     */
    public void reload() {
        currentAmmo = capacity;
    }

    /**
     * Повертає кількість патронів у магазині.
     *
     * @return кількість патронів
     */
    public int getAmmo() {
        return currentAmmo;
    }
}
