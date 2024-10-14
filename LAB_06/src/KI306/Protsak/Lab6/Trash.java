package KI306.Protsak.Lab6;

/**
 * Інтерфейс для елементів сміття
 * @author Darii Protsak
 * @version 1.0
 */
public interface Trash {
    /**
     * Отримує вагу сміття
     * @return вага сміття
     */
    double getWeight();

    /**
     * Отримує тип сміття
     * @return тип сміття
     */
    String getType();
}