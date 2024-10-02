package KI306.Protsak.Lab3;

/**
 * Інтерфейс, що визначає методи перезарядки.
 */
public interface Reloadable {
    /**
     * Здійснює перезарядку.
     */
    void reload();

    /**
     * Перевірка чи порожній магазин.
     * @return чи порожній магазин.
     */
    boolean isEmpty();
}