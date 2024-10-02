package KI306.Protsak.Lab2;

import java.io.*;

/**
 * Клас PistolApp реалізує основний метод для демонстрації можливостей класу Pistol
 * 
 * @author Darii Protsak
 * @version 1.0
 */
public class PistolApp {
    /**
     * Основний метод, який демонструє функціональність класу Pistol
     * 
     * @param args аргументи командного рядка (не використовуються)
     * @throws FileNotFoundException якщо файл журналу не може бути створений
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Створення пістолета з ємністю на 10 патронів");
        Pistol pistol1 = new Pistol(10);

        System.out.println("\nСтворення пістолета з користувацькими компонентами:");
        Magazine customMagazine = new Magazine(20);
        Barrel customBarrel = new Barrel();
        Trigger customTrigger = new Trigger();
        RelativePosition customPosition = new RelativePosition();
        Pistol pistol2 = new Pistol(customMagazine, customBarrel, customTrigger, customPosition);

        System.out.println("\nСтворення пістолета з вже існуючим магазином:");
        Pistol pistol3 = new Pistol(new Magazine(5));

        System.out.println("\nТестування механізму стрільби для pistol2:");
        pistol2.pullTrigger();
        pistol2.fire();
        pistol2.releaseTrigger();

        System.out.println("\nТестування перезарядки для pistol3:");
        pistol3.reload();

        System.out.println("\nТестування налаштування позиції для pistol1:");
        pistol1.setPistolPosition(5, 3);
        System.out.println("Поточна позиція: (" + pistol1.getPistolXPosition() + ", " + pistol1.getPistolYPosition() + ")");

        System.out.println("\nТестування очищення ствола для pistol2:");
        pistol2.cleanBarrel();
        System.out.println("Ствол чистий: " + pistol2.isBarrelClean());

        System.out.println("\nТестування стрільби до повного використання патронів для pistol1:");
        for (int i = 0; i < 10; i++) {
            pistol1.pullTrigger();
            pistol1.fire();
            pistol1.releaseTrigger();
        }

        System.out.println("\nКінцевий запас патронів для pistol1: " + pistol1.getAmmoCount());

        System.out.println("\nЗвільнення ресурсів пістолетів");
        pistol1.dispose();
        pistol2.dispose();
        pistol3.dispose();
    }
}
