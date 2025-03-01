package com.company.modulejava.lecture3;

public class Array7Copy {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] positiveNumbers = numbers;    // copying arrays

//        for (int number : positiveNumbers) {
//            System.out.print(number + ", ");
//        }


        // change value of first array
        numbers[0] = -1;

        // printing the second array
        for (int number : positiveNumbers) {
            System.out.print(number + ", ");
        }
    }
}

