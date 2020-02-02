package com.company;

import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);
    private String input = sc.nextLine();


    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
