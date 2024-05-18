package project.shop;

import project.cashier.Cashier;
import project.inventory.Goods;

import java.math.BigDecimal;

public interface CalculatingTotalCost {
    public BigDecimal calculateTotalCost();
}
