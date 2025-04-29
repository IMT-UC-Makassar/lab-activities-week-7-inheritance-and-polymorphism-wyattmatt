package oop.lab;

public class CreditCard extends Card {

    public CreditCard(String cardNumber, String cardHolder) {
        super(cardNumber, cardHolder);
    }

    @Override
    public double getInterestRate() {
        return 15.0;
    }
}
