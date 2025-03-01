package com.company.modulejava.lecture15.ex1;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_15_Constructor {


    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<?> constructor = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getConstructor(int.class);
//getting constructor parameters
        System.out.println(Arrays.toString(constructor.getParameterTypes())); // prints "[int]"

        Object myObj = constructor.newInstance(10);
        Method myObjMethod = myObj.getClass().getMethod("method1", null);
        myObjMethod.invoke(myObj, null); //prints "Method1 impl."

        Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
        System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"
        HashMap<String,String> myMap = (HashMap<String,String>) hashMapConstructor.newInstance(null);
    }
}

