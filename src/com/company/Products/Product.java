package com.company.Products;

import com.company.Exception.SoldOutException;

public abstract class Product {

    private String name;
    private int existingCount;
    private String messageVended;
    private String messageSoldOut;

    public Product(String name, int existingCount) {
        this.name = name;
        this.existingCount = existingCount;
        this.messageVended = "Thank you for order: " + name;
        this.messageSoldOut = "There is no " + name + " in stock";
    }

    public void removeItem() throws SoldOutException {
        if (existingCount > 0) {
            existingCount--;
            return;
        }
        throw new SoldOutException(this.messageSoldOut);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExistingCount() {
        return existingCount;
    }

    public void setExistingCount(int existingCount) {
        this.existingCount = existingCount;
    }

    public String getMessageVended() {
        return messageVended;
    }

    public String getMessageSoldOut() {
        return messageSoldOut;
    }
}
