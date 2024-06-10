package project.cashier;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//class that manages a list of cashiers
public class CashierManager implements ICashierManager, Serializable {
    private List<Cashier> cashiers;

    public CashierManager() {
        this.cashiers = new ArrayList<>();
    }

    @Override
    public List<Cashier> getCashiers() {
        return cashiers;
    }

    //method that adds a cashier to the list
    @Override
    public void addCashier(Cashier cashier) {
        if (cashier == null) {
            throw new IllegalArgumentException("Cashier cannot be null");
        }
        cashiers.add(cashier);
    }

    //method that returns the salary of the cashier
    @Override
    public BigDecimal getCashierSalary(long cashierId) {
        for (Cashier cashier : cashiers) {
            if (cashier.getId_of_cashier() == cashierId) {
                return cashier.getSalary();
            }
        }
        throw new IllegalArgumentException("Cashier with id " + cashierId + " does not exist");
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