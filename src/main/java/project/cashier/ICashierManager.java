package project.cashier;

import java.math.BigDecimal;
import java.util.List;

public interface ICashierManager {
    List<Cashier> getCashiers();
    void addCashier(Cashier cashier);
    BigDecimal getCashierSalary(long cashierId);
}
