import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {
    PriceQuery priceQuery = new PriceQuery(
            Item.aReference().withItemCode("APPLE").withUnitPrice(1.20).build(),
            Item.aReference().withItemCode("BANANA").withUnitPrice(1.90).build()
    );

    @ParameterizedTest
    @CsvSource({
            "1.20,1,1.20",
            "1.42,1,1.42",
            "1.60,2,3.20",
    })
    public void should_calculate_the_total_price_by_quantity(double price, double quantity, double totalExpected) {
        CashRegister cashRegister = new CashRegister();

        Price total = cashRegister.total(Price.valueOf(price), Quantity.valueOf(quantity));

        assertThat(total).isEqualTo(Price.valueOf(totalExpected));
    }

    @ParameterizedTest
    @CsvSource({
            "APPLE,1,1.20",
            "APPLE,2,1.20",
            "BANANA,10,1.90",
    })
    public void total_is_product_of_quantity_by_item_price_corresponding_to_existing_item_code(String itemCode, double quantity, double unitPrice){
        CashRegister cashRegister = new CashRegister();
        Result total = cashRegister.total(priceQuery.findPrice(itemCode), Quantity.valueOf(quantity));

        assertThat(total).isEqualTo(Result.found(Price.valueOf(quantity * unitPrice)));
    }

    @Test
    public void total_not_found_when_item_price_not_found() {
        CashRegister cashRegister = new CashRegister();
        Result total = cashRegister.total(priceQuery.findPrice("PEACH"), Quantity.valueOf(1));

        assertThat(total).isEqualTo(Result.notFound("PEACH"));
    }
}
