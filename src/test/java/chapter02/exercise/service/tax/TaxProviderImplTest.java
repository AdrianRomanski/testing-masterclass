package chapter02.exercise.service.tax;

import chapter02.exercise.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chapter02.exercise.enums.Country.BELGIUM;
import static org.assertj.core.api.Assertions.assertThat;

class TaxProviderImplTest {

    public static final String FIRST_NAME = "Walter";
    public static final String LAST_NAME = "White";
    TaxProvider taxProvider;

    @BeforeEach
    void setUp() {
        taxProvider = new TaxProviderImpl();
    }

    @Test
    @DisplayName("Get Default Vat")
    void getDefaultVat() {
        //when
        var tax = taxProvider.getDefaultVat();
        //then
        assertThat(tax).isEqualTo(0.23);
    }

    @Test
    @DisplayName("Get Vat for User")
    void getVatForUser() {
        //given
        var user = User.builder().firstName(FIRST_NAME).lastName(LAST_NAME).country(BELGIUM).build();
        //when
        var tax = taxProvider.getVatForUser(user);
        //then
        assertThat(tax).isEqualTo(0.33);
    }
}