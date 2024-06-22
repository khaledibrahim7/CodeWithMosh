package com.tyeps;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    private static final Byte MONTHS_IN_YEAR = 12;
    private static final Byte PERCENT = 100;


    public static void main(String[] args) {

        double principalLoan = readNumber("Principal ($1k _ 1m): ", 1000, 1000000);

        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 0, 30);

        byte periodYears = (byte) readNumber("period (Years): ", 0, 30);

        printMortgage(annualInterestRate, periodYears, principalLoan);

        printPaymentSchedule(periodYears, principalLoan, annualInterestRate);
    }

    private static void printMortgage(float annualInterestRate, byte periodYears, double principalLoan) {
        double mortgage = calculateMortgage(annualInterestRate, periodYears, principalLoan);
        System.out.println();
        System.out.println("Mortgage: ");
        System.out.println("________________");
        System.out.println("Monthly payment" + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    private static void printPaymentSchedule(byte periodYears, double principalLoan, float annualInterestRate) {
        System.out.println("payment schedule ");
        System.out.println("_____________");

        for (int month = 1; month <= periodYears * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principalLoan, annualInterestRate, periodYears, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private static double calculateBalance(double principalLoan, float annualInterestRate, byte periodYears, int numberOfPaymentMade) {
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfMonths = periodYears * MONTHS_IN_YEAR;

        return principalLoan * ( Math.pow(1 + monthlyInterestRate, numberOfMonths) - Math.pow(1 + monthlyInterestRate, numberOfPaymentMade))
                /( Math.pow(1 + monthlyInterestRate, numberOfMonths)-1);
    }

    private static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a number between " + min + "and " + max);
        }
        return value;
    }

    private static double calculateMortgage(float annualInterestRate, int periodYears, double principalLoan) {
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfMonths = periodYears * MONTHS_IN_YEAR;

        return principalLoan *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }

}



