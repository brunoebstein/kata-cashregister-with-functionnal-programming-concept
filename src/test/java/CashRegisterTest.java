import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {

    @ParameterizedTest
    @CsvSource({
            "1.20,1,1.20",
    })
    public void should_calculate_the_total_price_by_quantity(double price, double quantity, double totalExpected) {
        CashRegister cashRegister = new CashRegister();

        double total = cashRegister.total(price,quantity);

        assertThat(total).isEqualTo(totalExpected);
    }
}
