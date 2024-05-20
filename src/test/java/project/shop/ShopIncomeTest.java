package project.shop;

import org.junit.jupiter.api.Test;
import project.checkout.Receipt;
import project.inventory.Category;
import project.inventory.Goods;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShopIncomeTest {

    @Test
    void testCalculateTotalIncome() {
        List<Receipt> receipts = new ArrayList<>();
        Receipt receipt1 = new Receipt();
        Goods goods1 = new Goods(1L, "Apple", BigDecimal.valueOf(50), Category.FOOD, LocalDate.now().plusDays(5), 10, null);
        receipt1.addItem(goods1, 2, BigDecimal.valueOf(100));
        receipts.add(receipt1);

        Receipt receipt2 = new Receipt();
        Goods goods2 = new Goods(2L, "Book", BigDecimal.valueOf(100), Category.NON_FOOD, LocalDate.now().plusDays(5), 20, null);
        receipt2.addItem(goods2, 2, BigDecimal.valueOf(200));
        receipts.add(receipt2);

        ShopIncome shopIncome = new ShopIncome(receipts);
        BigDecimal totalIncome = shopIncome.calculateTotalIncome();

        assertEquals(BigDecimal.valueOf(300), totalIncome);
    }
}