package project.shop;
import project.cashier.Cashier;
import project.inventory.Goods;
import project.checkout.Receipt;

import java.util.ArrayList;
import java.util.List;

public class Shop{
    private String shop_name;
    private List<Cashier> cashiers;
    private List<Goods> inventory;
    private List<Receipt> receipts;
    private ShopCosts total_costs;
    private ShopIncome total_income;

    public Shop(String shop_name, List<Cashier> cashiers, List<Goods> inventory, List<Receipt> receipts, ShopCosts total_costs, ShopIncome total_income) {
        this.shop_name = shop_name;
        this.cashiers = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.receipts = new ArrayList<>();
        this.total_costs = total_costs;
        this.total_income = total_income;
    }

    public String getShop_name() {
        return shop_name;
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public List<Goods> getInventory() {
        return inventory;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public ShopIncome getTotal_income() {
        return total_income;
    }

    public double getCashierSalary(long cashierId)
    {
        for (Cashier cashier : cashiers ){
            if (cashier.getId_of_cashier() == cashierId){
                return cashier.getSalary();
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "shop_name='" + shop_name + '\'' +
                ", cashiers=" + cashiers +
                ", inventory=" + inventory +
                ", receipts=" + receipts +
                ", total_costs=" + total_costs +
                ", total_income=" + total_income +
                '}';
    }
}
