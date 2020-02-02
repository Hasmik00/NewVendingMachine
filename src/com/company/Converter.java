package com.company;

import com.company.Products.Chips.Doritos;
import com.company.Products.Chips.Lays;
import com.company.Products.Chips.Pringles;
import com.company.Products.Drinks.Coke;
import com.company.Products.Drinks.Fanta;
import com.company.Products.Drinks.Pepsi;
import com.company.Products.Product;
import com.company.Products.Snacks.Mars;
import com.company.Products.Snacks.Nuts;
import com.company.Products.Snacks.Snickers;
import com.company.command.Command;
import com.company.command.ProvideProductCommand;

public class Converter {

    public Command convert(Input input) throws Exception {
        String productType = " ";
        Product product = null;

        String[] inputToParts = input.getInput().split(":");

        if (inputToParts.length != 0) {
            if (inputToParts[0] != null) {
                switch (inputToParts[0].toLowerCase()) {
                    case "a":   //Drinks
                        productType = "Drinks";
                        if (Integer.parseInt(inputToParts[1]) == 1) product = new Coke();
                        else if (Integer.parseInt(inputToParts[1]) == 2) product = new Fanta();
                        else if (Integer.parseInt(inputToParts[1]) == 3) product = new Pepsi();
                        break;

                    case "b":   //Chips
                        productType = "Chips";
                        if (Integer.parseInt(inputToParts[1]) == 1) product = new Doritos();
                        else if (Integer.parseInt(inputToParts[1]) == 2) product = new Lays();
                        else if (Integer.parseInt(inputToParts[1]) == 3) product = new Pringles();
                        break;
                    case "c":   //Snacks
                        productType = "Snacks";
                        if (Integer.parseInt(inputToParts[1]) == 1) product = new Snickers();
                        else if (Integer.parseInt(inputToParts[1]) == 2) product = new Mars();
                        else if (Integer.parseInt(inputToParts[1]) == 3) product = new Nuts();
                        break;
                    default:
                        throw new Exception("Please select correct product type(A or B or C)");
                }
            }
        }
        return new ProvideProductCommand(productType, product);
    }

}
