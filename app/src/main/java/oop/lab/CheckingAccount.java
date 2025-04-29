package oop.lab;

public class CheckingAccount extends BankAccount implements OnlineService {

    public CheckingAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        // No interest for checking account
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
