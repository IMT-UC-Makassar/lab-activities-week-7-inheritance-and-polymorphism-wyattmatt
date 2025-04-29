package oop.lab;

public interface OnlineService {
    void transferFunds(double amount, String destinationAccountNumber);
    void payBills(double amount);
}
