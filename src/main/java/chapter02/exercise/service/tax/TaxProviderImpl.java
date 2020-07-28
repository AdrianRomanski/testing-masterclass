package chapter02.exercise.service.tax;

import chapter02.exercise.model.User;

public class TaxProviderImpl implements TaxProvider {

    @Override
    public Double getDefaultVat() {
        return 0.23;
    }

    @Override
    public Double getVatForUser(User user) {
        return user.getCountry().getTaxRatio();
    }

}
