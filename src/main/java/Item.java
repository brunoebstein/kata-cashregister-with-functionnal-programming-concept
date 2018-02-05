import java.util.Objects;

public class Item {

    private final String itemCode;
    private final Price unitPrice;

    public boolean hasItemCode(String itemCode) {
        return Objects.equals(this.itemCode, itemCode);
    }

    public Price getUnitPrice() {
        return unitPrice;
    }

    public static final class Builder {
        private String itemCode;
        private Price unitPrice;

        public Builder withItemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public Builder withUnitPrice(double unitPrice) {
            this.unitPrice = Price.valueOf(unitPrice);
            return this;
        }

        public Item build() {
            return new Item(itemCode, unitPrice);
        }
    }

    public static Builder aReference() {
        return new Builder();
    }

    public Item(String itemCode, Price unitPrice) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
    }
}
