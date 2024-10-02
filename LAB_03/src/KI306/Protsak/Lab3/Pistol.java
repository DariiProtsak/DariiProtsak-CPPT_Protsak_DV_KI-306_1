package KI306.Protsak.Lab3;

import java.io.*;

/**
 * Абстрактний клас, що представляє пістолет.
 */
public abstract class Pistol {
    /** Магазин пістолета. */
    protected Magazine magazine;
    
    /** Ствол пістолета. */
    protected Barrel barrel;
    
    /** Спусковий гачок пістолета. */
    protected Trigger trigger;
    
    /** Відносна позиція пістолета. */
    protected RelativePosition position;
    
    /** Об'єкт для запису логів у файл. */
    protected PrintWriter fout;

    /**
     * Конструктор за замовчуванням.
     *
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public Pistol() throws FileNotFoundException {
        this(15); // Ємність магазину за замовчуванням
    }

    /**
     * Конструктор з вказаною ємністю магазину.
     *
     * @param ammoCapacity ємність магазину
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public Pistol(int ammoCapacity) throws FileNotFoundException {
        this(new Magazine(ammoCapacity), new Barrel(), new Trigger(), new RelativePosition());
    }

    /**
     * Конструктор з користувацькими компонентами.
     *
     * @param magazine магазин
     * @param barrel ствол
     * @param trigger спусковий гачок
     * @param position позиція
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public Pistol(Magazine magazine, Barrel barrel, Trigger trigger, RelativePosition position) throws FileNotFoundException {
        this.magazine = magazine;
        this.barrel = barrel;
        this.trigger = trigger;
        this.position = position;
        this.fout = new PrintWriter(new File("PistolLog.txt"));
        logAction("Пістолет створено з користувацькими компонентами.");
    }

    /**
     * Конструктор з користувацьким магазином.
     *
     * @param magazine користувацький магазин
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public Pistol(Magazine magazine) throws FileNotFoundException {
        this(magazine, new Barrel(), new Trigger(), new RelativePosition());
    }

    /**
     * Абстрактний метод для здійснення пострілу.
     */
    public abstract void fire();

    /**
     * Натискає спусковий гачок.
     */
    public void pullTrigger() {
        trigger.pull();
        logAction("Спусковий гачок натиснуто");
    }

    /**
     * Відпускає спусковий гачок.
     */
    public void releaseTrigger() {
        trigger.release();
        logAction("Спусковий гачок відпущено");
    }

    /**
     * Встановлює позицію пістолета.
     *
     * @param x координата x
     * @param y координата y
     */
    public void setPistolPosition(int x, int y) {
        position.setPosition(x, y);
        logAction("Позиція пістолета встановлена: (" + x + ", " + y + ")");
    }

    /**
     * Повертає x-координату пістолета.
     *
     * @return x-координата
     */
    public int getPistolXPosition() {
        return position.getXPosition();
    }

    /**
     * Повертає y-координату пістолета.
     *
     * @return y-координата
     */
    public int getPistolYPosition() {
        return position.getYPosition();
    }

    /**
     * Логує дію пістолета.
     *
     * @param action дія для логування
     */
    protected void logAction(String action) {
        System.out.println(action);
        fout.println(action);
        fout.flush();
    }

    /**
     * Звільняє ресурси пістолета.
     */
    public void dispose() {
        logAction("Ресурси пістолета звільнені");
        fout.close();
    }

    /**
     * Абстрактний метод для перезарядки пістолета.
     */
    public abstract void reload();

    /**
     * Очищає ствол пістолета.
     */
    public void cleanBarrel() {
        barrel.clean();
        logAction("Ствол очищено");
    }

    /**
     * Перевіряє, чи чистий ствол.
     *
     * @return true, якщо ствол чистий, інакше false
     */
    public boolean isBarrelClean() {
        return barrel.isClean();
    }

    /**
     * Абстрактний метод для отримання ємності пістолета.
     *
     * @return ємність пістолета
     */
    public abstract int getCapacity();

    /**
     * Абстрактний метод для перевірки, чи пістолет порожній.
     *
     * @return true, якщо пістолет порожній, інакше false
     */
    public abstract boolean isEmpty();

    /**
     * Наводить пістолет на вказану позицію.
     *
     * @param x координата x
     * @param y координата y
     */
    public void aim(int x, int y) {
        setPistolPosition(x, y);
        logAction("Пістолет наведено на позицію (" + x + ", " + y + ")");
    }
    /**
     * Абстрактний метод для отримання типу пістолета.
     *
     * @return тип пістолета
     */
    public abstract String getType();
}