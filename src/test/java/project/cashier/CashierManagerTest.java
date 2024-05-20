package project.cashier;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CashierManagerTest {

    @Test
    void testGetCashiersNoCashiers() {
        CashierManager cashierManager = new CashierManager();
        assertTrue(cashierManager.getCashiers().isEmpty());
    }

    @Test
    void testAddCashier() {
        CashierManager cashierManager = new CashierManager();
        Cashier cashier = new Cashier("John Doe", 1);
        cashierManager.addCashier(cashier);
        assertEquals(1, cashierManager.getCashiers().size());
        assertEquals(cashier, cashierManager.getCashiers().get(0));
    }

    @Test
    void testGetCashierSalaryExists() {
        CashierManager cashierManager = new CashierManager();
        Cashier cashier = new Cashier("John Doe", 1);
        cashier.setSalary(BigDecimal.valueOf(100));             // Set the salary for the cashier
        cashierManager.addCashier(cashier);
        assertEquals(BigDecimal.valueOf(100), cashierManager.getCashierSalary(1));
    }

    @Test
    void testGetCashierSalaryDoesNotExist() {
        CashierManager cashierManager = new CashierManager();
        assertEquals(BigDecimal.valueOf(-1), cashierManager.getCashierSalary(1));
    }
}