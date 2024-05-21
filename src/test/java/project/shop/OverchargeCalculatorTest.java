package project.shop;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.cashier.Cashier;
import project.cashier.CashierManager;
import project.checkout.Receipt;
import project.checkout.ReceiptManager;
import project.inventory.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OverchargeCalculatorTest {

    @Test
    void testCalculateOverchargePercentage() {
        OverchargeCalculator overchargeCalculator = new OverchargeCalculator();
        SellingPriceCalculation sellingPriceCalculation = mock(GoodsSellingPriceCalculator.class);
        CashierManager cashierManager = mock(CashierManager.class);
        InventoryManager inventoryManager = mock(InventoryManager.class);
        ReceiptManager receiptManager = mock(ReceiptManager.class);
        List<Receipt> receiptList = new ArrayList<>();
        List<Goods> goodsList = new ArrayList<>();
        List<Cashier> cashierList = new ArrayList<>();
        ShopIncome total_income = new ShopIncome(receiptList);
        ShopCosts total_costs = new ShopCosts(cashierList, goodsList);
        Shop shop = new Shop("Shop",cashierManager, inventoryManager, receiptManager, total_costs, total_income, BigDecimal.valueOf(10),BigDecimal.valueOf(20));
        shop.setFoodOverchargePercent(BigDecimal.valueOf(10));
        shop.setNonFoodOverchargePercent(BigDecimal.valueOf(20));

        Goods foodGoods = new Goods(1L, "Apple", BigDecimal.valueOf(1), Category.FOOD, LocalDate.now().plusDays(5), 10, sellingPriceCalculation);
        Goods nonFoodGoods = new Goods(2L, "Book", BigDecimal.valueOf(2), Category.NON_FOOD, LocalDate.now().plusDays(5), 20, sellingPriceCalculation);

        when(sellingPriceCalculation.calculateSellingPrice(foodGoods)).thenReturn(BigDecimal.valueOf(1.1));
        when(sellingPriceCalculation.calculateSellingPrice(nonFoodGoods)).thenReturn(BigDecimal.valueOf(2.4));


        assertThrows(IllegalArgumentException.class, () -> {
            overchargeCalculator.calculateOverchargePercentage(null, nonFoodGoods);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            overchargeCalculator.calculateOverchargePercentage(shop, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            overchargeCalculator.calculateOverchargePercentage(null, foodGoods);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            overchargeCalculator.calculateOverchargePercentage(shop, null);
        });

        BigDecimal foodOvercharge = overchargeCalculator.calculateOverchargePercentage(shop, foodGoods);
        BigDecimal nonFoodOvercharge = overchargeCalculator.calculateOverchargePercentage(shop, nonFoodGoods);

        assertEquals(BigDecimal.valueOf(10), foodOvercharge);
        assertEquals(BigDecimal.valueOf(20), nonFoodOvercharge);
    }
}