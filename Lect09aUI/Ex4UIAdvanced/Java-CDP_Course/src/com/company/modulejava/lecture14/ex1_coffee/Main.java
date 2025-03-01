package com.company.modulejava.lecture14.ex1_coffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Client joe = new Client();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String joeBeverageFamilyChoice = reader.readLine();

        String joeBeverageChoice = reader.readLine();

        joe.orderBeverage(joeBeverageFamilyChoice, joeBeverageChoice);


    }
}
