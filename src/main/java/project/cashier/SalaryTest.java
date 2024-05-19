package project.cashier;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryTest {

    @Test
    public void testSalaryCalculation() {
        // Setup
        SalaryCalculator salaryCalculator = new Salary();
        BigDecimal salaryPerHour = BigDecimal.valueOf(20);
        BigDecimal hoursWorked = BigDecimal.valueOf(20);

        // Exercise
        BigDecimal calculatedSalary = salaryCalculator.calculatingSalary(salaryPerHour, hoursWorked);

        // Verify
        assertEquals(BigDecimal.valueOf(400), calculatedSalary);
    }

    @Test
    public void testSalaryCalculationNoHoursWorked() {
        // Setup
        SalaryCalculator salaryCalculator = new Salary();
        BigDecimal salaryPerHour = BigDecimal.valueOf(20);
        BigDecimal hoursWorked = BigDecimal.ZERO;

        // Exercise
        BigDecimal calculatedSalary = salaryCalculator.calculatingSalary(salaryPerHour, hoursWorked);

        // Verify
        assertEquals(BigDecimal.ZERO, calculatedSalary);
    }
}