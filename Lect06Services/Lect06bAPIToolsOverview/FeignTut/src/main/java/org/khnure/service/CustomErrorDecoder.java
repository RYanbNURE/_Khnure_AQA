package org.khnure.service;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        // Повертаємо користувацькі виключення в залежності від статусу відповіді
        return switch (response.status()) {
            case 404 -> new RuntimeException("Ресурс не знайдено!");
            case 400 -> new IllegalArgumentException("Запит містить помилку!");
            default -> new Exception("Загальна помилка сервісу");
        };
    }
}
