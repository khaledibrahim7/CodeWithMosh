public class MortgageCalculator {
    public static final Byte MONTHS_IN_YEAR = 12;
    private static final Byte PERCENT = 100;
    private double principalLoan;
    private float annualInterestRate;
    private byte periodYears;

    public MortgageCalculator(double principalLoan, float annualInterestRate, byte periodYears) {
        this.principalLoan = principalLoan;
        this.annualInterestRate = annualInterestRate;
        this.periodYears = periodYears;
    }

    public double calculateBalance(int numberOfPaymentMade) {
        double monthlyInterestRate = getMonthlyInterestRate();
        int numberOfMonths = getNumberOfMonths();

        return principalLoan * (Math.pow(1 + monthlyInterestRate, numberOfMonths) - Math.pow(1 + monthlyInterestRate, numberOfPaymentMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }

    public double calculateMortgage() {
        double monthlyInterestRate = getMonthlyInterestRate();
        int numberOfMonths = getNumberOfMonths();

        return principalLoan *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }

    public double[] getRemainingBalance() {
        double[] balances = new double[getNumberOfMonths()];
        for (int month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }

        return balances;
    }

    private int getNumberOfMonths() {
        return periodYears * MONTHS_IN_YEAR;
    }

    private double getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }


}
