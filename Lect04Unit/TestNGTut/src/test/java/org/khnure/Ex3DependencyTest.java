package org.khnure;

import org.testng.annotations.Test;

public class Ex3DependencyTest {

    @Test
    public void startCar() {
        // Перевірка старту машини
        System.out.println("Машина стартує.");
    }

    @Test(dependsOnMethods = {"startCar"})
    public void driveCar() {
        // Перевірка, що машина їде, тільки якщо вона успішно стартувала
        System.out.println("Машина їде.");
    }

    @Test(dependsOnMethods = {"driveCar"})
    public void stopCar() {
        // Перевірка зупинки машини, котра залежить від її руху
        System.out.println("Машина зупиняється.");
    }
}