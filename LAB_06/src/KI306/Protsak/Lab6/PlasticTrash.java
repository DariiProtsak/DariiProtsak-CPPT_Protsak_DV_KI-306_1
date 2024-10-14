package KI306.Protsak.Lab6;

/**
 * Клас, що представляє пластикове сміття
 * @author Darii Protsak
 * @version 1.0
 */
public class PlasticTrash implements Trash {
    private double weight;

    /**
     * Конструктор класу PlasticTrash
     * @param weight вага пластикового сміття
     */
    public PlasticTrash(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getType() {
        return "Пластик";
    }

    @Override
    public String toString() {
        return "Пластикове сміття вагою " + weight + " кг";
    }
}