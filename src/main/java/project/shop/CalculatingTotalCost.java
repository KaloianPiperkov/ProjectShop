package project.shop;

import project.cashier.Cashier;
import project.inventory.Goods;

import java.math.BigDecimal;

//interface that defines a method for calculating the expenses/total cost of the shop
public interface CalculatingTotalCost {
    public BigDecimal calculateTotalCost();
}
