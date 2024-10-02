package KI306.Protsak.Lab2;

import java.io.*;

/**
 * Клас <code>Pistol</code> реалізує пістолет з різними функціональностями,
 * такими як стрільба, перезарядка та відстеження позиції.
 * 
 * @author Darii Protsak
 * @version 1.0
 */
public class Pistol {
    private Magazine magazine;
    private Barrel barrel;
    private Trigger trigger;
    private RelativePosition position;
    private PrintWriter fout;

    /**
     * Конструктор за замовчуванням для Pistol.
     * Ініціалізує всі компоненти та відкриває файл журналу.
     * 
     * @throws FileNotFoundException якщо файл журналу не може бути створений
     */
    public Pistol() throws FileNotFoundException {
        this(15); // Ємність магазину за замовчуванням
    }

    /**
     * Конструктор для Pistol з вказаною ємністю магазину.
     * 
     * @param ammoCapacity ємність магазину
     * @throws FileNotFoundException якщо файл журналу не може бути створений
     */
    public Pistol(int ammoCapacity) throws FileNotFoundException {
        magazine = new Magazine(ammoCapacity);
        barrel = new Barrel();
        trigger = new Trigger();
        position = new RelativePosition();
        fout = new PrintWriter(new File("PistolLog.txt"));
        System.out.println("Пістолет створений з ємністю магазину: " + ammoCapacity);
    }

    /**
     * Конструктор для Pistol з усіма наданими компонентами.
     * 
     * @param magazine магазин для пістолета
     * @param barrel ствол пістолета
     * @param trigger спусковий гачок пістолета
     * @param position позиція пістолета
     * @throws FileNotFoundException якщо файл журналу не може бути створений
     */
    public Pistol(Magazine magazine, Barrel barrel, Trigger trigger, RelativePosition position) throws FileNotFoundException {
        this.magazine = magazine;
        this.barrel = barrel;
        this.trigger = trigger;
        this.position = position;
        fout = new PrintWriter(new File("PistolLog.txt"));
        System.out.println("Пістолет створений з користувацькими компонентами.");
    }

    /**
     * Конструктор для Pistol з вже існуючим магазином.
     * Інші компоненти ініціалізуються за замовчуванням.
     * 
     * @param magazine магазин для пістолета
     * @throws FileNotFoundException якщо файл журналу не може бути створений
     */
    public Pistol(Magazine magazine) throws FileNotFoundException {
        this.magazine = magazine;
        this.barrel = new Barrel();
        this.trigger = new Trigger();
        this.position = new RelativePosition();
        fout = new PrintWriter(new File("PistolLog.txt"));
        System.out.println("Пістолет створений з уже існуючим магазином.");
    }

    /**
     * Симулює стрільбу з пістолета.
     * Перевіряє, чи спусковий гачок натиснутий і чи є патрони перед стрільбою.
     */
    public void fire() {
        if (trigger.isPulled() && magazine.useAmmo()) {
            barrel.fire();
            System.out.println("Пістолет вистрілив. Залишилось патронів: " + magazine.getAmmo());
        } else {
            System.out.println("Зрив стрільби або відсутні патрони");
        }
        fout.println("Спроба стрільби. Патрони: " + magazine.getAmmo() + ", Спусковий гачок: " + (trigger.isPulled() ? "натиснуто" : "відпущено"));
        fout.flush();
    }

    /**
     * Перезаряджає магазин пістолета до повної ємності.
     */
    public void reload() {
        magazine.reload();
        System.out.println("Пістолет перезаряджено. Поточні патрони: " + magazine.getAmmo());
        fout.println("Пістолет перезаряджено. Патрони: " + magazine.getAmmo());
        fout.flush();
    }

    /**
     * Симулює натискання спускового гачка пістолета.
     */
    public void pullTrigger() {
        trigger.pull();
        System.out.println("Спусковий гачок натиснуто");
        fout.println("Спусковий гачок натиснуто");
        fout.flush();
    }

    /**
     * Симулює відпускання спускового гачка пістолета.
     */
    public void releaseTrigger() {
        trigger.release();
        System.out.println("Спусковий гачок відпущено");
        fout.println("Спусковий гачок відпущено");
        fout.flush();
    }

    /**
     * Симулює очищення ствола пістолета.
     */
    public void cleanBarrel() {
        barrel.clean();
        System.out.println("Ствол очищено");
        fout.println("Ствол очищено");
        fout.flush();
    }

