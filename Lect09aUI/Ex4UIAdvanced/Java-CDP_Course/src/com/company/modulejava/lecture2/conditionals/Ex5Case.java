package com.company.modulejava.lecture2.conditionals;

import java.util.Scanner;

public class Ex5Case {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int weekday = sin.nextInt();

        switch (weekday) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
        }

    }
}
