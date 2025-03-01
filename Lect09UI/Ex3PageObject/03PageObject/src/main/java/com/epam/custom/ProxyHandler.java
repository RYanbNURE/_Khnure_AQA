package com.epam.custom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private final ElementLocator locator;

    public ProxyHandler(ElementLocator locator) {
        this.locator = locator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        WebElement element = locator.findElement();
        if ("click".equals(method.getName()) && args == null) {
            // Add additional logic here if needed before click
            System.out.println("Clicking on button element");
        }
        return method.invoke(element, args);
    }
}
