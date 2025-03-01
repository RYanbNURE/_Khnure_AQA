package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_14_Method {


    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
//get method parameter types, prints "[class java.lang.Object, class java.lang.Object]"
        System.out.println(Arrays.toString(method.getParameterTypes()));
//get method return type, return "class java.lang.Object", class reference for void
        System.out.println(method.getReturnType());
//get method modifiers
        System.out.println(Modifier.toString(method.getModifiers())); //prints "public"


//  Invoking Public Method
        Map<String, String> hm = new HashMap<>();
        method.invoke(hm, "key", "value");
        System.out.println(hm);

//        Invoking Private Methods

        Method methodBaseClass = Class.forName("com.company.modulejava.lecture15.ex1.BaseClass").getDeclaredMethod("method3", null);
        method.setAccessible(true);
        method.invoke(null, null); //prints "Method3"
    }
}

