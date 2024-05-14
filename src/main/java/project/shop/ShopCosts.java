package project.shop;

import project.cashier.Cashier;
import project.cashier.Salary;
import project.inventory.Goods;

import java.util.List;

public class ShopCosts implements CalculatingTotalCost{
    private List<Cashier> cashiers;
    private List<Goods> goods;
    private double total_cost;

    public ShopCosts(List<Cashier> cashiers, List<Goods> goods) {
        this.cashiers = cashiers;
        this.goods = goods;
    }

    @Override
    public double calculateTotalCost() {

        for (Cashier cashier : cashiers){
            total_cost += cashier.getSalary();
        }

        for (Goods goods : goods){
            total_cost += goods.getDelivery_price();
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
