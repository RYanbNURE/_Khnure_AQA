package com.company.modulejava.lecture15.ex1;

public class Main {

//    We can get Class of an object using three methods – through static variable class, using getClass() method of object and java.lang.Class.forName(String fullyClassifiedClassName).
//    For primitive types and arrays, we can use static variable class.
//    Wrapper classes provide another static variable TYPE to get the class.

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> concreteClass = ConcreteClass.class; //static variable class
        Class<?> concreteClass1 = new ConcreteClass(5).getClass(); // using getClass()
        try {
            Class<?> concreteClass2 = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass");
            System.out.println(concreteClass2.getCanonicalName()); // prints com.company.modulejava.lecture15.ex1.ConcreteClass
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName()); // prints com.company.modulejava.lecture15.ex1.ConcreteClass
        System.out.println(concreteClass1.getCanonicalName()); // prints com.company.modulejava.lecture15.ex1.ConcreteClass

        //for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName()); // prints boolean

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double

        Class<?> cDoubleArray = null;
        try {
            cDoubleArray = Class.forName("[D");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(cDoubleArray.getCanonicalName()); //prints double[]

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]
// Get Super Class
        Class<?> superClass = Class.forName("com.company.modulejava.lecture15.ex1.ConcreteClass").getSuperclass();
        System.out.println(superClass); // prints "class com.company.modulejava.lecture15.ex1.ConcreteClasss"
        System.out.println(Object.class.getSuperclass()); // prints "null"
        System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"
    }
}

