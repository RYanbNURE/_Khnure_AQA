package com.company.modulejava.lecture4;

public class Ex2Bicycle {

    public Ex2Bicycle(){}

    public Ex2Bicycle(int gear){
        this.gear = gear;
    }

    private int gear = 5;

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    //    public int gear = 5;

    // behavior or method
    public void braking(String nameOwner) {

        System.out.println("Using brakes by " + nameOwner);
        System.out.println("Working of Braking");
    }

    public static void main(String[] args) {
//        className object = new className();

// for Bicycle class
// create object

        Ex2Bicycle sportsBicycle = new Ex2Bicycle();

        Ex2Bicycle touringBicycle = new Ex2Bicycle();

        // access field and method
//        int gear = sportsBicycle.gear;
        int gear = sportsBicycle.getGear();

        sportsBicycle.braking("Jack");
    }
}
