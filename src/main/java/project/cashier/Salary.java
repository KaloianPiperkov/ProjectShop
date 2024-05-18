package project.cashier;

import java.math.BigDecimal;

public class Salary implements SalaryCalculator {
    @Override
    public BigDecimal calculatingSalary(BigDecimal salaryPerHour, BigDecimal hoursWorked) {
        if (hoursWorked.compareTo(BigDecimal.ZERO) > 0) {
            return hoursWorked.multiply(salaryPerHour);
        } else {
            System.out.println("Cashier has not worked any hours this month.");
            return BigDecimal.ZERO;
        }
    }
}