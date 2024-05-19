package project.cashier;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierManagerTest {
    @Test
    void testGetName() {
        // Setup
        Cashier cashier = new Cashier("Jane", 348);

        // Exercise
        char[] name = cashier.getName();

        // Verify
        assertArrayEquals("Jane".toCharArray(), name);
    }

}