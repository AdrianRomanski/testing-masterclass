package chapter02.lesson;

import java.math.BigDecimal;
import java.math.MathContext;

public class VatService {

    VatProvider vatProvider;

    BigDecimal vatValue;

    public VatService(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    public BigDecimal getGrossPriceForDefaultVat(Product product) throws IncorrectVatException {
        return calculateGrossPrice(product.getNetPrice(), vatProvider.getDefaultVat());
    }

    public BigDecimal getGrossPrice(BigDecimal netPrice, String productType) throws IncorrectVatException {
        BigDecimal vatValue = vatProvider.getVatForType(productType);
        return calculateGrossPrice(netPrice, vatValue);
    }

    private BigDecimal calculateGrossPrice(BigDecimal netPrice, BigDecimal vatValue) throws IncorrectVatException {
        MathContext m = new MathContext(4);
        if(vatValue.compareTo(BigDecimal.ONE) == 1) {
            throw new IncorrectVatException("Vat must be lower!");
        }
        return netPrice.multiply(vatValue.add(BigDecimal.ONE)).round(m);
    }
}