    /**
     * Встановлює нову позицію пістолета.
     * 
     * @param x координата X позиції пістолета
     * @param y координата Y позиції пістолета
     */
    public void setPistolPosition(int x, int y) {
        position.setXPosition(x);
        position.setYPosition(y);
        System.out.println("Позиція пістолета встановлена: (" + x + ", " + y + ")");
        fout.println("Позиція пістолета встановлена: (" + x + ", " + y + ")");
        fout.flush();
    }

    /**
     * Повертає поточну координату X пістолета.
     * 
     * @return поточна координата X
     */
    public int getPistolXPosition() {
        return position.getXPosition();
    }

    /**
     * Повертає поточну координату Y пістолета.
     * 
     * @return поточна координата Y
     */
    public int getPistolYPosition() {
        return position.getYPosition();
    }

    /**
     * Повертає поточну кількість патронів у магазині.
     * 
     * @return поточна кількість патронів
     */
    public int getAmmoCount() {
        return magazine.getAmmo();
    }

    /**
     * Перевіряє, чи є ствол чистим.
     * 
     * @return true, якщо ствол чистий, false в іншому випадку
     */
    public boolean isBarrelClean() {
        return barrel.isClean();
    }

    /**
     * Звільняє ресурси, використані екземпляром пістолета.
     * Закриває файл журналу.
     */
    public void dispose() {
        System.out.println("Звільнення ресурсів пістолета");
        fout.println("Ресурси пістолета звільнені");
        fout.close();
    }
}

/**
 * Клас <code>Magazine</code> представляє магазин пістолета.
 */
class Magazine {
    private int capacity;
    private int currentAmmo;

    /**
     * Конструктор для Magazine з вказаною ємністю.
     * 
     * @param capacity максимальна кількість патронів, яку може вмістити магазин
     */
    public Magazine(int capacity) {
        this.capacity = capacity;
        this.currentAmmo = capacity;
    }

    /**
     * Симулює використання одного патрона.
     * 
     * @return true, якщо патрон успішно використано, false, якщо магазин порожній
     */
    public boolean useAmmo() {
        if (currentAmmo > 0) {
            currentAmmo--;
            return true;
        }
        return false;
    }

    /**
     * Перезаряджає магазин до повної ємності.
     */
    public void reload() {
        currentAmmo = capacity;
    }

    /**
     * Повертає поточну кількість патронів у магазині.
     * 
     * @return поточна кількість патронів
     */
    public int getAmmo() {
        return currentAmmo;
    }
}

/**
 * Клас <code>Barrel</code> представляє ствол пістолета.
 */
class Barrel {
    private boolean isClean;

    /**
     * Конструктор для Barrel. Ініціалізує як чистий.
     */
    public Barrel() {
        isClean = true;
    }

    /**
     * Симулює стрільбу, що робить ствол брудним.
     */
    public void fire() {
        isClean = false;
    }

    /**
     * Очищає ствол.
     */
    public void clean() {
        isClean = true;
    }

    /**
     * Перевіряє, чи є ствол чистим.
     * 
     * @return true, якщо ствол чистий, false в іншому випадку
     */
    public boolean isClean() {
        return isClean;
    }
}

/**
 * Клас <code>Trigger</code> представляє спусковий гачок пістолета.
 */
class Trigger {
    private boolean isPulled;

    /**
     * Конструктор для Trigger. Ініціалізує як не натиснутий.
     */
    public Trigger() {
        isPulled = false;
    }

    /**
     * Симулює натискання спускового гачка.
     */
    public void pull() {
        isPulled = true;
    }

    /**
     * Симулює відпускання спускового гачка.
     */
    public void release() {
        isPulled = false;
    }

    /**
     * Перевіряє, чи спусковий гачок в даний момент натиснутий.
     * 
     * @return true, якщо спусковий гачок натиснутий, false в іншому випадку
     */
    public boolean isPulled() {
        return isPulled;
    }
}

/**
 * Клас <code>RelativePosition</code> представляє 2D позицію.
 */
class RelativePosition {
    private int x, y;

    /**
     * Конструктор для RelativePosition. Ініціалізує (0,0).
     */
    public RelativePosition() {
        x = 0;
        y = 0;
    }

    /**
     * Повертає координату X.
     * 
     * @return координата X
     */
    public int getXPosition() {
        return x;
    }

    /**
     * Повертає координату Y.
     * 
     * @return координата Y
     */
    public int getYPosition() {
        return y;
    }

    /**
     * Встановлює координату X.
     * 
     * @param x нова координата X
     */
    public void setXPosition(int x) {
        this.x = x;
    }

    /**
     * Встановлює координату Y.
     * 
     * @param y нова координата Y
     */
    public void setYPosition(int y) {
        this.y = y;
    }
}
