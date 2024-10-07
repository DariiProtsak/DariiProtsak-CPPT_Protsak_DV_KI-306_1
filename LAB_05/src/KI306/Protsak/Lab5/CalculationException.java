package KI306.Protsak.Lab5;

/**
 * Користувацький виняток для обробки помилок обчислень.
 * Цей клас розширює стандартний клас Exception і використовується для передачі детальної
 * інформації про помилки, які виникають під час обчислення математичних виразів.
 */
public class CalculationException extends Exception {
    
    /**
     * Конструктор для створення нового винятку з заданим повідомленням.
     *
     * @param message Повідомлення про помилку, яке пояснює причину виникнення винятку.
     */
    public CalculationException(String message) {
        super(message);
    }

    /**
     * Конструктор для створення нового винятку з повідомленням та причиною.
     *
     * @param message Повідомлення про помилку, яке пояснює суть проблеми.
     * @param cause Причина виникнення винятку (інший виняток, який спричинив поточний виняток).
     */
    public CalculationException(String message, Throwable cause) {
        super(message, cause);
    }
}