package KI306.Protsak.Lab6;

/**
 * Клас, що представляє паперове сміття
 * @author Darii Protsak
 * @version 1.0
 */
public class PaperTrash implements Trash {
    private double weight;

    /**
     * Конструктор класу PaperTrash
     * @param weight вага паперового сміття
     */
    public PaperTrash(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getType() {
        return "Папір";
    }

    @Override
    public String toString() {
        return "Паперове сміття вагою " + weight + " кг";
    }
}