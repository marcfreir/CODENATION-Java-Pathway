package desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class CalculadorDeClassesTest {
    @Somar
    private BigDecimal bigDecimal1 = BigDecimal.TEN;

    @Subtrair
    private BigDecimal bigDecimal2 = BigDecimal.ONE;
}
