public class Main {
    public static void main(String[] args) {

        double principalLoan = Console.readNumber("Principal ($1k _ 1m): ", 1000, 1000000);

        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 0, 30);

        byte periodYears = (byte) Console.readNumber("period (Years): ", 0, 30);

        MortgageCalculator calculator = new MortgageCalculator(principalLoan, annualInterestRate, periodYears);

        MortgageReport report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}
