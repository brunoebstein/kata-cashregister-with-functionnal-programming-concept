import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceQueryTest {
    PriceQuery priceQuery = new PriceQuery(
            Item.aReference().withItemCode("APPLE").withUnitPrice(1.20).build(),
            Item.aReference().withItemCode("BANANA").withUnitPrice(1.90).build()
    );

    @ParameterizedTest
    @CsvSource({
            "APPLE,1.20",
            "BANANA, 1.90",
    })
    void find_the_price_given_an_item_code(String itemCode, double unitPrice) {
        assertThat(priceQuery.findPrice(itemCode)).isEqualTo(Result.found(Price.valueOf(unitPrice)));
    }

    @Test
    void search_an_unknown_item() {
        assertThat(priceQuery.findPrice("PEACH")).isEqualTo(Result.notFound("PEACH"));
    }

}