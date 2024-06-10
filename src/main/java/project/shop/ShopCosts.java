package project.shop;

import project.cashier.Cashier;
import project.cashier.Salary;
import project.inventory.Goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

//class that calculates the total costs of the shop
public class ShopCosts implements CalculatingTotalCost , Serializable {
    private List<Cashier> cashiers;
    private List<Goods> goods;
    private BigDecimal totalCost;

    public ShopCosts(List<Cashier> cashiers, List<Goods> goods) {
        if (cashiers == null || goods == null) {
            throw new IllegalArgumentException("Cashiers and goods lists cannot be null");
        }
        this.cashiers = cashiers;
        this.goods = goods;
        this.totalCost = calculateTotalCost();
    }

    @Override
    public BigDecimal calculateTotalCost() {
        totalCost = BigDecimal.ZERO; // Reset totalCost to zero

        for (Cashier cashier : cashiers) {
            BigDecimal salary = cashier.getSalary();
            if (salary != null) {
                totalCost = totalCost.add(salary);
            }
            else {
                throw new IllegalArgumentException("Salary cannot be null");
            }
        }

        for (Goods goodsItem : goods) {
            BigDecimal deliveryPrice = goodsItem.getDelivery_price();
            if (deliveryPrice != null) {
                totalCost = totalCost.add(deliveryPrice);
            }
            else{
                throw new IllegalArgumentException("Delivery price cannot be null");
            }
        }

        return totalCost;
    }

    @Override
    public String toString(){
        return "Total Costs: " + totalCost;
    }
}


