package project.cashier;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    @Test
    void testCashierCreation() {
        // Setup
        String name = "John";
        long id = 347;

        // Exercise
        Cashier cashier = new Cashier(name, id);

        // Verify
        assertEquals(name, cashier.getName_of_cashier());
        assertEquals(id, cashier.getId_of_cashier());
    }

    @Test
    void testCashierSalarySetting() {
        // Setup
        Cashier cashier = new Cashier("Jane", 348);
        BigDecimal salary = BigDecimal.valueOf(1000);

        // Exercise
        cashier.setSalary(salary);

        // Verify
        assertEquals(salary, cashier.getSalary());
    }
}