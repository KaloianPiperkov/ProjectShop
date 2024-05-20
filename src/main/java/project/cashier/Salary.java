package project.cashier;

import java.math.BigDecimal;

public class Salary implements SalaryCalculator {
    @Override
    public BigDecimal calculatingSalary(BigDecimal salaryPerHour, BigDecimal hoursWorked) {
        if (salaryPerHour == null || salaryPerHour.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary per hour cannot be null or negative");
        }
        if (hoursWorked == null || hoursWorked.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Hours worked cannot be null or negative");
        }
        if (hoursWorked.compareTo(BigDecimal.ZERO) > 0) {
            return hoursWorked.multiply(salaryPerHour);
        } else {
            System.out.println("Cashier has not worked any hours this month.");
            return BigDecimal.ZERO;
        }
    }
}