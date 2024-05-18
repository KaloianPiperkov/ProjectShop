package project.cashier;

import java.math.BigDecimal;

public class Salary implements SalaryCalculator{
    @Override
    public BigDecimal calculatingSalary(BigDecimal salary_per_hour, BigDecimal hours_worked) {
        BigDecimal salary = BigDecimal.ZERO;
        if(hours_worked.compareTo(BigDecimal.ZERO) > 0){
            salary = hours_worked.multiply(salary_per_hour);
            return salary;
        }
        else {
            System.out.println("Cashier has not worked any hours this month.");
            return BigDecimal.ZERO;
        }
    }
}
