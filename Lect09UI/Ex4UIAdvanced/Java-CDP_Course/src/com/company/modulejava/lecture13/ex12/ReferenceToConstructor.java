package com.company.modulejava.lecture13.ex12;

public class ReferenceToConstructor {
    public static void main(String[] args) {
//        Messageable hello = message -> new Message("Test");
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}

interface Messageable{
    Message getMessage(String msg);
}

class Message{
    Message(String msg){
        System.out.print(msg);
    }
}

