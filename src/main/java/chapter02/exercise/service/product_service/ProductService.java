package chapter02.exercise.service.product_service;

import chapter02.exercise.model.Product;

public interface ProductService {

    Product createProduct(String name, Double price);
}
