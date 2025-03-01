package com.company.modulejava.lecture13.ex3.interfaces;

@FunctionalInterface
public interface MyConsumer<T> {

    void consume(T value);
}
