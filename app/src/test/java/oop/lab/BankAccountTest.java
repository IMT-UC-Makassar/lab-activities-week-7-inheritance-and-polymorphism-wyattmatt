package oop.lab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// Assume your main classes are in the same package or imported.

class BankAccountTest {

    private SavingsAccount savingsAccount;
    private CheckingAccount checkingAccount;
    private BusinessAccount businessAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount("SAV123", "Alice", 1000.0);
        checkingAccount = new CheckingAccount("CHK456", "Bob", 500.0);
        businessAccount = new BusinessAccount("BUS789", "Charlie", 10000.0);
    }

    @Test
    void testDeposit() {
        savingsAccount.deposit(500.0);
        assertEquals(1500.0, savingsAccount.getBalance());
    }

    @Test
    void testWithdrawValid() {
        checkingAccount.withdraw(200.0);
        assertEquals(300.0, checkingAccount.getBalance());
    }

    @Test
    void testWithdrawInvalid_OverBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            savingsAccount.withdraw(2000.0); // More than balance
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testCalculateInterestSavingsAccount() {
        savingsAccount.calculateInterest();
        assertTrue(savingsAccount.getBalance() > 1000.0); // New balance must be bigger
    }

    @Test
    void testCalculateInterestCheckingAccount() {
        checkingAccount.calculateInterest();
        assertEquals(500.0, checkingAccount.getBalance()); // Assume checking accounts have no interest
    }

    @Test
    void testCalculateInterestBusinessAccount() {
        businessAccount.calculateInterest();
        assertTrue(businessAccount.getBalance() > 10000.0);
    }

    @Test
    void testTransferFunds() {
        savingsAccount.transferFunds(200.0, "CHK456");
        assertEquals(800.0, savingsAccount.getBalance());
    }

    @Test
    void testPayBills() {
        checkingAccount.payBills(100.0);
        assertEquals(400.0, checkingAccount.getBalance());
    }

    @Test
    void testLoanApplication() {
        businessAccount.applyForLoan(5000.0);
        String status = businessAccount.checkLoanStatus();
        assertEquals("Pending", status); // Assuming initial status is Pending
    }

    @Test
    void testPolymorphicAccountArray() {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV111", "Daisy", 1500));
        accounts.add(new CheckingAccount("CHK222", "Evan", 800));
        accounts.add(new BusinessAccount("BUS333", "Fiona", 20000));

        for (BankAccount account : accounts) {
            account.calculateInterest();
            assertTrue(account.getBalance() >= 800); // Just a generic safety check
        }
    }
}

class CardTest {

    private Card debitCard;
    private Card creditCard;
    private Card platinumCard;

    @BeforeEach
    void setUp() {
        debitCard = new DebitCard("CARD001", "Alice");
        creditCard = new CreditCard("CARD002", "Bob");
        platinumCard = new PlatinumCard("CARD003", "Charlie");
    }

    @Test
    void testDebitCardInterestRate() {
        assertEquals(0.0, debitCard.getInterestRate());
    }

    @Test
    void testCreditCardInterestRate() {
        assertEquals(15.0, creditCard.getInterestRate());
    }

    @Test
    void testPlatinumCardInterestRate() {
        assertEquals(10.0, platinumCard.getInterestRate());
    }
}


