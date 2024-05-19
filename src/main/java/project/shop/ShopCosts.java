package project.shop;

import project.cashier.Cashier;
import project.cashier.Salary;
import project.inventory.Goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ShopCosts implements CalculatingTotalCost , Serializable {
    private List<Cashier> cashiers;
    private List<Goods> goods;
    private BigDecimal totalCost;

    public ShopCosts(List<Cashier> cashiers, List<Goods> goods) {
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
                System.out.println("---------SALARIES ARE NULL");
            }
        }

        for (Goods goodsItem : goods) {
            BigDecimal deliveryPrice = goodsItem.getDelivery_price();
            if (deliveryPrice != null) {
                totalCost = totalCost.add(deliveryPrice);
            }
            else{
                System.out.println("------Goods are null");
            }
        }

        return totalCost;
    }

    @Override
    public String toString(){
        return "Total Costs: " + totalCost;
    }
}


