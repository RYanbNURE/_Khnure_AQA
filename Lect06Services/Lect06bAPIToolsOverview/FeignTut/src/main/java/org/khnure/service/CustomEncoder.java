package org.khnure.service;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import org.khnure.model.User;

import java.lang.reflect.Type;

/**
 * Клас для власної серіалізації даних на відправку.
 */
public class CustomEncoder implements Encoder {
    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        // Код для серіалізації
        // Це тільки приклад. Наведено просту серіалізацію у JSON форматі
        String json = "{\"id\":" + ((User)object).getId() + ", \"name\":\"" + ((User)object).getName() + "\"}";
        template.body(json);
    }
}