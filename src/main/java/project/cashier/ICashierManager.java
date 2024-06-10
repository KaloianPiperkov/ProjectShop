package project.cashier;

import java.math.BigDecimal;
import java.util.List;

// interface that defines the methods that a cashier manager should implement
public interface ICashierManager {
    List<Cashier> getCashiers();
    void addCashier(Cashier cashier) throws IllegalArgumentException;
    BigDecimal getCashierSalary(long cashierId) throws IllegalArgumentException;
}