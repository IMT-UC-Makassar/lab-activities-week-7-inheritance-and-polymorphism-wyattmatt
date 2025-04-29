package oop.lab;

public class BusinessAccount extends BankAccount implements OnlineService, LoanService {

    private String loanStatus = "Not Applied";

    public BusinessAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.03;
        balance += interest;
    }

    @Override
    public void applyForLoan(double amount) {
        loanStatus = "Pending"; // simulate loan request
    }

    @Override
    public String checkLoanStatus() {
        return loanStatus;
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
