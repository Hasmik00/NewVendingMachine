package com.company.Products.Drinks;

public class Coke extends Drinks {
    public Coke(int existingCount) {
        super("Coca Cola", existingCount);
    }

    public Coke() {
        super("Coca Cola", 0);
    }
}
