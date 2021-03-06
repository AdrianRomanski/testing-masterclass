package chapter02.exercise.service.product_service;

import chapter02.exercise.service.id_generator.UUIDGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    private static final UUID ID = UUID.randomUUID();
    public static final String NAME = "Coca Cola";
    public static final double PRICE = 2.20;

    @Mock
    UUIDGenerator uuidGenerator;
    @InjectMocks
    ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should Create New Product With Name,Price Without Tax and AutoGenerated ID")
    void createProduct() {
        //when
        when(uuidGenerator.getNext()).thenReturn(ID.toString());

        var returnProduct = productService.createProduct(NAME, PRICE);
        //then
        assertThat(returnProduct.getId()).isEqualTo(ID);
        assertThat(returnProduct.getName()).isEqualTo(NAME);
        assertThat(returnProduct.getPriceWithoutTax()).isEqualTo(PRICE);
    }
}