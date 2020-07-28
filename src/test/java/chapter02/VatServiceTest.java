package chapter02;

import chapter02.lesson.IncorrectVatException;
import chapter02.lesson.Product;
import chapter02.lesson.VatProvider;
import chapter02.lesson.VatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

class VatServiceTest {

    VatProvider vatProvider;
    VatService vatService;

    @BeforeEach
    void prepareVatService() {
        vatProvider = Mockito.mock(VatProvider.class);
        vatService = new VatService(vatProvider);
    }


    @Test
    @DisplayName("should calculate gross price for default VAT")
    void shouldCalculateGrossPriceForDefaultVat() throws IncorrectVatException {
        when(vatProvider.getDefaultVat()).thenReturn(new BigDecimal("0.23"));

        Product product = generateProduct("20.00", "handbag");

        BigDecimal result = vatService.getGrossPriceForDefaultVat(product);

        assertThat(result).isEqualTo(new BigDecimal("24.60"));
    }

    @Test
    void shouldCalculateGrossPriceForOtherVatValue() throws IncorrectVatException {
        String type = "Book";

        Product product = generateProduct("10.00", type);

        when(vatProvider.getVatForType(type)).thenReturn(new BigDecimal("0.08"));

        BigDecimal result = vatService.getGrossPrice(product.getNetPrice(), type);

        assertThat(result).isEqualTo(new BigDecimal("10.80"));
    }


    @Test
    void shouldThrowExceptionWhenVatIsTooHigh() {
        String type = "Comic";
        Product product = generateProduct("10.00", type);

        when(vatProvider.getVatForType(type)).thenReturn(BigDecimal.TEN);

        assertThatExceptionOfType(IncorrectVatException.class).isThrownBy(() ->
                vatService.getGrossPrice(product.getNetPrice(), type))
                .withMessage("Vat must be lower!");
    }

    private Product generateProduct(String val, String type) {
        return new Product(UUID.randomUUID(), new BigDecimal(val),type);
    }
}