package project.shop;

import project.cashier.Cashier;
import project.cashier.Salary;
import project.inventory.Goods;

import java.math.BigDecimal;
import java.util.List;

public class ShopCosts implements CalculatingTotalCost{
    private List<Cashier> cashiers;
    private List<Goods> goods;
    private BigDecimal total_cost;

    public ShopCosts(List<Cashier> cashiers, List<Goods> goods) {
        this.cashiers = cashiers;
        this.goods = goods;
    }

    @Override
    public BigDecimal calculateTotalCost() {

        total_cost = BigDecimal.ZERO; // Reset totalCost to zero

        for (Cashier cashier : cashiers) {
            total_cost = total_cost.add(cashier.getSalary());
        }

        for (Goods goodsItem : goods) {
            total_cost = total_cost.add(goodsItem.getDelivery_price());
        }
        return total_cost;
    }

    @Override
    public String toString() {
        return "ShopCosts{" +
                "total_cost=" + total_cost +
                '}';
    }
}
