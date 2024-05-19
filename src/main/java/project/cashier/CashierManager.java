package project.cashier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CashierManager implements ICashierManager, Serializable {
    private List<Cashier> cashiers;

    public CashierManager() {
        this.cashiers = new ArrayList<>();
    }

    @Override
    public List<Cashier> getCashiers() {
        return cashiers;
    }

    @Override
    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }

    @Override
    public BigDecimal getCashierSalary(long cashierId) {
        for (Cashier cashier : cashiers) {
            if (cashier.getId_of_cashier() == cashierId) {
                return cashier.getSalary();
            }
        }
        return BigDecimal.valueOf(-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierManager{\n");
        for (Cashier cashier : cashiers) {
            sb.append("\t").append(cashier).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}