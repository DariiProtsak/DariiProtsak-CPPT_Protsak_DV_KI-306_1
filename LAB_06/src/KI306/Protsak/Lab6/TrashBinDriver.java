package KI306.Protsak.Lab6;

/**
 * Головний клас для тестування функціональності TrashBin
 * @author Darii Protsak
 * @version 1.1
 */
public class TrashBinDriver {
    /**
     * Головний метод програми
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        TrashBin<Trash> bin = new TrashBin<>(5);

        bin.addItem(new PlasticTrash(0.5));
        bin.addItem(new PaperTrash(0.3));
        bin.addItem(new PlasticTrash(0.7));
        bin.addItem(new PaperTrash(0.2));
        bin.addItem(new PlasticTrash(0.4));

        System.out.println("Початковий вміст бака:");
        bin.printContents();

        Trash maxWeightItem = bin.findMaxWeight();
        System.out.println("\nЕлемент з максимальною вагою:");
        System.out.println(maxWeightItem);

        System.out.println("\nЗагальна вага сміття в баку:");
        System.out.println(bin.getTotalWeight() + " кг");

        System.out.println("\nВидаляємо елемент з індексом 2:");
        Trash removedItem = bin.removeItem(2);
        System.out.println("Видалений елемент: " + removedItem);

        System.out.println("\nОновлений вміст бака:");
        bin.printContents();

        System.out.println("\nНова загальна вага сміття в баку:");
        System.out.println(bin.getTotalWeight() + " кг");
    }
}