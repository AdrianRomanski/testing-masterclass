package chapter02.exercise.service.tax;

import chapter02.exercise.model.User;

public interface TaxProvider {

    Double getDefaultVat();

    Double getVatForUser(User user);
}
