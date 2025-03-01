package com.epam.custom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CustomFieldDecorator implements FieldDecorator {

    private final ElementLocatorFactory factory;

    public CustomFieldDecorator(ElementLocatorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!WebElement.class.isAssignableFrom(field.getType()))
            return null;

        if (Arrays.stream(field.getAnnotations()).noneMatch(a -> a instanceof Button))
            return null;

        ElementLocator locator = factory.createLocator(field);
        // Return a proxy that manages instances of the field's declared type
        return Proxy.newProxyInstance(loader, new Class[]{WebElement.class}, new ProxyHandler(locator));
    }
}
