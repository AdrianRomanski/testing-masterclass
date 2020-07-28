package chapter02.lesson;

import java.math.BigDecimal;

public interface VatProvider {

    BigDecimal getDefaultVat();

    BigDecimal getVatForType(String type);

}
