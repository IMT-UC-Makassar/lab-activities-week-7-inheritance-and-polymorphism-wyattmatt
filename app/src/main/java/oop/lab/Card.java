package oop.lab;

public abstract class Card {
    protected String cardNumber;
    protected String cardHolder;

    public Card(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public abstract double getInterestRate();
}
