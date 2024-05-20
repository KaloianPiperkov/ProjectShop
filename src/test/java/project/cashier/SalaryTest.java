package project.cashier;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalaryTest {

    @Test
    void testSalaryCalculationNegativeHours() {
        SalaryCalculator salaryCalculator = new Salary();
        BigDecimal salaryPerHour = BigDecimal.valueOf(20);
        BigDecimal hoursWorked = BigDecimal.valueOf(-1);

        assertThrows(IllegalArgumentException.class, () -> {
            salaryCalculator.calculatingSalary(salaryPerHour, hoursWorked);
        });
    }

    @Test
    void testSalaryCalculationNegativeSalaryPerHour() {
        SalaryCalculator salaryCalculator = new Salary();
        BigDecimal salaryPerHour = BigDecimal.valueOf(-20);
        BigDecimal hoursWorked = BigDecimal.valueOf(20);

        //replace with actual exception
        assertThrows(IllegalArgumentException.class, () -> {
            salaryCalculator.calculatingSalary(salaryPerHour, hoursWorked);
        });
    }

    @Test
    void testSalaryCalculationLargeInputs() {
        SalaryCalculator salaryCalculator = new Salary();
        BigDecimal salaryPerHour = new BigDecimal("1000000000");
        BigDecimal hoursWorked = new BigDecimal("1000000000");

        BigDecimal expectedSalary = new BigDecimal("1000000000000000000");
        BigDecimal calculatedSalary = salaryCalculator.calculatingSalary(salaryPerHour, hoursWorked);

        assertEquals(expectedSalary, calculatedSalary);
    }
}
