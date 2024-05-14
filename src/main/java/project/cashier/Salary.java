package project.cashier;

public class Salary implements SalaryCalculator{
    @Override
    public double calculatingSalary(double salary_per_hour, double hours_worked) {
            double salary = 0.0;
            if(hours_worked > 0){
                salary = hours_worked * salary_per_hour;
                return salary;
            }
            else {
                System.out.println("Cashier has not worked any hours this month.");
                return 0;
            }
    }

}
