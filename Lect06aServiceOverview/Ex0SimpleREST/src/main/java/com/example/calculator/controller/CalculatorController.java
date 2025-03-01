package com.example.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculate")
    public String calculate(@RequestParam double num1,
                            @RequestParam double num2,
                            @RequestParam String operation) {
        double result;
        switch (operation) {
            case "add" -> result = num1 + num2;
            case "subtract" -> result = num1 - num2;
            case "multiply" -> result = num1 * num2;
            case "divide" -> {
                if (num2 == 0) {
                    return "Error: Division by zero";
                }
                result = num1 / num2;
            }
            default -> {
                return "Error: Invalid operation";
            }
        }
        return String.format("%.2f %s %.2f = %.2f", num1, getOperationSymbol(operation), num2, result);
    }

    private String getOperationSymbol(String operation) {
        return switch (operation) {
            case "add" -> "+";
            case "subtract" -> "-";
            case "multiply" -> "*";
            case "divide" -> "/";
            default -> "?";
        };
    }
}