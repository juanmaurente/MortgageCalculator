package org.example;

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

        int principal;
        double mortgage;
        double interestRate;
        byte years;
        Scanner scanner = new Scanner(System.in);
        NumberFormat currency;

        System.out.print("Principal: " );
        principal = scanner.nextInt();
        System.out.print("Interest Rate (%): ");
        interestRate = ( scanner.nextDouble() ) / 12 / 100 ;
        System.out.print("Years: ");
        years = scanner.nextByte();

        double exp1 = Math.pow( (1 + interestRate) , (years * 12));
        mortgage = principal * ( interestRate*exp1 / (exp1 - 1) );

        currency = NumberFormat.getCurrencyInstance();

        System.out.println("Principal: " + principal + "Interest: "+ interestRate + "Years: " + years);
        System.out.println("\n\nMortgage: " + currency.format(mortgage));

    }
}