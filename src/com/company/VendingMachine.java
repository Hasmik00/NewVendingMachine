package com.company;

import com.company.Exception.SoldOutException;
import com.company.Products.Chips.Chips;
import com.company.Products.Chips.Doritos;
import com.company.Products.Chips.Lays;
import com.company.Products.Chips.Pringles;
import com.company.Products.Drinks.Coke;
import com.company.Products.Drinks.Drinks;
import com.company.Products.Drinks.Fanta;
import com.company.Products.Drinks.Pepsi;
import com.company.Products.Product;
import com.company.Products.Snacks.Mars;
import com.company.Products.Snacks.Nuts;
import com.company.Products.Snacks.Snacks;
import com.company.Products.Snacks.Snickers;
import com.company.command.Command;
import com.company.command.ProvideProductCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    protected Map<String, List<Product>> inventory;

    public VendingMachine() {
        initialize();
    }

    private void printBoard() {
        String inventoryItem = " ";
        for (Map.Entry<String, List<Product>> category : inventory.entrySet()) {
            System.out.println(category.getKey());
            System.out.println("------------------");
            System.out.println("Name    |    Count");
            System.out.println("------------------");
            List<Product> categoryItems = category.getValue();
            for (int i = 0; i < categoryItems.size(); i++) {
                Product product = categoryItems.get(i);
                System.out.println(product.getName() + "        " + product.getExistingCount());
            }
            System.out.println();
        }
    }

    private void provideProduct(ProvideProductCommand provideProductCommand) throws SoldOutException {
        List<Product> products = inventory.get(provideProductCommand.getProductType());

        for (Product items : products) {
            if (items.getClass() == provideProductCommand.getProduct().getClass()) {
                items.removeItem();
                System.out.println(items.getMessageVended());
            }
        }
    }

    public void process(Command command) {
        if (command.getClass() == ProvideProductCommand.class) {
            provideProduct((ProvideProductCommand) command);
        } else {
            printBoard();
        }
    }

    private void initialize() {
        this.inventory = new HashMap<String, List<Product>>();

        List<Product> drinks = new ArrayList<Product>();
        drinks.add(new Coke(3));
        drinks.add(new Fanta(3));
        drinks.add(new Pepsi(3));
        this.inventory.put("Drinks", drinks);

        List<Product> chips = new ArrayList<>();
        chips.add(new Doritos(3));
        chips.add(new Lays(3));
        chips.add(new Pringles(3));
        this.inventory.put("Chips", chips);

        List<Product> snacks = new ArrayList<>();
        snacks.add(new Snickers(3));
        snacks.add(new Mars(3));
        snacks.add(new Nuts(3));
        this.inventory.put("Snacks", snacks);
    }
}
