package KI306.Protsak.Lab3;

import java.io.FileNotFoundException;

/**
 * Клас, що представляє водяний пістолет.
 */
public class WaterPistol extends Pistol implements Shootable, Reloadable {
	  /** Загальна ємність води в пістолеті. */
    private int waterCapacity;
    /** Поточна кількість води в пістолеті. */
    private int currentWater;

    /**
     * Конструктор за замовчуванням.
     *
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public WaterPistol() throws FileNotFoundException {
        this(100, 500); // Значення за замовчуванням
    }

    /**
     * Конструктор з вказаною ємністю магазину та води.
     *
     * @param ammoCapacity ємність магазину
     * @param waterCapacity ємність води
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public WaterPistol(int ammoCapacity, int waterCapacity) throws FileNotFoundException {
        super(ammoCapacity);
        this.waterCapacity = waterCapacity;
        this.currentWater = waterCapacity;
        logAction("Водяний пістолет створено з ємністю води: " + waterCapacity + " мл");
    }

    /**
     * Конструктор з користувацьким магазином та ємністю води.
     *
     * @param magazine користувацький магазин
     * @param waterCapacity ємність води
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public WaterPistol(Magazine magazine, int waterCapacity) throws FileNotFoundException {
        super(magazine);
        this.waterCapacity = waterCapacity;
        this.currentWater = waterCapacity;
        logAction("Водяний пістолет створено з користувацьким магазином та ємністю води: " + waterCapacity + " мл");
    }

    /**
     * Конструктор з повністю користувацькими компонентами.
     *
     * @param magazine користувацький магазин
     * @param barrel користувацький ствол
     * @param trigger користувацький спусковий гачок
     * @param position користувацька позиція
     * @param waterCapacity ємність води
     * @throws FileNotFoundException якщо не вдалося створити файл для логування
     */
    public WaterPistol(Magazine magazine, Barrel barrel, Trigger trigger, RelativePosition position, int waterCapacity) throws FileNotFoundException {
        super(magazine, barrel, trigger, position);
        this.waterCapacity = waterCapacity;
        this.currentWater = waterCapacity;
        logAction("Водяний пістолет створено з користувацькими компонентами та ємністю води: " + waterCapacity + " мл");
    }

    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void fire() {
        if (trigger.isPulled() && currentWater > 0) {
            currentWater -= 10; // Припустимо, що кожен постріл використовує 10 мл води
            barrel.fire();
            logAction("Водяний пістолет вистрілив. Залишилось води: " + currentWater + " мл");
        } else {
            logAction("Зрив стрільби або відсутня вода");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shoot() {
        pullTrigger();
        fire();
        releaseTrigger();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        currentWater = waterCapacity;
        logAction("Водяний пістолет перезаряджено. Поточний об'єм води: " + currentWater + " мл");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAmmoCount() {
        return currentWater;
    }

    /**
     * Доливає воду у пістолет.
     *
     * @param amount кількість води для доливання
     */
    public void fillWater(int amount) {
        currentWater = Math.min(currentWater + amount, waterCapacity);
        logAction("Додано " + amount + " мл води. Поточний об'єм: " + currentWater + " мл");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCapacity() {
        return waterCapacity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return "Водяний пістолет";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return currentWater == 0;
    }
}
