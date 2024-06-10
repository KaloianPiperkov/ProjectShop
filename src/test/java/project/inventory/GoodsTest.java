package project.inventory;

import org.junit.jupiter.api.Test;
import project.cashier.Cashier;
import project.cashier.CashierManager;
import project.checkout.Receipt;
import project.checkout.ReceiptManager;
import project.shop.OverchargeCalculator;
import project.shop.Shop;
import project.shop.ShopCosts;
import project.shop.ShopIncome;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoodsTest {

    @Test
    void testCalculateSellingPrice() {

        CashierManager cashierManager = new CashierManager();
        InventoryManager inventoryManager = new InventoryManager();
        ReceiptManager receiptManager = new ReceiptManager();
        List<Cashier> cashiers = cashierManager.getCashiers();
        List<Goods> goodsList = new ArrayList<>();
        List<Receipt> receipts = receiptManager.getReceipts();
        ShopCosts shopCosts = new ShopCosts(cashiers, goodsList);
        ShopIncome shopIncome = new ShopIncome(receipts);

        OverchargeCalculator overchargeCalculator = new OverchargeCalculator();
        Shop shop = new Shop("Shop",cashierManager, inventoryManager, receiptManager, shopCosts,shopIncome,BigDecimal.valueOf(2.5),BigDecimal.valueOf(3.5));
        GoodsSellingPriceCalculator goodsSellingPriceCalculator = new GoodsSellingPriceCalculator(overchargeCalculator, shop, 3);
        Goods goods = new Goods(1L, "Apple", BigDecimal.valueOf(50), Category.FOOD, LocalDate.now().plusDays(5), 10, goodsSellingPriceCalculator);

        BigDecimal expectedSellingPrice = BigDecimal.valueOf(51.25);
        assertEquals(expectedSellingPrice, goods.calculateSellingPrice());
    }

    @Test
    void testSetQuantity() {
        CashierManager cashierManager = new CashierManager();
        InventoryManager inventoryManager = new InventoryManager();
        ReceiptManager  receiptManager = new ReceiptManager();
        List<Cashier> cashiers = cashierManager.getCashiers();
        List<Goods> goodsList = new ArrayList<>();
        List<Receipt> receipts = receiptManager.getReceipts();
        ShopCosts shopCosts = new ShopCosts(cashiers, goodsList);
        ShopIncome shopIncome = new ShopIncome(receipts);

        OverchargeCalculator overchargeCalculator = new OverchargeCalculator();
        Shop shop = new Shop("Shop",cashierManager, inventoryManager, receiptManager, shopCosts,shopIncome,BigDecimal.valueOf(2.5),BigDecimal.valueOf(3.5));
        GoodsSellingPriceCalculator goodsSellingPriceCalculator = new GoodsSellingPriceCalculator(overchargeCalculator, shop, 3);
        Goods goods = new Goods(1L, "Apple", BigDecimal.valueOf(50), Category.FOOD, LocalDate.now().plusDays(5), 10, goodsSellingPriceCalculator);

        goods.setQuantity(5);
        assertEquals(5, goods.getQuantity());
    }
}