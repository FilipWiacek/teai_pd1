package com.fw.teai_pd1.controller;

import com.fw.teai_pd1.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
@Profile("BASIC")
public class ShopController {

    private static final Logger logger = LogManager.getLogger();

    private ProductRepository productRepository;

    @Autowired
    public ShopController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void retrieveProducts() {
        productRepository.fetchProducts().forEach(p -> logger.info("Product: " + p.getName() + " cost: " + p.getPrice()));
    }
}
