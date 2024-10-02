package KI306.Protsak.Lab3;

import java.io.FileNotFoundException;

/**
 * 
 * Головний клас додатку для демонстрації роботи водяного пістолета.
 * @author Darii Protsak
 */
public class WaterPistolApp {
    /**
     * Конструктор класу WaterPistolApp.
     * Цей клас не потребує ініціалізації, тому конструктор залишається порожнім.
     */
    public WaterPistolApp() {
        // Конструктор залишається порожнім, оскільки клас не потребує ініціалізації
    }

    /**
     * Головний метод програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Використання різних конструкторів
        WaterPistol defaultPistol = new WaterPistol();
        WaterPistol customPistol = new WaterPistol(150, 750);
        WaterPistol customMagazinePistol = new WaterPistol(new Magazine(200), 1000);
        WaterPistol fullyCustomPistol = new WaterPistol(
            new Magazine(250),
            new Barrel(),
            new Trigger(),
            new RelativePosition(),
            1500
        );

        // Тестування різних пістолетів
        testPistol(defaultPistol, "Пістолет за замовчуванням");
        testPistol(customPistol, "Користувацький пістолет");
        testPistol(customMagazinePistol, "Пістолет з користувацьким магазином");
        testPistol(fullyCustomPistol, "Повністю користувацький пістолет");
    }

    /**
     * Метод для тестування водяного пістолета.
     *
     * @param pistol водяний пістолет для тестування
     * @param description опис пістолета
     */
    private static void testPistol(WaterPistol pistol, String description) {
        System.out.println("\nТестування " + description + ":");
        System.out.println("Тип: " + pistol.getType());
        System.out.println("Ємність: " + pistol.getCapacity() + " мл");

        for (int i = 0; i < 3; i++) {
            pistol.shoot();
        }

        System.out.println("Залишилось води: " + pistol.getAmmoCount() + " мл");
        pistol.reload();
        System.out.println("Після перезарядки: " + pistol.getAmmoCount() + " мл");

        pistol.aim(5, 5);
        System.out.println("Позиція: (" + pistol.getPistolXPosition() + ", " + pistol.getPistolYPosition() + ")");

        pistol.dispose();
    }
}