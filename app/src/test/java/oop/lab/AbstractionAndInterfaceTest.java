package oop.lab;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AbstractionAndInterfaceTest {

    @Test
    void testSavingsAccountIsAbstractType() {
        SavingsAccount savings = new SavingsAccount("SAV001", "Alice", 2000.0);
        assertTrue(savings instanceof BankAccount); // Abstract class check
    }

    @Test
    void testSavingsAccountImplementsOnlineService() {
        SavingsAccount savings = new SavingsAccount("SAV001", "Alice", 2000.0);
        assertTrue(savings instanceof OnlineService); // Interface check
    }

    @Test
    void testCheckingAccountImplementsOnlineService() {
        CheckingAccount checking = new CheckingAccount("CHK001", "Bob", 1000.0);
        assertTrue(checking instanceof OnlineService); // Interface check
    }

    @Test
    void testBusinessAccountImplementsLoanService() {
        BusinessAccount business = new BusinessAccount("BUS001", "Charlie", 10000.0);
        assertTrue(business instanceof LoanService); // Interface check
    }

    @Test
    void testCardPolymorphism() {
        Card platinum = new PlatinumCard("CARD777", "Zoe");
        assertTrue(platinum instanceof Card);
        assertEquals(10.0, platinum.getInterestRate()); // Polymorphic override
    }

    @Test
    void testBusinessAccountPolymorphism() {
        BankAccount account = new BusinessAccount("BUS002", "CorpX", 50000.0);
        assertTrue(account instanceof BusinessAccount); // Downcasting check
        assertTrue(account instanceof OnlineService);   // Interface
        assertTrue(account instanceof LoanService);     // Second interface
    }

    @Test
    void testInterfacesWithCasting() {
        BankAccount acc = new BusinessAccount("BUS900", "CorpY", 20000);
        if (acc instanceof LoanService) {
            LoanService loanUser = (LoanService) acc;
            loanUser.applyForLoan(5000);
            assertEquals("Pending", loanUser.checkLoanStatus());
        }
    }
}
