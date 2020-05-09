package com.fw.teai_pd1.service;

import com.fw.teai_pd1.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    @Value("${tax.vat}")
    private double vatRate;

    @Value("${discount}")
    private double discount;

    public BigDecimal calculatePriceWithVatTax(Product product) {
        BigDecimal tax = product.getPrice().multiply(new BigDecimal(vatRate));
        return product.getPrice().add(tax);
    }

    public BigDecimal calculateDiscount(Product product) {
        return product.getPrice().multiply(new BigDecimal(discount));
    }
}
