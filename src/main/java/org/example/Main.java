package org.example;

import com.sun.source.tree.WhileLoopTree;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Principal : input amount of loan
        //anual interest rate : 3.92%
        //years
        //return Mortgage: $xyz.81
        //https://www.wikihow.com/Calculate-Mortgage-Payments
        // mortgage = principal ((interest * (1+interest)exp years) / (1+interest)exp years -1)

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float mortgage;
        float annualInterest = 0;
        float monthlyInterest = 0;
        byte years = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency;

        while(true) {
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();
            if (principal <= 1_000_000 && principal >= 1_000) {
                break;
            }
            System.out.println("Please enter a number between 1,000 and 1,000,000");

        }

        while (true) {
            System.out.print("Interest Rate (0% - 30%): ");

            annualInterest = scanner.nextFloat();

            if (annualInterest > 30 || annualInterest <= 0){
                System.out.println("Please enter a number between 0 and 30");
                continue;
            }
            monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            break;
        }


        while (true) {
            System.out.print("Years (1 - 30): ");
            years = scanner.nextByte();

            if (years >= 1 && years <= 30) break;
            else System.out.println("Please enter a number between 0 and 30");
        }
        numberOfPayments = years * MONTHS_IN_YEAR;

        mortgage = (float) (principal * ( monthlyInterest * Math.pow( (1 + monthlyInterest) , (numberOfPayments)) / (Math.pow( (1 + monthlyInterest) , (numberOfPayments)) - 1) ));

        currency = NumberFormat.getCurrencyInstance();
        System.out.println("\n\nMortgage: " + currency.format(mortgage));

    }
}