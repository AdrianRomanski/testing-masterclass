package chapter02.exercise.service.payments;

import chapter02.exercise.model.Payment;
import chapter02.exercise.model.Product;
import chapter02.exercise.model.User;
import chapter02.exercise.service.id_generator.IdGenerator;
import chapter02.exercise.service.id_generator.IdGeneratorType;
import chapter02.exercise.service.tax.TaxProvider;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class PaymentsServiceImpl implements PaymentsService {

    private final TaxProvider taxProvider;
    private final IdGenerator IdGenerator;


    public PaymentsServiceImpl(TaxProvider taxProvider,
                               @IdGeneratorType("uuidGenerator") IdGenerator IdGenerator) {
        this.taxProvider = taxProvider;
        this.IdGenerator = IdGenerator;
    }


    @Override
    public Payment addPayment(User user, List<Product> products) {
        var payment = Payment.builder()
                .id(UUID.fromString(IdGenerator.getNext()))
                .products(products)
                .user(user)
                .tax(taxProvider.getVatForUser(user))
                .build();
        user.getPayments().add(payment);
        return payment;
    }


    @Override
    public Double countFinalPrice(Payment payment) {
        var finalPrice = 0.0;
        List<Double> prices = payment.getProducts()
                .stream()
                .map(Product::getPriceWithoutTax)
                .collect(Collectors.toList());
        for(Double price: prices) {
            price = price + (price * payment.getTax());
            finalPrice+=price;
        }
        return finalPrice;
    }
}
