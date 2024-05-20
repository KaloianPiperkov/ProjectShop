package project.shop;

import org.junit.jupiter.api.Test;
import project.cashier.Cashier;
import project.inventory.Category;
import project.inventory.Goods;
import project.inventory.GoodsSellingPriceCalculator;
import project.inventory.SellingPriceCalculation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShopCostsTest {

    @Test
    void testCalculateTotalCost() {
        List<Cashier> cashiers = new ArrayList<>();
        Cashier cashier = new Cashier("John Doe", 1);
        cashier.setSalary(BigDecimal.valueOf(100));
        cashiers.add(cashier);


        SellingPriceCalculation sellingPriceCalculation = new GoodsSellingPriceCalculator();
        List<Goods> goods = new ArrayList<>();
        Goods goodsItem = new Goods(1L, "Apple", BigDecimal.valueOf(50), Category.FOOD, LocalDate.now().plusDays(5), 10, sellingPriceCalculation);
        goods.add(goodsItem);

        ShopCosts shopCosts = new ShopCosts(cashiers, goods);
        BigDecimal totalCost = shopCosts.calculateTotalCost();

        assertEquals(BigDecimal.valueOf(150), totalCost);
    }
}