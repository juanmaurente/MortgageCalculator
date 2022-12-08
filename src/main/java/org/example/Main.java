package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal = (int) readNumber("Principal: ",1000,1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate (0% - 30%): ", 0, 30);
        byte years = (byte) readNumber("Period (years): ", 0,30);

        double mortgage = calculateMortgage(principal,annualInterest,years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("\n\nMortgage: " + mortgageFormatted);
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float  monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short  numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        return  (principal * ( monthlyInterest * Math.pow( (1 + monthlyInterest) , (numberOfPayments)) / (Math.pow( (1 + monthlyInterest) , (numberOfPayments)) - 1) ));
    }
    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value <= max && value > min)
                break;
            System.out.println("Please enter a number between " + min +" and " + max);
        }
        return value;
    }

}