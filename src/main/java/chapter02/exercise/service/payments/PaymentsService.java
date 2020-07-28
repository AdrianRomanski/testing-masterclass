package chapter02.exercise.service.payments;

import chapter02.exercise.model.Payment;
import chapter02.exercise.model.Product;
import chapter02.exercise.model.User;

import java.util.List;

public interface PaymentsService {

    Payment addPayment(User user, List<Product> products);

    Double countFinalPrice(Payment payment);

}
