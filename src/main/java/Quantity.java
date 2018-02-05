public class Quantity {
    private final double value;

    public static Quantity valueOf(double value) {
        return new Quantity(value);
    }

    private Quantity(double value) {
        this.value = value;
    }

    public double multiplyBy(double value) {
        return this.value*value;
    }
}
