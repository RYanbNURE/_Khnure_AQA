package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

public class Main_8_ImplementedInterfaces {


    public static void main(String[] args) throws ClassNotFoundException {
        Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();
//prints "[java.util.Map<K, V>, interface java.lang.Cloneable, interface java.io.Serializable]"
        System.out.println(Arrays.toString(interfaces));
//prints "[interface java.util.Map, interface java.lang.Cloneable, interface java.io.Serializable]"
        System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));

    }
}

