package project.cashier;

import java.math.BigDecimal;

public interface SalaryCalculator {
    BigDecimal calculatingSalary(BigDecimal salary_per_hour, BigDecimal hours_worked);
}
