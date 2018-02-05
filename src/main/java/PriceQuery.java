import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class PriceQuery {
    private final Item[] items;

    public PriceQuery(Item ... items) {
        this.items = items;
    }

    public Result findPrice(String itemCode) {
        return Stream.of(items)
                .filter(item -> item.hasItemCode(itemCode))
                .map(Item::getUnitPrice)
                .map(Result::found)
                .findFirst()
                    .orElseGet(()->Result.notFound(itemCode));
    }
}
