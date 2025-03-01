package com.company.modulejava.lecture14.ex8;

import com.company.modulejava.lecture12.ex1.FirstAnnotation;
import com.company.modulejava.lecture14.ex8.devices.Playable;

@FirstAnnotation
public class Teenager extends Person implements MyInterface, AnotherInterface{

    public Teenager(){}

    public Teenager(int age){
        this.age = age;
    }

    public Teenager(Playable playable){
        this.playingStrategy = playable;
    }

    private Playable playingStrategy;

    private int age;

    public int schoolScore;

    public void setDevice(Playable playingStrategy) {
        this.playingStrategy = playingStrategy;
    }

    public void playVideoGames() {
        playingStrategy.play();
    }

    private void myPrivateMethod(){
        System.out.println(1);
    }

    public class Pocket {}

    public class Cap {}

}
