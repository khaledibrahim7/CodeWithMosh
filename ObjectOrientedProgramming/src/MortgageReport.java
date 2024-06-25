import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println();
        System.out.println("Mortgage: ");
        System.out.println("________________");
        System.out.println("Monthly payment" + currency.format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println("payment schedule ");
        System.out.println("_____________");

        for (double balance : calculator.getRemainingBalance()) {
            System.out.println(currency.format(balance));
        }
    }
}
