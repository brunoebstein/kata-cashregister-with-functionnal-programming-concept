import java.util.Objects;

public class Price {
    private final double value;

    public static Price valueOf(double value) {
        return new Price(value);
    }

    private Price(double value) {
        this.value = value;
    }

    public Price multiplyBy(Quantity quantity) {
        return valueOf(quantity.multiplyBy(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.value, value) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
