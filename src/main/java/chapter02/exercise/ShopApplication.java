package chapter02.exercise;

import chapter02.exercise.service.id_generator.IncrementIDGenerator;
import chapter02.exercise.service.id_generator.UUIDGenerator;
import chapter02.exercise.service.payments.PaymentsServiceImpl;
import chapter02.exercise.service.product_service.ProductServiceImpl;
import chapter02.exercise.service.tax.TaxProviderImpl;
import chapter02.exercise.service.user_service.UserServiceImpl;
import lombok.extern.java.Log;


import java.util.Arrays;

import static chapter02.exercise.enums.Country.POLAND;

@Log
public class ShopApplication {

    public static void main(String[] args) {

        final var taxProvider = new TaxProviderImpl();

        final var uuidGenerator = new UUIDGenerator();
        final var incrementIDGenerator = new IncrementIDGenerator();

        final var paymentsService = new PaymentsServiceImpl(taxProvider, uuidGenerator);
        final var userService = new UserServiceImpl(incrementIDGenerator);
        final var productService = new ProductServiceImpl(uuidGenerator);

        var user = userService.createUser("Adrian", "Romanski", POLAND);
        log.info("User id: " + user.getId());

        var book = productService.createProduct("Book", 14.99);
        var chocolateBar = productService.createProduct("Chocolate bar", 2.44);
        var coca_cola = productService.createProduct("Coca Cola", 1.59);

        var payment = paymentsService.addPayment(user, Arrays.asList(book, chocolateBar, coca_cola));
        log.info("Payment id: " + payment.getId());

        log.info("Final price of payment with Products: " + paymentsService.countFinalPrice(payment));

    }
}

