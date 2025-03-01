package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Field;
import java.util.Arrays;

public class Main_13_Field {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Field fieldInterfaceInt = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getField("interfaceInt");

//        Field Declaring Class
        Class<?> fieldClass = fieldInterfaceInt.getDeclaringClass();
        System.out.println(fieldClass.getCanonicalName());

//        Get Field Type
        Field fieldPublicInt = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getField("publicInt");
        Class<?> fieldType = fieldPublicInt.getType();
        System.out.println(fieldType.getCanonicalName());

        //  Get/Set Public Field Value
        ConcreteClass obj = new ConcreteClass(5);
        System.out.println(fieldPublicInt.get(obj)); //prints 5
        fieldPublicInt.setInt(obj, 10); //setting field value to 10 in object
        System.out.println(fieldPublicInt.get(obj)); //prints 10
    }
}

