package project.cashier;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalaryTest {

//        @org.junit.jupiter.api.Test
//        void calculatingSalary() {
//            Salary salary = new Salary();
//            assertEquals(0, salary.calculatingSalary(BigDecimal.valueOf(10), BigDecimal.valueOf(0)).intValue());
//            assertEquals(10, salary.calculatingSalary(BigDecimal.valueOf(10), BigDecimal.valueOf(1)).intValue());
//            assertEquals(20, salary.calculatingSalary(BigDecimal.valueOf(10), BigDecimal.valueOf(2)).intValue());
//        }

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
