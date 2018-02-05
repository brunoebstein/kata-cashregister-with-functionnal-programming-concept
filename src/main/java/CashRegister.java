import java.util.function.UnaryOperator;

public class CashRegister {

    public Price total(Price price, Quantity quantity) {
        return price.multiplyBy(quantity);
    }

    public Result total(Result resultPrice, Quantity quantity) {
        return resultPrice.map(price -> price.multiplyBy(quantity));
    }
}
