package com.company.command;

import com.company.Products.Product;

public class ProvideProductCommand extends Command {
    private Product product;
    private String productType;

    public ProvideProductCommand(String productType, Product product) {
        this.product = product;
        this.productType = productType;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductType() {
        return productType;
    }
}
