package chapter02.exercise.service.tax;

import chapter02.exercise.model.User;
import lombok.extern.java.Log;

@Log
public class TaxProviderImpl implements TaxProvider {

    @Override
    public Double getDefaultVat() {
        log.warning("Using Default Vat!!!");
        return 0.23;
    }

    @Override
    public Double getVatForUser(User user) {
        log.info("Vat for Country " + user.getCountry().getCountryName() + " is equal to " + user.getCountry().getTaxRatio());
        return user.getCountry().getTaxRatio();
    }

}
