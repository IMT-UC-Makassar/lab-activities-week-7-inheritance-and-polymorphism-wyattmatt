package oop.lab;

public class SavingsAccount extends BankAccount implements OnlineService {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.02;
        balance += interest;
    }

    @Override
    public void transferFunds(double amount, String destinationAccountNumber) {
        super.transferFunds(amount, destinationAccountNumber);
    }

    @Override
    public void payBills(double amount) {
        super.payBills(amount);
    }
}
