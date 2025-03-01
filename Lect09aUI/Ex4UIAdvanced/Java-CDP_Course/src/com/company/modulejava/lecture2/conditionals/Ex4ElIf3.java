package com.company.modulejava.lecture2.conditionals;

public class Ex4ElIf3 {

    public static void main(String[] args) {
        String month = "Saptember";

        if (month.equals("December") ||month.equals("January") || month.equals("February")){
            System.out.println("It's winter");
        } else if (month.equals("March") ||month.equals("April") || month.equals("May")){
            System.out.println("It's spring");
        } else if (month.equals("June") ||month.equals("July") || month.equals("August")) {
            System.out.println("It's summer");
        } else if (month.equals("September") ||month.equals("October") || month.equals("November")) {
            System.out.println("It's autumn");
        }
        else {
            System.out.println("Wrong value");
        }

        switch (month) {
            case "December":
            case "January":
            case "February":
                System.out.println("It's winter");
                break;

            case "March":
            case "April":
            case "May":
                System.out.println("It's spring");
                break;

            case "June":
            case "July":
            case "August":
                System.out.println("It's summer");
                break;

            case "September":
            case "October":
            case "November":
                System.out.println("It's fall");
                break;

            default:
                System.out.println("It's invalid value");
        }


    }
}
