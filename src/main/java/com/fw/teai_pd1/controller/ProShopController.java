package com.fw.teai_pd1.controller;

import com.fw.teai_pd1.repository.ProductRepository;
import com.fw.teai_pd1.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
@Profile("PRO")
public class ProShopController {

    private static final Logger logger = LogManager.getLogger();

    private ProductService productService;
    private ProductRepository productRepository;

    public ProShopController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fetchProducts() {
        productRepository.fetchProducts().forEach(p -> logger.info("Product: " + p.getName() + " cost: " + p.getPrice() + " and you have discount " + productService.calculateDiscount(p)));
    }
}
