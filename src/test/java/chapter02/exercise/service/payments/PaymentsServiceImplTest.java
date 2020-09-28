package chapter02.exercise.service.payments;

import chapter02.exercise.model.Payment;
import chapter02.exercise.model.Product;
import chapter02.exercise.model.User;
import chapter02.exercise.service.id_generator.UUIDGenerator;
import chapter02.exercise.service.tax.TaxProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static chapter02.exercise.enums.Country.POLAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class PaymentsServiceImplTest {

    public static final double TAX = 0.23;
    private static final UUID ID = UUID.randomUUID();

    @Mock
    TaxProvider taxProvider;
    @Mock
    UUIDGenerator uuidGenerator;
    @InjectMocks
    PaymentsServiceImpl paymentsService;

    User user;
    List<Product> products;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        user = createUser();
        products = getProducts();
    }

    @Test
    @DisplayName("Should Create New Payment and Add it to The User")
    void addPayment() {
        //when
        when(taxProvider.getVatForUser(user)).thenReturn(TAX);
        when(uuidGenerator.getNext()).thenReturn(String.valueOf(ID));

        var payment = paymentsService.addPayment(user, products);

        //then
        assertThat(payment.getId()).isEqualTo(ID);
        assertThat(payment.getProducts().size()).isEqualTo(3);
        assertThat(payment.getTax()).isEqualTo(TAX);
    }


    @Test
    @DisplayName("Should Count Final Price From Base Product Price And Tax From User Country")
    void countFinalPrice() {
        //given
        var payment = Payment.builder().tax(TAX).id(ID).products(products).user(user).build();
        //when
        var result = paymentsService.countFinalPrice(payment);
        // 3 products - Snickers(1.00 + (0.23 * 1.00)), Coca Cola(2.00 + (0.23 * 1.00)), Lays(3.00 + (0.23 * 1.00)) = 7.38
        //then
        assertThat(result).isEqualTo(7.38);
    }

    private User createUser() { return User.builder().firstName("Walter").lastName("White").country(POLAND).build(); }

    private List<Product> getProducts() {
        var lays = Product.builder().name("Lays").priceWithoutTax(3.00).build();
        var cocaCola = Product.builder().name("Coca Cola").priceWithoutTax(2.00).build();
        var snickers = Product.builder().name("Snickers").priceWithoutTax(1.00).build();
        return Arrays.asList(lays, cocaCola, snickers);
    }
}