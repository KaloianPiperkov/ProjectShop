package project.shop;
import project.cashier.Cashier;
import project.cashier.ICashierManager;
import project.checkout.IReceiptManager;
import project.inventory.Goods;
import project.checkout.Receipt;
import project.inventory.IInventoryManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String shop_name;
    private ICashierManager cashierManager;
    private IInventoryManager inventoryManager;
    private IReceiptManager receiptManager;
    private ShopCosts total_costs;
    private ShopIncome total_income;
    private BigDecimal foodOverchargePercent;
    private BigDecimal nonFoodOverchargePercent;

    public Shop(String shop_name, ICashierManager cashierManager, IInventoryManager inventoryManager, IReceiptManager receiptManager, ShopCosts total_costs, ShopIncome total_income, BigDecimal foodOverchargePercent, BigDecimal nonFoodOverchargePercent) {
        this.shop_name = shop_name;
        this.cashierManager = cashierManager;
        this.inventoryManager = inventoryManager;
        this.receiptManager = receiptManager;
        this.total_costs = total_costs;
        this.total_income = total_income;
        this.foodOverchargePercent = foodOverchargePercent;
        this.nonFoodOverchargePercent = nonFoodOverchargePercent;
    }

    public BigDecimal getFoodOverchargePercent() {
        return foodOverchargePercent;
    }

    public void setFoodOverchargePercent(BigDecimal foodOverchargePercent) {
        this.foodOverchargePercent = foodOverchargePercent;
    }

    public BigDecimal getNonFoodOverchargePercent() {
        return nonFoodOverchargePercent;
    }

    public void setNonFoodOverchargePercent(BigDecimal nonFoodOverchargePercent) {
        this.nonFoodOverchargePercent = nonFoodOverchargePercent;
    }

    public String getShop_name() {
        return shop_name;
    }

    public ICashierManager getCashierManager() {
        return cashierManager;
    }

    public IInventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public IReceiptManager getReceiptManager() {
        return receiptManager;
    }

    public ShopCosts getTotal_costs() {
        return total_costs;
    }

    public ShopIncome getTotal_income() {
        return total_income;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "shop_name='" + shop_name + '\'' +
                ", cashierManager=" + cashierManager +
                ", total_costs=" + total_costs +
                ", total_income=" + total_income +
                '}';
    }
}
