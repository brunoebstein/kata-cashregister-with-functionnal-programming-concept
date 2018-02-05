import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {

    @ParameterizedTest
    @CsvSource({
            "1.20,1,1.20",
            "1.42,1,1.42",
            "1.60,2,3.20",
    })
    public void should_calculate_the_total_price_by_quantity(double price, double quantity, double totalExpected) {
        CashRegister cashRegister = new CashRegister();

        Price total = cashRegister.total(Price.valueOf(price), quantity);

        assertThat(total).isEqualTo(Price.valueOf(totalExpected));
    }
/*
    @Test
    public void should_calculate_the_total_price_with_Price_by_quantity() {
        CashRegister cashRegister = new CashRegister();
        Price price = new Price(1.20);
        Quantity quantity = 1;

        Price total = cashRegister.total(price, quantity);

        assertThat(total).isEqualTo(new Price(1.20));
    }*/
}
