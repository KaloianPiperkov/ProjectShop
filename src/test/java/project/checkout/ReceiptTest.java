package project.checkout;

import org.junit.jupiter.api.Test;
import project.inventory.Category;
import project.inventory.Goods;
import project.inventory.GoodsSellingPriceCalculator;
import project.inventory.SellingPriceCalculation;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    void testAddItemAndCalculateTotalValue() {
        SellingPriceCalculation sellingPriceCalculation = new GoodsSellingPriceCalculator();
        Goods goods = new Goods(1L, "Apple", BigDecimal.valueOf(50), Category.FOOD, LocalDate.now().plusDays(5), 10, sellingPriceCalculation);
        int quantity = 5;
        BigDecimal totalPrice = BigDecimal.valueOf(50);

        Receipt receipt = new Receipt();
        receipt.addItem(goods, quantity, totalPrice);

        assertEquals(totalPrice, receipt.calculateTotalValue());
    }

    @Test
    void testCalculateTotalValue() {
        SellingPriceCalculation sellingPriceCalculation = new GoodsSellingPriceCalculator();
        Goods goods1 = new Goods(1L, "Apple", BigDecimal.valueOf(50), Category.FOOD, LocalDate.now().plusDays(5), 10, sellingPriceCalculation);
        Goods goods2 = new Goods(2L, "Banana", BigDecimal.valueOf(30), Category.FOOD, LocalDate.now().plusDays(3), 20, sellingPriceCalculation);

        Receipt receipt = new Receipt();
        receipt.addItem(goods1, 5, BigDecimal.valueOf(250)); // 5 apples for a total of 250
        receipt.addItem(goods2, 10, BigDecimal.valueOf(300)); // 10 bananas for a total of 300

        BigDecimal expectedTotalValue = BigDecimal.valueOf(550); // 250 + 300 = 550
        BigDecimal actualTotalValue = receipt.calculateTotalValue();

        assertEquals(expectedTotalValue, actualTotalValue);
    }
}