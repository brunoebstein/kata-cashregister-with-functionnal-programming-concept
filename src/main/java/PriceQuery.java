import java.util.Arrays;

public class PriceQuery {
    private final Item[] items;

    public PriceQuery(Item ... items) {
        this.items = items;
    }

    public Result findPrice(String itemCode) {
        for (Item item : items) {

            if(item.hasItemCode(itemCode)) {
                return Result.found(item.getUnitPrice());
            }

        }
        return Result.notFound(itemCode);
    }
}
