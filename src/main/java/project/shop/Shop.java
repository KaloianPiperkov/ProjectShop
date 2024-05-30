package project.shop;
import project.cashier.Cashier;
import project.cashier.ICashierManager;
import project.checkout.CashDesk;
import project.checkout.IReceiptManager;
import project.checkout.Receipt;
import project.customer.Customer;
import project.inventory.Goods;
import project.inventory.IInventoryManager;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Serializable {
    private final String shopName;
    private ICashierManager cashierManager;
    private IInventoryManager inventoryManager;
    private IReceiptManager receiptManager;
    private ShopCosts totalCosts;
    private ShopIncome totalIncome;
    private BigDecimal foodOverchargePercent;
    private BigDecimal nonFoodOverchargePercent;

    private List<Goods> goods;
    private List<CashDesk> cashDesks;
    private List<Customer> customers;
    private List<Cashier> cashiers;

    public Shop(String shop_name, ICashierManager cashierManager, IInventoryManager inventoryManager, IReceiptManager receiptManager, ShopCosts total_costs, ShopIncome total_income, BigDecimal foodOverchargePercent, BigDecimal nonFoodOverchargePercent) {
        if (shop_name == null || shop_name.isEmpty()) {
            throw new IllegalArgumentException("Shop name cannot be null or empty");
        }
        if (cashierManager == null || inventoryManager == null || receiptManager == null || total_costs == null || total_income == null || foodOverchargePercent == null || nonFoodOverchargePercent == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }
        if (foodOverchargePercent.compareTo(BigDecimal.ZERO) < 0 || nonFoodOverchargePercent.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Overcharge percentages cannot be negative");
        }
        this.shopName = shop_name;
        this.cashierManager = cashierManager;
        this.inventoryManager = inventoryManager;
        this.receiptManager = receiptManager;
        this.totalCosts = total_costs;
        this.totalIncome = total_income;
        this.foodOverchargePercent = foodOverchargePercent;
        this.nonFoodOverchargePercent = nonFoodOverchargePercent;

        this.goods = new ArrayList<>();
        this.cashDesks = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.cashiers = new ArrayList<>();

        Receipt receipt = new Receipt();
        receipt.setShop(this);
    }

    public void addGoods(Goods goods){
        this.goods.add(goods);
    }

    public void addCashDesk(CashDesk cashDesk){
        this.cashDesks.add(cashDesk);
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }


    public BigDecimal getFoodOverchargePercent() {
        return foodOverchargePercent;
    }

    public void setFoodOverchargePercent(BigDecimal foodOverchargePercent) {
        if (foodOverchargePercent == null || foodOverchargePercent.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Food overcharge percentage cannot be null or negative");
        }
        this.foodOverchargePercent = foodOverchargePercent;
    }


    public BigDecimal getNonFoodOverchargePercent() {
        return nonFoodOverchargePercent;
    }

    public void setNonFoodOverchargePercent(BigDecimal nonFoodOverchargePercent) {
        if (nonFoodOverchargePercent == null || nonFoodOverchargePercent.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Non-food overcharge percentage cannot be null or negative");
        }
        this.nonFoodOverchargePercent = nonFoodOverchargePercent;
    }

    public void addGoodsToShop(Shop shop,List<Goods> goodsList){
        for (Goods goods : goodsList){
            shop.addGoods(goods);
        }
    }

    public String getShopName() {
        return shopName;
    }


//    public void addGoodsToInventory(Goods goods){
//        this.inventoryManager.addGoods(goods);
//    }

    //    public ICashierManager getCashierManager() {
//        return cashierManager;
//    }
//
//    public IInventoryManager getInventoryManager() {
//        return inventoryManager;
//    }
//
//    public IReceiptManager getReceiptManager() {
//        return receiptManager;
//    }
//
//    public ShopCosts getTotal_costs() {
//        return total_costs;
//    }
//
//    public ShopIncome getTotal_income() {
//        return total_income;
//    }


    @Override
    public String toString() {
        return "Shop{" +
                "shop_name='" + shopName + '\'' +
                ", cashierManager=" + cashierManager +
                ", inventoryManager= " + inventoryManager +
                ", total_costs=" + totalCosts +
                ", total_income=" + totalIncome +
                '}';
    }
}
