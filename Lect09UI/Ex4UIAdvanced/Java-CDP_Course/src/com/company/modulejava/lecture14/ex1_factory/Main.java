package com.company.modulejava.lecture14.ex1_factory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape hexagon = new Hexagon();
        hexagon.draw();
        Shape circle = new Circle();
        circle.draw();
        Shape req = new Rectangle();
        req.draw();
        Shape square = new Square();
        square.draw();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(hexagon);
        shapes.add(circle);
        shapes.add(req);
        shapes.add(square);

    }
}
