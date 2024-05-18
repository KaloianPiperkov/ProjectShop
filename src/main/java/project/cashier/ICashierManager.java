package project.cashier;

import java.util.List;

public interface ICashierManager {
    List<Cashier> getCashiers();
    void addCashier(Cashier cashier);
    double getCashierSalary(long cashierId);
}
