package org.khnure.fakerdemo;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex1UserDataTest {

    private final Faker faker = new Faker();

    @Test
    void testUserEmailIsGenerated() {
        // Генерація випадкової електронної адреси
        String email = faker.internet().emailAddress();

        // Перевірка, що електронна адреса не є порожньою
        assertNotNull(email);
        assertTrue(email.contains("@"));

        System.out.println("Згенерована електронна адреса: " + email);
    }

    @Test
    void testUserNameIsGenerated() {
        // Генерація повного імені користувача
        String fullName = faker.name().fullName();

        // Перевірка, що ім'я не є порожнім
        assertNotNull(fullName);
        assertTrue(fullName.split(" ").length > 1);

        System.out.println("Згенероване повне ім'я: " + fullName);
    }

    @Test
    void testUserAddressIsGenerated() {
        // Генерація адреси
        String address = faker.address().fullAddress();

        // Перевірка, що адреса не є порожньою
        assertNotNull(address);

        System.out.println("Згенерована адреса: " + address);
    }
}
