package project.cashier;

import java.math.BigDecimal;

//interface that defines the method for calculating a cashier's salary
public interface SalaryCalculator {
    BigDecimal calculatingSalary(BigDecimal salary_per_hour, BigDecimal hours_worked) throws IllegalArgumentException;
}