package com.company.modulejava.lecture13.ex22;

import java.util.List;

public class JavaStreamExample {

    public static void main(String[] args) {
        List < Person > people = getPeople();

        // All match
        boolean allMatch = people.stream().allMatch(person -> person.getAge() > 8);

        System.out.println(allMatch);
        // Any match
        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 110);

        System.out.println(anyMatch);
        // None match
        boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println(noneMatch);
    }

    private static List < Person > getPeople() {
        return List.of(new Person("Antonio", 20, Gender.MALE), new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE), new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE), new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE));
    }
}

enum Gender {
    MALE,
    FEMALE
}

class Person {

    private final String name;
    private final int age;
    private final Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", gender=" + gender + '}';
    }
}