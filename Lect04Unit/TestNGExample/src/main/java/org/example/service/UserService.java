package com.example.service;

// Сервіс для роботи з користувачами
public class UserService {
    // Метод для перевірки, чи користувач є повнолітнім
    public boolean isAdult(int age) {
        return age >= 18;
    }

    // Метод для привітання користувача
    public String greetUser(String name) {
        return "Привіт, " + name + "!";
    }
}