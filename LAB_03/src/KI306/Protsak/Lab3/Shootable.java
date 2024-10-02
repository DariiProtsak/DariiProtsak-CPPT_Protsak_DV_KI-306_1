package KI306.Protsak.Lab3;

/**
 * Інтерфейс, що визначає методи для стрільби.
 */
public interface Shootable {
    /**
     * Здійснює постріл.
     */
    void shoot();

    /**
     * Рахує кількість боєприпасів
     * @return кількість боєприпасів.
     */
    int getAmmoCount();
}