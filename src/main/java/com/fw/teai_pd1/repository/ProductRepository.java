package com.fw.teai_pd1.repository;

import com.fw.teai_pd1.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Repository
public class ProductRepository implements CommandLineRunner {

    private static final int LOWER_LIMIT = 50;
    private static final int UPPER_LIMIT = 300;

    private List<Product> products = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product("Product_1", new BigDecimal(generateRandomPrice()));
        Product product2 = new Product("Product_2", new BigDecimal(generateRandomPrice()));
        Product product3 = new Product("Product_3", new BigDecimal(generateRandomPrice()));
        Product product4 = new Product("Product_4", new BigDecimal(generateRandomPrice()));
        Product product5 = new Product("Product_5", new BigDecimal(generateRandomPrice()));

        this.products.addAll(Arrays.asList(product1, product2, product3, product4, product5));
    }

    private int generateRandomPrice() {
        Random rnd = new Random();
        return rnd.nextInt(UPPER_LIMIT - LOWER_LIMIT) + LOWER_LIMIT;
    }

    public List<Product> fetchProducts() {
        return products;
    }


}
