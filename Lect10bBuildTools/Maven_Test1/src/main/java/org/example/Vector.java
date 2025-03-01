package org.example;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double scalarMultiplication (double anotherVectorX, double anotherVectorY, double anotherVectorZ) {
        return this.x * anotherVectorX + this.y * anotherVectorY + this.z * anotherVectorZ;
    }

    public double scalarMultiplication (Vector anotherVector) {
        return this.x * anotherVector.x + this.y * anotherVector.y + this.z * anotherVector.z;
//        return scalarMultiplication(anotherVector.x, anotherVector.y, anotherVector.z);
    }

    public static void main(String[] args) {
        Vector a = new Vector(2, 2, 2);

        Vector b = new Vector(3, 3, 3);

        System.out.println(a.scalarMultiplication(b));

        a.scalarMultiplication(4, 4, 4);

    }
}
