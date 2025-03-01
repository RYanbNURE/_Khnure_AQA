package org.khnure.service;

import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class CustomConverterFactory extends Converter.Factory {
    @Override
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return value -> "Modified: " + value.toString();  // Простий приклад конвертації
    }
}