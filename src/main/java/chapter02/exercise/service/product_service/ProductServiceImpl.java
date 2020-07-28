package chapter02.exercise.service.product_service;

import chapter02.exercise.model.Product;
import chapter02.exercise.service.id_generator.IdGenerator;
import chapter02.exercise.service.id_generator.IdGeneratorType;

import java.util.UUID;


public class ProductServiceImpl implements ProductService {

    private final IdGenerator idGenerator;

    public ProductServiceImpl(@IdGeneratorType("uuidGenerator") IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Product createProduct(String name, Double price) {
        return Product.builder()
                .name(name)
                .priceWithoutTax(price)
                .id(UUID.fromString(idGenerator.getNext()))
                .build();
    }
}
