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
    private double total_costs;
    private double total_income;

    public Shop(String shop_name, List<Cashier> cashiers, List<Goods> inventory, List<Receipt> receipts, double total_costs, double total_income) {
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

    public double getTotal_costs() {
        total_costs = 0;

        //implementation to get the total cost
        return total_costs;
    }

    public double getTotal_income() {
        return total_income;
    }


    //adding the cashiers and the goods to the shop????


    //calculate total cost and profit and income

}
