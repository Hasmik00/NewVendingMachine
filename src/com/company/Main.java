package com.company;

import com.company.Exception.SoldOutException;
import com.company.Products.Product;
import com.company.command.Command;
import com.company.command.PrintBoardCommand;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        //printing Board
        vm.process(new PrintBoardCommand());

        //Processing order
        System.out.println("Please make your order...");
        Input order = new Input();
        Converter converter = new Converter();

        try {
            Command command = converter.convert(order);
            vm.process(command);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //printing Board
        vm.process(new PrintBoardCommand());
    }
}
