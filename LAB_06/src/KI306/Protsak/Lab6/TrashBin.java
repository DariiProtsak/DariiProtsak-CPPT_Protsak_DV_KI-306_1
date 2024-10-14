package KI306.Protsak.Lab6;

import java.util.ArrayList;

/**
 * Параметризований клас, що реалізує бак для сміття
 * @param <T> тип елементів, які зберігаються в баку
 * @author Darii Protsak
 * @version 1.1
 */
public class TrashBin<T extends Trash> {
    private ArrayList<T> items;
    private int capacity;

    /**
     * Конструктор класу TrashBin
     * @param capacity максимальна місткість бака
     */
    public TrashBin(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * Додає елемент до бака
     * @param item елемент для додавання
     * @return true, якщо елемент успішно додано, false - якщо бак повний
     */
    public boolean addItem(T item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Видаляє елемент з бака
     * @param index індекс елемента для видалення
     * @return видалений елемент або null, якщо індекс невірний
     */
    public T removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        return null;
    }

    /**
     * Знаходить елемент з максимальною вагою
     * @return елемент з максимальною вагою або null, якщо бак порожній
     */
    public T findMaxWeight() {
        if (items.isEmpty()) {
            return null;
        }
        T maxItem = items.get(0);
        for (T item : items) {
            if (item.getWeight() > maxItem.getWeight()) {
                maxItem = item;
            }
        }
        return maxItem;
    }

    /**
     * Обчислює загальну вагу всього сміття в баку
     * @return загальна вага сміття
     */
    public double getTotalWeight() {
        double totalWeight = 0;
        for (T item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    /**
     * Виводить вміст бака
     */
    public void printContents() {
        System.out.println("Вміст бака для сміття:");
        for (T item : items) {
            System.out.println(item);
        }
    }
}