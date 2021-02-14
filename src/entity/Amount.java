package entity;

public class Amount {

    private char currency;
    private double numberAmount;

    public Amount(char currency, double numberAmount) {
        this.currency = currency;
        this.numberAmount = numberAmount;
    }

    public char getCurrency() {
        return currency;
    }

    public double getNumberAmount() {
        return numberAmount;
    }
}
