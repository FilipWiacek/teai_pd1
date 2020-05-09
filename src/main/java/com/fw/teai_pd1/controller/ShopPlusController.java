package com.fw.teai_pd1.controller;

import com.fw.teai_pd1.repository.ProductRepository;
import com.fw.teai_pd1.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
@Profile("PLUS")
public class ShopPlusController {

    private static final Logger logger = LogManager.getLogger();

    private ProductRepository productRepository;
    private ProductService productService;

    @Autowired
    public ShopPlusController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fetchProducts() {
        productRepository.fetchProducts().forEach(p -> logger.info("Product: " + p.getName() + " cost: " + productService.calculatePriceWithVatTax(p)));
    }

}
