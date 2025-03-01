package com.company.modulejava.lecture14.ex8;

import com.company.modulejava.lecture14.ex8.devices.Dandy8bit;
import com.company.modulejava.lecture14.ex8.devices.MacOS;
import com.company.modulejava.lecture14.ex8.devices.MobilePhone;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Teenager jack = new Teenager();
//
//        jack.setDevice(new MacOS());
//
//        jack.playVideoGames();
//
//        jack.setDevice(new Dandy8bit());
//
//        jack.playVideoGames();
//
//        jack.setDevice(new MobilePhone());

        Class<? extends Teenager> aClass = jack.getClass();

//        System.out.println(aClass.getSuperclass());

//        System.out.println(aClass.getModifiers());

//        System.out.println(Modifier.toString(aClass.getModifiers()));
//
//        System.out.println(Arrays.toString(aClass.getInterfaces()));
//
//        Method[] publicMethods = aClass.getMethods();
//
//        Stream.of(publicMethods).forEach(System.out::println);

//        Method[] declaredMethods = aClass.getDeclaredMethods();
//
//        Stream.of(declaredMethods).forEach(System.out::println);

//        Field[] fields = aClass.getFields();
//
//        Stream.of(fields).forEach(System.out::println);

//        Field[] declaredFields = aClass.getDeclaredFields();
//
//        Stream.of(declaredFields).forEach(System.out::println);

//        Constructor<?>[] constructors = aClass.getConstructors();
//
//        Stream.of(constructors).forEach(System.out::println);

//        Annotation[] annotations = aClass.getAnnotations();
//
//        Stream.of(annotations).forEach(System.out::println);

        Class<?>[] classes = aClass.getClasses();

        Stream.of(classes).forEach(System.out::println);
    }
}
