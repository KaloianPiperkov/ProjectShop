package project.shop;

import project.cashier.CashierManager;
import project.cashier.ICashierManager;
import project.checkout.IReceiptManager;
import project.checkout.ReceiptManager;
import project.inventory.IInventoryManager;
import project.inventory.InventoryManager;

import java.math.BigDecimal;

//class that is a factory for creating shops
public class ShopFactory {
    public Shop createShop(String name, BigDecimal overchargePercentage, BigDecimal taxPercentage) {
        ICashierManager cashierManager = new CashierManager();
        IInventoryManager inventoryManager = new InventoryManager();
        IReceiptManager receiptManager = new ReceiptManager();
        ShopIncome shopIncome = new ShopIncome(receiptManager.getReceipts());
        ShopCosts shopCosts = new ShopCosts(cashierManager.getCashiers(), inventoryManager.getInventory());

        return new Shop(name, cashierManager, inventoryManager, receiptManager, shopCosts, shopIncome, overchargePercentage, taxPercentage);
    }
}