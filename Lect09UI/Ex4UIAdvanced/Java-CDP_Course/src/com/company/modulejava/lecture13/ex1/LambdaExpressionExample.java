package com.company.modulejava.lecture13.ex1;

public class LambdaExpressionExample {
    public static void main(String[] args) {
//        int width=10;

        //without lambda, Drawable implementation using anonymous class
        Drawable withoutLambda = new Drawable(){
            public void draw(){System.out.println("Drawing shape");}
        };

        Drawable hauseImpl = new Drawable() {
            @Override
                public void draw(){System.out.println("Drawing hause");}
        };
        withoutLambda.draw();
    }
}
